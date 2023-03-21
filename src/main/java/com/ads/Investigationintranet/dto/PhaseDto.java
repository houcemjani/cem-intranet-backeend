package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.entity.Phase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhaseDto {
   private long id;
    private String name;
    private boolean checked;

    public PhaseDto(Phase phase){
        id= phase.getHhhId();
        name= phase.getNameFr();
    }
}



