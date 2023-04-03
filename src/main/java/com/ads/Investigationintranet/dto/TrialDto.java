package com.ads.Investigationintranet.dto;
import com.ads.Investigationintranet.domain.contact.ContactSet;
import com.ads.Investigationintranet.domain.contact.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrialDto {
    private Long id;
    private String title;
    private String protocolNumber;
    private String doctorPi;
    private String clinicalResearchAssistant1;
    private String clinicalResearchAssistant2;
    private Long StateId;
    private List<PhoneDto> arc1PhoneNumbers;
    private List<PhoneDto> arc2PhoneNumbers;


    public TrialDto(
        Long id ,
        String title ,
        String protocolNumber ,
        String piFirstName ,
        String piLastName,
        String Arc1FistName,
        String Arc1LastName,
        String Arc2FistName,
        String Arc2LastName,
        Long stateId,
        ContactSet contact1,
        ContactSet contact2)
    {
        this.id=id;
        this.title= title;
        this.protocolNumber=protocolNumber;
        this.doctorPi=piFirstName +' '+ piLastName;
        if(Arc1FistName!=null)
            this.clinicalResearchAssistant1=Arc1FistName +' '+ Arc1LastName;
        if(Arc2FistName!=null){
            if (!(Arc1FistName +' '+ Arc1LastName).equals((Arc2FistName +' '+ Arc2LastName)))
                this.clinicalResearchAssistant2=Arc2FistName +' '+ Arc2LastName;
        }

        this.StateId=stateId;
        if (contact1!=null){
            List<PhoneDto> arc1PhoneNbr=new ArrayList<>();
            for (Phone phone : contact1.getPhones()) {
                PhoneDto phoneDto = new PhoneDto(phone.getHhhId(),phone.getValue());
                arc1PhoneNbr.add(phoneDto);
            }
            this.arc1PhoneNumbers=arc1PhoneNbr;
        }

        if (contact2!=null){
            List<PhoneDto> arc2PhoneNbr=new ArrayList<>();
            for (Phone phone : contact2.getPhones()) {
                PhoneDto phoneDto = new PhoneDto(phone.getHhhId(),phone.getValue());
                arc2PhoneNbr.add(phoneDto);
            }
            if (contact1!=null) {
                if(!this.arc1PhoneNumbers.equals(arc2PhoneNbr))
                    this.arc2PhoneNumbers=arc2PhoneNbr;
            }else{
                this.arc2PhoneNumbers=arc2PhoneNbr;
            }

        }



    }


}

