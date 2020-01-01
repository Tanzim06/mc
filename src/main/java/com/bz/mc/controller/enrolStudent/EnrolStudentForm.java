package com.bz.mc.controller.enrolStudent;

import com.bz.mc.controller.studentRegistration.StudentEducationPastForm;
import com.bz.mc.controller.studentRegistration.StudentRegistrationForm;
import com.bz.mc.facade.data.StudentEducationPastData;


import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class EnrolStudentForm {

    private Long id;
    private Long studentRegistrationId;
    private Long programSegmentId;
    private int enrolType;
    private Long groupId;
    private String enrolDate;
    private Long  sessionId;
    private Long  batchId;
    private int rollNo;
    private Long  sectionId;
    private StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
    private List<StudentRegistrationData> enrolStudentForm = new ArrayList<>();


    public boolean isPersisted() {
        return id != null;
    }

    public void populateEnrolStudentForm(EnrolStudentInfo enrolStudentInfo) {
        this.id = enrolStudentInfo.getId();
        this.studentRegistrationId = enrolStudentInfo.getStudentRegistrationId();
        this.programSegmentId = enrolStudentInfo.getProgramSegmentId();
        this.enrolType = enrolStudentInfo.getEnrolType();
        this.groupId = enrolStudentInfo.getGroupId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.enrolDate = formatter.format(enrolStudentInfo.getEnrolDate());
//        this.enrolDate = enrolSrudentInfo.getEnrolDate();
        this.sessionId = enrolStudentInfo.getSessionId();
        this.batchId = enrolStudentInfo.getBatchId();
        this.rollNo = enrolStudentInfo.getRollNo();
        this.sectionId = enrolStudentInfo.getSectionId();
    }


    public EnrolStudentForm(EnrolStudentInfo enrolStudentInfo, List<StudentRegistrationData> registrationDataList) {
        this.id=enrolStudentInfo.getId();
        populateEnrolStudentForm(enrolStudentInfo);
        populateStudentRegistrationInfo(registrationDataList);

    }

    public void populateStudentRegistrationInfo(List<StudentRegistrationData> registrationDataList){
        for(StudentRegistrationData m : registrationDataList){
            enrolStudentForm.add(m);
        }
    }

    //    private Long id;
//    private Long branchId;
//    private String visualId;
//    private String studentName;
//    private String fatherName;
//    private String motherName;
//    private String permanentAdd;
//    private String permanentAddPostCode;
//    private String presentAdd;
//    private String presentAddPostcode;
//    private float ageInYr ;
////    @DateTimeFormat(pattern="yyyy-MM-dd")
////    private LocalDate doB;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private LocalDate doB;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private LocalDate registrationDate;
////    @DateTimeFormat(pattern="yyyy-MM-dd")
////    private LocalDate registrationDate;
//    private String bloodGroup;
//    private String picturePath;
//    private byte [] picture;
//    private Gender gender;
//    private String contactNo;
//    private Long  sessionId;
//    private int activeStatus;
//    private String remarks;
//    private int tabId;
//    private StudentEducationPastForm studentEducationPastForm=new StudentEducationPastForm();
//    private List<StudentEducationPastData> EducationPastForm = new ArrayList<>();
//
//
//    public boolean isPersisted() {
//        return id != null;
//    }
//
//
//    public EnrolStudentForm(StudentRegistrationInfo studentRegistrationInfo) {
//        this.id = studentRegistrationInfo.getId();
//        this.branchId = studentRegistrationInfo.getBranchId();
//        this.visualId = studentRegistrationInfo.getVisualId();
//        this.studentName = studentRegistrationInfo.getStudentName();
//        this.fatherName = studentRegistrationInfo.getFatherName();
//        this.motherName = studentRegistrationInfo.getMotherName();
//        this.permanentAdd = studentRegistrationInfo.getPermanentAdd();
//        this.permanentAddPostCode = studentRegistrationInfo.getPermanentAddPostCode();
//        this.presentAdd = studentRegistrationInfo.getPresentAdd();
//        this.presentAddPostcode = studentRegistrationInfo.getPresentAddPostcode();
//        this.ageInYr = studentRegistrationInfo.getAgeInYr();
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        this.doB = studentRegistrationInfo.getDoB();
////        this.doB = formatter.format(studentRegistrationInfo.getDoB());
//        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        this.registrationDate = studentRegistrationInfo.getRegistrationDate();
//        this.bloodGroup = studentRegistrationInfo.getBloodGroup();
//        this.picturePath = studentRegistrationInfo.getPicturePath();
//        this.picture = studentRegistrationInfo.getPicture();
//        this.gender = studentRegistrationInfo.getGender();
//        this.contactNo = studentRegistrationInfo.getContactNo();
//        this.sessionId = studentRegistrationInfo.getSessionId();
//        this.activeStatus = studentRegistrationInfo.getActiveStatus();
//        this.remarks = studentRegistrationInfo.getRemarks();
//    }
//
////    public SamityOldForm(Samity samity, List<DocumentType> documentTypes, List<SamityMemberData> memberList){
////        this.id=samity.getId();
////        this.basicCenterId=samity.getBasicCenterId();
////        populateSamityInfo(samity);
////        populateDocumentInfo(documentTypes);
////        populateMemberInfo(memberList);
////        this.tabId=1;
//
//    public void populateSudentRegistratioinInfo(StudentRegistrationInfo studentRegistrationInfo){
//        this.id=studentRegistrationInfo.getId();
//
//    }
//
//
//    public EnrolStudentForm(StudentRegistrationInfo studentRegistrationInfo, List<StudentEducationPastData> educationPastDataList) {
//        this.id=studentRegistrationInfo.getId();
//        populateSudentRegistratioinInfo(studentRegistrationInfo);
//        populateStudentEducationPastInfo(educationPastDataList);
//        this.tabId=1;
//    }
//
//    public void populateStudentEducationPastInfo(List<StudentEducationPastData> educationPastDataList){
//        for(StudentEducationPastData m : educationPastDataList){
//            EducationPastForm.add(m);
//        }
//    }
}
