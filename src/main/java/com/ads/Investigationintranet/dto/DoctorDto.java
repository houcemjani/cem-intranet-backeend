package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.domain.HumanResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private long id ;
    private String name;
    private boolean checked ;

    public DoctorDto(HumanResource d) {
     id=d.getHhhId();
     name=d.getFirstName()+' '+d.getLastName();
 }
}



