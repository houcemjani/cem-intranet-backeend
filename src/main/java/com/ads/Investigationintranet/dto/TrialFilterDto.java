package com.ads.Investigationintranet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrialFilterDto {

    private List<OrganDto> organs;
    private List<StateDto> states;
    private List<PhaseDto> phases;
    private List<MetastaticLineDto> lines;
    private List<IllnessStateDto> illnessStates;
    private String word;
    private int filterIndex;

}

