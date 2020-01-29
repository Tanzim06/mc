package com.bz.mc.controller.enrolStudent;

import com.bz.mc.controller.studentRegistration.StudentEducationPastForm;
import com.bz.mc.controller.studentRegistration.StudentRegistrationForm;
import com.bz.mc.facade.data.StudentEducationPastData;


import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.studentRegistration.Gender;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrolStudentForm {

    private Long id;
    private Long studentRegistrationId;
    private Long programSegmentId;
    private int enrolType;
    private Long groupId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrolDate;
    private Long sessionId;
    private Long batchId;
    private int rollNo;
    private Long sectionId;
//    private boolean newss;
//    private boolean enrol;
    private String remarks;
    private StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();

//    student registration field
    private Long programId;
    private String studentName;   // added by moly on 09/01/20 at 11.01 am
    private String branchName;
    private String programName;
    private String segmentName;
    private String fatherName;
    private String motherName;
    private String permanentAdd;
    private String permanentAddPostCode;
    private String presentAdd;
    private String presentAddPostcode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate doB;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    private String bloodGroup;
    private Gender gender;
    private String contactNo;
    private String sessionName;
    private String regRemarks;

    public boolean isPersisted() {
        return id != null;
    }

    public void populateEnrolStudentForm(EnrolStudentInfo enrolStudentInfo) {
        this.id = enrolStudentInfo.getId();
        this.studentRegistrationId = enrolStudentInfo.getStudentRegistrationId();
        this.programSegmentId = enrolStudentInfo.getProgramSegmentId();
        this.enrolType = enrolStudentInfo.getEnrolType();
        this.groupId = enrolStudentInfo.getGroupId();
        this.enrolDate = enrolStudentInfo.getEnrolDate();
        this.sessionId = enrolStudentInfo.getSessionId();
        this.batchId = enrolStudentInfo.getBatchId();
        this.rollNo = enrolStudentInfo.getRollNo();
        this.sectionId = enrolStudentInfo.getSectionId();
        this.remarks = enrolStudentInfo.getRemarks();

    }


    public EnrolStudentForm(EnrolStudentInfo enrolStudentInfo) {
        this.id = enrolStudentInfo.getId();
        this.studentRegistrationId = enrolStudentInfo.getStudentRegistrationId();
        populateEnrolStudentForm(enrolStudentInfo);

    }

//    public EnrolStudentForm(Long studentRegistrationId) {
//        this.studentRegistrationId = studentRegistrationId;
//    }
}

