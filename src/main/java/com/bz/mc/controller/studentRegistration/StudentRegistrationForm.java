package com.bz.mc.controller.studentRegistration;

import com.bz.mc.facade.data.StudentEducationPastData;
import com.bz.mc.model.studentRegistration.Gender;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class StudentRegistrationForm {

    private Long id;
    private Long branchId;
    private Long programId;
    private Long programSegmentId;
    private Long statusId;
    private String visualId;
    private String studentName;
    private String fatherName;
    private String motherName;
    private String permanentAdd;
    private String permanentAddPostCode;
    private String presentAdd;
    private String presentAddPostcode;
    private float ageInYr ;
    private String doB;
    private String registrationDate;
    private String bloodGroup;
    private String picturePath;
    private byte [] picture;
    private Gender gender;
    private String contactNo;
    private Long  sessionId;
    private int activeStatus;
    private String remarks;
    private int tabId;
    private StudentEducationPastForm studentEducationPastForm=new StudentEducationPastForm();
    private List<StudentEducationPastData> educationPastForm = new ArrayList<>();


    public boolean isPersisted() {
        return id != null;
    }


    public void populateSudentRegistratioinInfo(StudentRegistrationInfo studentRegistrationInfo){    //// after save date show tab 1
        this.id=studentRegistrationInfo.getId();
        this.branchId = studentRegistrationInfo.getBranchId();
        this.programId = studentRegistrationInfo.getProgramId();
        this.programSegmentId = studentRegistrationInfo.getProgramSegmentId();
        this.statusId = studentRegistrationInfo.getStatusId();
        this.visualId = studentRegistrationInfo.getVisualId();
        this.studentName = studentRegistrationInfo.getStudentName();
        this.fatherName = studentRegistrationInfo.getFatherName();
        this.motherName = studentRegistrationInfo.getMotherName();
        this.permanentAdd = studentRegistrationInfo.getPermanentAdd();
        this.permanentAddPostCode = studentRegistrationInfo.getPermanentAddPostCode();
        this.presentAdd = studentRegistrationInfo.getPresentAdd();
        this.presentAddPostcode = studentRegistrationInfo.getPresentAddPostcode();
        this.ageInYr = studentRegistrationInfo.getAgeInYr();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.doB = formatter.format(studentRegistrationInfo.getDoB());
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.registrationDate = formatters.format(studentRegistrationInfo.getRegistrationDate());
        this.bloodGroup = studentRegistrationInfo.getBloodGroup();
        this.picturePath = studentRegistrationInfo.getPicturePath();
        this.picture = studentRegistrationInfo.getPicture();
        this.gender = studentRegistrationInfo.getGender();
        this.contactNo = studentRegistrationInfo.getContactNo();
        this.sessionId = studentRegistrationInfo.getSessionId();
        this.activeStatus = studentRegistrationInfo.getActiveStatus();
        this.remarks = studentRegistrationInfo.getRemarks();

    }


    public StudentRegistrationForm(StudentRegistrationInfo studentRegistrationInfo, List<StudentEducationPastData> educationPastDataList) {
        this.id=studentRegistrationInfo.getId();
        populateSudentRegistratioinInfo(studentRegistrationInfo);
        populateStudentEducationPastInfo(educationPastDataList);
        this.tabId=1;
    }

    public void populateStudentEducationPastInfo(List<StudentEducationPastData> educationPastDataList){
        for(StudentEducationPastData m : educationPastDataList){
            educationPastForm.add(m);
        }
    }
}
