package com.bz.mc.controller.schedule;

import com.bz.mc.controller.charge.ChargeGroupForm;
import com.bz.mc.controller.charge.ChargeItemFrom;
import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.shedule.StudentChargeGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class StudentChargeGroupFrom {
    private Long id;
    private Long studentRegistrationId;
    private Long chargeGroupId;
    private int activeStatus;
    private String remarks;
    private ChargeGroupForm chargeGroupFrom = new ChargeGroupForm();
    private List<ChargeGroupData> ChargeGroupFormList = new ArrayList<>();
    public StudentChargeGroupFrom(Long id, Long studentRegistrationId, Long chargeGroupId, int activeStatus, String remarks) {
        this.id = id;
        this.studentRegistrationId = studentRegistrationId;
        this.chargeGroupId = chargeGroupId;
        this.activeStatus = activeStatus;
        this.remarks = remarks;
    }
    public StudentChargeGroupFrom(StudentChargeGroup studentChargeGroup, List<ChargeGroupData> chargeGroupList){
        this.id=studentChargeGroup.getId();
        populateStudentChargeGroup(studentChargeGroup);
        populateChargeGroup(chargeGroupList);
    }
    public void populateStudentChargeGroup(StudentChargeGroup studentChargeGroup){
        this.id =studentChargeGroup.getId() ;
        this.studentRegistrationId = studentChargeGroup.getStudentRegistrationId();
        this.chargeGroupId = studentChargeGroup.getChargeGroupId();
        this.activeStatus = studentChargeGroup.getActiveStatus();
        this.remarks = studentChargeGroup.getRemarks();
    }

    public void populateChargeGroup(List<ChargeGroupData> chargeGroupList){
        for(ChargeGroupData c : chargeGroupList){
            ChargeGroupFormList.add(c);
        }
    }
    public StudentChargeGroupFrom(StudentChargeGroup studentChargeGroup) {
    }
    public boolean isPersisted() {
        return id != null;
    }
}
