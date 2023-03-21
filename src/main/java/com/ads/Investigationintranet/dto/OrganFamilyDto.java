package com.ads.Investigationintranet.dto;

import com.ads.Investigationintranet.entity.OrganFamily;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganFamilyDto {
    private long id;
    private String name;
    private String code;
    private List<OrganDto> organs;
    private boolean checked;
    private String imageUrl;

    public OrganFamilyDto(OrganFamily family) {
        id = family.getHhhId();
        name = family.getNameFr();
        code = family.getCode();
        imageUrl = "assets/organFamily/" + code + ".jpg";
        organs = family.getOrgans().stream().map(OrganDto::new).collect(Collectors.toList());
    }

}


