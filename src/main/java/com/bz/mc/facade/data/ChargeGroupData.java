package com.bz.mc.facade.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ChargeGroupData {

    private Long id;
    private String chargeGroupName;
    private String shortCode;
    private Long sessionId;
    private Long programId;
    private Long programSegmentId;
    private int chargeCycle;
    private int paymentCycle;
    private int activeStatus;
    private Long chargeGroupId;
    private Long itemId;
    private Double itemRate;
    private Long currencyId;
    private String remarks;
    private String itemName;
    private String sessionName;
    private String programName;
    private String programSegmentName;

    //private String currencyName;


    public ChargeGroupData(Long id, String chargeGroupName, String shortCode, Long sessionId, Long programId, Long programSegmentId, int chargeCycle, int paymentCycle, int activeStatus, Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String remarks, String itemName, String sessionName) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.shortCode = shortCode;
        this.sessionId = sessionId;
        this.programId = programId;
        this.programSegmentId = programSegmentId;
        this.chargeCycle = chargeCycle;
        this.paymentCycle = paymentCycle;
        this.activeStatus = activeStatus;
        this.chargeGroupId = chargeGroupId;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.remarks = remarks;
        this.itemName = itemName;
        this.sessionName = sessionName;


    }

    public ChargeGroupData(Long id, String chargeGroupName, String shortCode, Long sessionId, Long programId, Long programSegmentId, int chargeCycle, int paymentCycle, int activeStatus, Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String remarks, String itemName, String sessionName, String programName, String programSegmentName) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.shortCode = shortCode;
        this.sessionId = sessionId;
        this.programId = programId;
        this.programSegmentId = programSegmentId;
        this.chargeCycle = chargeCycle;
        this.paymentCycle = paymentCycle;
        this.activeStatus = activeStatus;
        this.chargeGroupId = chargeGroupId;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.remarks = remarks;
        this.itemName = itemName;
        this.sessionName = sessionName;
        this.programName = programName;
        this.programSegmentName = programSegmentName;
    }
}
