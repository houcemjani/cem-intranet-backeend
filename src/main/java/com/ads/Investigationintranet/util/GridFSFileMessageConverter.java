//package com.ads.Investigationintranet.util;
//
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.client.gridfs.GridFSDownloadStream;
//import com.mongodb.client.gridfs.model.GridFSFile;
//import org.bson.types.ObjectId;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.HttpOutputMessage;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.ByteArrayHttpMessageConverter;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class GridFSFileMessageConverter implements HttpMessageConverter<List<GridFSFile>> {
//
//  private final GridFSBucket gridFSBucket;
//  private final ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
//
//  public GridFSFileMessageConverter(GridFSBucket gridFSBucket) {
//    this.gridFSBucket = gridFSBucket;
//  }
//
//  @Override
//  public boolean canRead(Class<?> clazz, MediaType mediaType) {
//    return false;
//  }
//
//  @Override
//  public boolean canWrite(Class<?> clazz, MediaType mediaType) {
//    return List.class.isAssignableFrom(clazz) && mediaType.equals(MediaType.APPLICATION_OCTET_STREAM);
//  }
//
//  @Override
//  public List<MediaType> getSupportedMediaTypes() {
//    List<MediaType> supportedMediaTypes = new ArrayList<>();
//    supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//    return supportedMediaTypes;
//  }
//
//  @Override
//  public List<GridFSFile> read(Class<? extends List<GridFSFile>> clazz, HttpInputMessage inputMessage) {
//    throw new UnsupportedOperationException();
//  }
//
//  @Override
//  public void write(List<GridFSFile> files, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
//    HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
//    response.setHeader("Content-Disposition", "attachment; filename=\"files.zip\"");
//    OutputStream outputStream = outputMessage.getBody();
//
//    for (GridFSFile file : files) {
//      ObjectId fileId = file.getObjectId();
//      GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(fileId);
//      byte[] buffer = new byte[1024];
//      int bytesRead;
//      while ((bytesRead = downloadStream.read(buffer)) > 0) {
//        outputStream.write(buffer, 0, bytesRead);
//      }
//      downloadStream.close();
//    }
//    outputStream.flush();
//  }
//}
//
