package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.entity.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityDto {
    private long id;
    private String name;
    private boolean checked;

    public SpecialityDto(Speciality speciality){
        id=speciality.getHhhId();
        name=speciality.getNameFr();
    }
}
