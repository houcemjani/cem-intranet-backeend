package com.ads.Investigationintranet.controller;

import com.ads.Investigationintranet.service.FileService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.model.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.client.gridfs.GridFSBucket;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

  private final GridFSBucket gridFSBucket;

  public FileController(MongoClient mongoClient) {
    MongoDatabase db = mongoClient.getDatabase("test");
    this.gridFSBucket = GridFSBuckets.create(db, "com.hhhpartners.innohealth.innogec.domain.uploads.File.files");
  }

  @GetMapping("/files/{fileId}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws IOException {
    ObjectId objectId = new ObjectId("5b0bf5df861b272f676404cd");

    GridFSFile file = gridFSBucket.find(Filters.eq("_id", objectId)).first();

    if (file == null) {
      System.out.println("File not found.");
    } else {
      System.out.println("File found: " + file.getFilename());
    }

    String contentType = file.getMetadata().getString("contentType");
    Resource resource = new InputStreamResource(gridFSBucket.openDownloadStream(objectId));

    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(resource);
  }
}



//    @Bean
//    public MongoClient mongoClient() {
//      return MongoClients.create("mongodb://localhost:27017");
//    }
//  @Autowired
//  private FileService fileService;

//  @GetMapping("/{trialHhhId}")
//  public ResponseEntity<byte[]> getFilesByTrialHhhId(@PathVariable Integer trialHhhId) throws IOException {
//    return fileService.getFilesByTrialHhhId(trialHhhId);
//  }

//  @Autowired
//  private MongoClient mongoClient;
//
//  @GetMapping("/files/{fileId}")
//  public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws IOException {
//    ObjectId objectId = new ObjectId(fileId);
//    MongoDatabase db = mongoClient.getDatabase("test");
//    GridFSBucket gridFSBucket = GridFSBuckets.create(db, "com.hhhpartners.innohealth.innogec.domain.uploads.File.files");
//
//    GridFSFile file = gridFSBucket.find(Filters.eq("_id", objectId)).first();
//    if (file == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    String contentType = file.getMetadata().getString("contentType");
//    Resource resource = new InputStreamResource(gridFSBucket.openDownloadStream(objectId));
//
//    return ResponseEntity.ok()
//        .contentType(MediaType.parseMediaType(contentType))
//        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//        .body(resource);
//  }
//
//}
