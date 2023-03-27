package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.entity.MetastaticLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MetastaticLineDto {
  private Long id ;
  private String name;
  private boolean checked;

  public MetastaticLineDto(MetastaticLine m){
  id=m.getHhhId();
  name=m.getNameFr();
  }
}
