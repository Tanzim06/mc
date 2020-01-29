package com.bz.mc.controller.studentChargeGroup;

import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.Origin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChargeGroupForm {
    private Long id;
    private String chargeGroupName;
    private Long sessionId;
    private String sessionName;
    private Long programId;
    private String programName;
    private Long programSegmentId;
    private String segmentName;
    private int chargeCycle;
    private Origin origin;

//    public ChargeGroupForm(Long id) {
//        this.id = id;
//    }

    public ChargeGroupForm(ChargeGroup chargeGroup,String sessionName, String programName, String segmentName) {
        populateChargeGroup(chargeGroup,sessionName,programName,segmentName);

    }

    private void  populateChargeGroup(ChargeGroup chargeGroup,String sessionName,String programName,String segmentName){
        this.id = chargeGroup.getId();
        this.chargeGroupName = chargeGroup.getChargeGroupName();
        this.sessionId = chargeGroup.getSessionId();
        this.sessionName = sessionName;
        this.programId = chargeGroup.getProgramId();
        this.programName = programName;
        this.programSegmentId = chargeGroup.getProgramSegmentId();
        this.segmentName = segmentName;
        this.chargeCycle = chargeGroup.getChargeCycle();
        this.origin = chargeGroup.getOrigin();

    }


}
