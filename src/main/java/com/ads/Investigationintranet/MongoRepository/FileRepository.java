//package com.ads.Investigationintranet.MongoRepository;
//import com.mongodb.client.gridfs.model.GridFSFile;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//
//import java.io.IOException;
//import java.util.List;
//
//
//@Repository
//public class FileRepository {
//
//  private final MongoTemplate mongoTemplate;
//
//  @Autowired
//  public FileRepository(MongoTemplate mongoTemplate) {
//    this.mongoTemplate = mongoTemplate;
//  }
//
//  /**
//   * Finds all PDF files for a given trialHhhId.
//   *
//   * @param trialHhhId the trialHhhId to search for.
//   * @return a list of GridFSFile objects representing PDF files.
//   * @throws Exception if there is an error while querying the database.
//   */
//  public List<GridFSFile> findPdfByTrialHhhId(int trialHhhId)  {
//    Query query = new Query(Criteria.where("metadata.trialHhhId").is(trialHhhId));
//    try {
//      List<GridFSFile> gridFSFiles = mongoTemplate.find(query, GridFSFile.class, "com.example.domain.uploads.File.files");
//      return gridFSFiles;
//    } catch (Exception ex) {
//      // Handle the exception or re-throw it as a more specific exception.
//      throw new RuntimeException("Error while querying the database", ex);
//    }
//  }
//}
//
//
