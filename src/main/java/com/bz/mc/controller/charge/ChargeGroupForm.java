package com.bz.mc.controller.charge;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.item.ItemInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChargeGroupForm {

    private Long id;
    private String chargeGroupName;
    private String shortCode;
    private Long sessionId;
    private Long programId;
    private Long programSegmentId;
    private int chargeCycle;
    private int paymentCycle;
    private int activeStatus;
    private boolean active;
    private boolean group;
    private String sActive;
    private String remarks;

    private ChargeItemFrom chargeItemFrom = new ChargeItemFrom();
    private List<ChargeGroupData> ChargeFormList = new ArrayList<>();

    public ChargeGroupForm(ChargeGroup chargeGroup) {
        this.id = chargeGroup.getId();
        this.chargeGroupName = chargeGroup.getChargeGroupName();
        this.shortCode = chargeGroup.getShortCode();
        this.sessionId = chargeGroup.getSessionId();
        this.programId = chargeGroup.getProgramId();
        this.programSegmentId = chargeGroup.getProgramSegmentId();
        this.chargeCycle = chargeGroup.getChargeCycle();
        this.paymentCycle = chargeGroup.getPaymentCycle();
        this.activeStatus = chargeGroup.getActiveStatus();
        this.active = chargeGroup.isActive();
        this.group = chargeGroup.isGroup();
        this.sActive =chargeGroup.getSActive();
        this.remarks = chargeGroup.getRemarks();
    }


    public ChargeGroupForm(ChargeGroup chargeGroup, List<ChargeGroupData> chargeItemList){
        this.id=chargeGroup.getId();
        populateChargeGroup(chargeGroup);
        populateChargeItem(chargeItemList);

    }

    public void populateChargeGroup(ChargeGroup chargeGroup){
        this.id =chargeGroup.getId() ;
        this.chargeGroupName = chargeGroup.getChargeGroupName();
        this.shortCode = chargeGroup.getShortCode();
        this. sessionId = chargeGroup.getSessionId();
        this. programId = chargeGroup.getProgramId();
        this.programSegmentId = chargeGroup.getProgramSegmentId();
        this. chargeCycle = chargeGroup.getChargeCycle();
        this. paymentCycle = chargeGroup.getPaymentCycle();
        this.activeStatus=chargeGroup.getActiveStatus();
        this. active = chargeGroup.isActive();
        this. group=chargeGroup.isGroup();
        this. sActive=chargeGroup.getSActive();
        this. remarks= chargeGroup.getRemarks();
    }


    public void populateChargeItem(List<ChargeGroupData> chargeItemList){
        for(ChargeGroupData c : chargeItemList){
            ChargeFormList.add(c);
        }
    }


    public boolean isPersisted() {
        return id != null;
    }
}
