package com.ads.Investigationintranet.service.impl;


import com.ads.Investigationintranet.service.FileService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.commons.IOUtils;

import java.io.IOException;



@Service
public class FileServiceImpl implements FileService {

//  @Autowired
//  private GridFsOperations gridFsOperations;

//  @Override
//  public ResponseEntity<byte[]> getFilesByTrialHhhId(Integer trialHhhId) throws IOException {
//    Query query = new Query(Criteria.where("metadata.trialHhhId").is(trialHhhId));
//    GridFSFile file = gridFsOperations.findOne(query);
//
//    if (file == null) {
//      return ResponseEntity.notFound().build();
//    }
//
//    GridFsResource gridFsResource = gridFsOperations.getResource(file);
//
//    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.parseMediaType(file.getMetadata().get("contentType").toString()));
//    headers.setContentLength(gridFsResource.contentLength());
//    headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getFilename()).build());
//
//    try {
//      byte[] fileContent = IOUtils.toByteArray(gridFsResource.getInputStream());
//      return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
//    } catch (IOException e) {
//      e.printStackTrace();
//      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }
//  }


}


