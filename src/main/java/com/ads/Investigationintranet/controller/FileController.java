package com.ads.Investigationintranet.controller;

import com.ads.Investigationintranet.dto.FileData;
import com.ads.Investigationintranet.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/files")
public class FileController {


  @Autowired
  private FileService fileService;

  @GetMapping("/{trialHhhId}")
  public List<FileData> getFiles(@PathVariable("trialHhhId") int trialHhhId)  {
    return fileService.getFiles(trialHhhId);
  }

}

