package com.bz.mc.facade.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private int origin;
    private Long chargeGroupId;
    private Long itemId;
    private Double itemRate;
    private Long currencyId;
    private String remarks;
    private String itemName;
    private String sessionName;
    private String programName;
    private String segmentName;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private  LocalDate billDate;
    //private String currencyName;


    public ChargeGroupData(Long id, String chargeGroupName, int activeStatus, Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String itemName) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.activeStatus = activeStatus;
        this.chargeGroupId = chargeGroupId;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.itemName = itemName;

    }

    public ChargeGroupData(Long id, String chargeGroupName, int activeStatus, Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String remarks, String itemName) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.activeStatus = activeStatus;
        this.chargeGroupId = chargeGroupId;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.remarks = remarks;
        this.itemName = itemName;
    }

}
