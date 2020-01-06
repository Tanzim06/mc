package com.bz.mc.facade.data;

import com.bz.mc.model.charge.Origin;
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
    private Origin origin;
    private Long chargeGroupId;
    private Long itemId;
    private Double itemRate;
    private Long currencyId;
    private String remarks;
    private String itemName;
    private String sessionName;
    private String programName;
    private String segmentName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  LocalDate billDate;

    //private String currencyName;


    public ChargeGroupData(Long id, String chargeGroupName, int activeStatus,Origin origin, Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String itemName, LocalDate billDate) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.activeStatus = activeStatus;
        this.origin = origin;
        this.chargeGroupId = chargeGroupId;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.itemName = itemName;
        this.billDate = billDate;
    }


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


    public ChargeGroupData(Long id, String chargeGroupName, int activeStatus,Origin origin, Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String remarks, String itemName) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.activeStatus = activeStatus;
        this.origin  = origin;
        this.chargeGroupId = chargeGroupId;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.remarks = remarks;
        this.itemName = itemName;
    }

    public ChargeGroupData(Long id, String chargeGroupName, Long sessionId, Long programId, Long programSegmentId, int chargeCycle, Origin origin, Long chargeGroupId, String sessionName, String programName, String segmentName) {
        this.id = id;
        this.chargeGroupName = chargeGroupName;
        this.sessionId = sessionId;
        this.programId = programId;
        this.programSegmentId = programSegmentId;
        this.chargeCycle = chargeCycle;
        this.origin = origin;
        this.chargeGroupId = chargeGroupId;
        this.sessionName = sessionName;
        this.programName = programName;
        this.segmentName = segmentName;
    }

}
