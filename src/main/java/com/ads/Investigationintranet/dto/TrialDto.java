package com.ads.Investigationintranet.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrialDto {
    private Long id;
    private String title;
    private String protocolNumber;
    private String doctorPi;
    private String nctNumber;

    public TrialDto(Long id , String title , String protocolNumber , String nctNumber , String piFirstName ,String piLastName) {
        this.id=id;
        this.title= title;
        this.protocolNumber=protocolNumber;
        this.nctNumber=nctNumber;
        this.doctorPi=piFirstName +' '+ piLastName;
    }

}

