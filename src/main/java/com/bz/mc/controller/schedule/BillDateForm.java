package com.bz.mc.controller.schedule;

import com.bz.mc.model.shedule.BillDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor

public class BillDateForm {

    private Long id;
    private Long chargeGroupId;
    private String billDate;
    private int slNo;
    private int year;
    private int activeStatus;
    private String remarks;

    public BillDateForm(BillDate billDate) {
        this.id = billDate.getId();
        this.chargeGroupId = billDate.getChargeGroupId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.billDate = formatter.format(billDate.getBillDate());
        this.slNo = billDate.getSlNo();
        this.year = billDate.getYear();
        this.activeStatus = billDate.getActiveStatus();
        this.remarks = billDate.getRemarks();
    }

    public boolean isPersisted() {
        return id != null;
    }






}
