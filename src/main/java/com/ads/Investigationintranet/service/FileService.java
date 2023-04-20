package com.ads.Investigationintranet.service;

import com.ads.Investigationintranet.dto.FileData;

import java.util.List;

public interface FileService {

  List<FileData> getFiles(int trialHhhId) ;

}
