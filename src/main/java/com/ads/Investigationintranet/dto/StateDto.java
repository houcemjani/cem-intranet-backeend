package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.entity.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDto {
  private Long id ;
  private String name;
  private boolean checked;

  public StateDto(State state){
    id=state.getHhhId();
    name=state.getNameFr();
  }
}
