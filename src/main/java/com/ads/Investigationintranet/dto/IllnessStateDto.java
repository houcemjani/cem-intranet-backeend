package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.entity.IllnessState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IllnessStateDto {
  private Long id ;
  private String name;
  private boolean checked;

  public IllnessStateDto(IllnessState illnessState) {
    id=illnessState.getHhhId();
    name=illnessState.getNameFr();
  }
}
