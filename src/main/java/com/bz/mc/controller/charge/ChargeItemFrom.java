package com.bz.mc.controller.charge;

import com.bz.mc.model.charge.ChargeItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;


@Getter
@Setter
@NoArgsConstructor
public class ChargeItemFrom {

    private Long id;
    private Long chargeGroupId;
    private Long itemId;
    private Double itemRate;
    private Long currencyId;
    private String shortCode;
    private Long sessionId;
    private Long programId;
    private Long programSegmentId;
    private int chargeCycle;
    private int paymentCycle;
    private int activeStatus;
    private boolean active;
    private boolean individual;
    private String sActive;
    private String remarks;


    public ChargeItemFrom(ChargeItem chargeItem) {
        this.id = chargeItem.getId();
        this.chargeGroupId = chargeItem.getChargeGroupId();
        this.itemId = chargeItem.getItemId();
        this.itemRate = chargeItem.getItemRate();
        this.currencyId = chargeItem.getCurrencyId();
        this.shortCode = chargeItem.getShortCode();
        this.sessionId = chargeItem.getSessionId();
        this.programId = chargeItem.getProgramId();
        this.programSegmentId = chargeItem.getProgramSegmentId();
        this.chargeCycle = chargeItem.getChargeCycle();
        this.paymentCycle = chargeItem.getPaymentCycle();
        this.activeStatus = chargeItem.getActiveStatus();
        this.active = chargeItem.isActive();
        this.individual = chargeItem.isIndividual();
        this.sActive = chargeItem.getSActive();
        this.remarks = chargeItem.getRemarks();
    }

    public boolean isPersisted() {
        return id != null;
    }
}
