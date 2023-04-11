//package com.ads.Investigationintranet.config;
//
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.client.gridfs.GridFSBuckets;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@Configuration
//public class MongoConfig {
//
//  @Bean
//  public MongoClient mongoClient() {
//    return MongoClients.create("mongodb://localhost:27017");
//  }
//
//  @Bean
//  public MongoTemplate mongoTemplate() {
//    return new MongoTemplate(mongoClient(), "test");
//  }
//
//  @Bean
//  public GridFSBucket gridFSBucket() {
//    MongoDatabase db = mongoClient().getDatabase("test");
//    return GridFSBuckets.create(db);
//  }
//
//}
