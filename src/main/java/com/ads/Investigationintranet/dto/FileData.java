package com.ads.Investigationintranet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileData {
  private byte[] data;
  private String filename;
  private String contentType;
  private Date uploadDate;

}