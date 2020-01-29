package com.bz.mc.controller.studentChargeGroup;

import com.bz.mc.controller.charge.ChargeGroupForm;
import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.Origin;
import com.bz.mc.model.shedule.StudentChargeGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class StudentChargeGroupForm {
    private Long id;
    private Long studentRegistrationId;
    private Long chargeGroupId;
    private int activeStatus;
    private String remarks;


    private String chargeGroupName;
    private Long sessionId;
    private String sessionName;
    private Long programId;
    private String programName;
    private Long programSegmentId;
    private String segmentName;
    private int chargeCycle;
    private Origin origin;

    private ChargeGroupForm chargeGroupFrom = new ChargeGroupForm();
//    private List<ChargeGroupData> ChargeGroupFormList = new ArrayList<>();
    private  List<EnrolStudentForm> enrolStudentDataList= new ArrayList<>();

    public StudentChargeGroupForm(StudentChargeGroup studentChargeGroup, List<EnrolStudentData> enrolStudentDataList){
        this.id=studentChargeGroup.getId();
        populateStudentChargeGroup(studentChargeGroup);
        populateEnrolStudent(enrolStudentDataList);
    }
    public void populateStudentChargeGroup(StudentChargeGroup studentChargeGroup){
        this.id =studentChargeGroup.getId() ;
        this.studentRegistrationId = studentChargeGroup.getStudentRegistrationId();
        this.chargeGroupId = studentChargeGroup.getChargeGroupId();
        this.activeStatus = studentChargeGroup.getActiveStatus();
        this.remarks = studentChargeGroup.getRemarks();
    }


    private void populateEnrolStudent(List<EnrolStudentData> dataList){
        for (EnrolStudentData enroll : dataList) {
            boolean status;
//            if(office.getActiveStatus()==1){
//                status=true;
//            }
//            else{
//                status=false;
//            }


//            ChargeGroup origin=enroll.getOrigin();
//            String originName=origin.getOrigin();
            enrolStudentDataList.add(EnrolStudentForm.builder()
                    .id(enroll.getId())
                    .studentRegistrationId(enroll.getStudentRegistrationId())
                    .studentName(enroll.getStudentName())
                    .sessionId(enroll.getSessionId())
                    .sessionName(enroll.getSessionName())
                    .doB(enroll.getDoB())
                    .origin(enroll.getOrigin())
                    .build());
        }
    }

//    public void populateChargeGroup(List<ChargeGroupData> chargeGroupList){
//        for(ChargeGroupData c : chargeGroupList){
//            ChargeGroupFormList.add(c);
//        }
//    }

//    public void populateEnrolStudent(List<EnrolStudentData> enrolStudentList){
//        for(EnrolStudentData c : enrolStudentList){
//            enrolStudentDataList.add(c);
//        }
//    }
//    public StudentChargeGroupFrom(StudentChargeGroup studentChargeGroup) {
//    }
    public boolean isPersisted() {
        return id != null;
    }
}
