package com.ads.Investigationintranet.domain.fileStorage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfo {
    public String name;
    public String type;
    public String url;

}
