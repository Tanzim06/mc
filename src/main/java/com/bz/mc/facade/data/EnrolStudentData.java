package com.bz.mc.facade.data;

/*
name: moly
date: 26/12/19
time: 02:18 pm
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
//@AllArgsConstructor
public class EnrolStudentData {
    private Long id;
    private Long studentRegistrationId;
    private String studentName;
    private String fatherName;
    private String sessionName;
    private String programName;
    private String programSegmentName;
    private String motherName;
    private String permanentAdd;
    private String permanentAddPostCode;
    private String presentAdd;
    private String presentAddPostcode;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate doB;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate registrationDate;
    private String bloodGroup;
    private String batchName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate enrolDate;
//    private String doB;


    public EnrolStudentData() {

    }

    public EnrolStudentData(Long id, Long studentRegistrationId, String studentName, String fatherName, String sessionName, String programName, LocalDate enrolDate) {
        this.id = id;
        this.studentRegistrationId = studentRegistrationId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.sessionName = sessionName;
        this.programName = programName;
        this.enrolDate = enrolDate;
    }

    public EnrolStudentData(Long id, Long studentRegistrationId, String studentName, String fatherName,  String motherName, String permanentAdd, String permanentAddPostCode, String presentAdd, String presentAddPostcode, String bloodGroup) {
        this.id = id;
        this.studentRegistrationId = studentRegistrationId;
        this.studentName = studentName;
        this.fatherName = fatherName;
//        this.sessionName = sessionName;
//        this.programName = programName;
//        this.programSegmentName = programSegmentName;
        this.motherName = motherName;
        this.permanentAdd = permanentAdd;
        this.permanentAddPostCode = permanentAddPostCode;
        this.presentAdd = presentAdd;
        this.presentAddPostcode = presentAddPostcode;
//        this.doB = doB;
//        this.registrationDate = registrationDate;
        this.bloodGroup = bloodGroup;
    }

    //    private Long id;
//    private Long studentRegistrationId;
//    private String studentName;
//    private String fatherName;
//    private String sessionName;
//    private String programName;
//    private String batchName;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private LocalDate enrolDate;
//    private String programSegmentName;
//    private String motherName;
//    private String permanentAdd;
//    private String permanentAddPostCode;
//    private String presentAdd;
//    private String presentAddPostcode;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private LocalDate doB;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private LocalDate registrationDate;
//    private String bloodGroup;
}
