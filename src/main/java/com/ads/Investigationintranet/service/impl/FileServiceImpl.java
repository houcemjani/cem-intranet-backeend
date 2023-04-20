package com.ads.Investigationintranet.service.impl;

import com.ads.Investigationintranet.dto.FileData;
import com.ads.Investigationintranet.service.FileService;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

  @Override
  public List<FileData> getFiles(int trialHhhId) {

    List<FileData> fileInfos = new ArrayList<>();

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
    MongoCollection<Document> filesCollection = mongoDatabase.getCollection("com.hhhpartners.innohealth.innogec.domain.uploads.File.files");
    MongoCollection<Document> chunksCollection = mongoDatabase.getCollection("com.hhhpartners.innohealth.innogec.domain.uploads.File.chunks", Document.class);

    Document query = new Document("metadata.trialHhhId", trialHhhId);
    try (MongoCursor<Document> cursor = filesCollection.find(query).iterator()) {
      while (cursor.hasNext()) {
        Document fileDoc = cursor.next();
        byte[] fileData = null;
        String filename = fileDoc.getString("filename");
        String contentType = fileDoc.getString("contentType");
        Date uploadDate = fileDoc.getDate("uploadDate");
        ObjectId fileId = fileDoc.getObjectId("_id");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (MongoCursor<Document> chunkCursor = chunksCollection.find(new Document("files_id", fileId)).sort(new Document("n", 1)).iterator()) {
          while (chunkCursor.hasNext()) {
            Binary chunkData = chunkCursor.next().get("data", Binary.class);
            byte[] chunkBytes = chunkData.getData();
            outputStream.write(chunkBytes);
          }
        }
        fileData = outputStream.toByteArray();
        FileData fileInfo = new FileData();
        fileInfo.setData(fileData);
        fileInfo.setFilename(filename);
        fileInfo.setContentType(contentType);
        fileInfo.setUploadDate(uploadDate);
        fileInfos.add(fileInfo);
      }
    } catch (Exception e) {
      throw new RuntimeException("Error retrieving files", e);
    } finally {
      mongoClient.close();
    }
    return fileInfos;
  }
}


