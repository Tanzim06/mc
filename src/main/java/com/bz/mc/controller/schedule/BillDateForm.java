package com.bz.mc.controller.schedule;

import com.bz.mc.controller.charge.ChargeGroupForm;
import com.bz.mc.facade.data.BillDateFormData;
import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.shedule.BillDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    private ChargeGroupForm chargeGroupForm = new ChargeGroupForm();
    private List<BillDateFormData> billdateFormList = new ArrayList<>();



    public BillDateForm(BillDate billDate, List<BillDateFormData> billdateList){
        this.id=billDate.getId();
        populateBillDate(billDate);
        populateChargeGroup(billdateList);

    }

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
    public void populateBillDate(BillDate billDate) {
        this.id = billDate.getId();
        this.chargeGroupId = billDate.getChargeGroupId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.billDate = formatter.format(billDate.getBillDate());
        this.slNo = billDate.getSlNo();
        this.year = billDate.getYear();
        this.activeStatus = billDate.getActiveStatus();
        this.remarks = billDate.getRemarks();
    }

    public void populateChargeGroup(List<BillDateFormData> billdateList){
        for(BillDateFormData b : billdateList){
            billdateFormList.add(b);
        }
    }


    public boolean isPersisted() {
        return id != null;
    }






}
