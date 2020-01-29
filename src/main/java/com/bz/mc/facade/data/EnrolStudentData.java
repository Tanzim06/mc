package com.bz.mc.facade.data;

/*
name: moly
date: 26/12/19
time: 02:18 pm
 */
import com.bz.mc.model.charge.Origin;
import com.bz.mc.model.studentRegistration.Gender;
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
    private Long sessionId;
    private String sessionName;
     private String programName;
    private String segmentName;
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
    private Gender gender;
    private String contactNo;
    private String remarks;
    private Origin origin;


    public EnrolStudentData() {

    }

    public EnrolStudentData(Long id, Long studentRegistrationId, String studentName, String fatherName, String sessionName, String segmentName, LocalDate enrolDate) {
        this.id = id;
        this.studentRegistrationId = studentRegistrationId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.sessionName = sessionName;
        this.segmentName = segmentName;
        this.enrolDate = enrolDate;
    }

    public EnrolStudentData( Long studentRegistrationId, String studentName, String fatherName, String sessionName, String segmentName) {

        this.studentRegistrationId = studentRegistrationId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.sessionName = sessionName;
        this.segmentName = segmentName;
    }


    public EnrolStudentData( Long id, Long studentRegistrationId, String studentName, String sessionName, LocalDate doB) {
        this.id=id;
        this.studentRegistrationId = studentRegistrationId;
        this.studentName = studentName;
        this.sessionName = sessionName;
        this.doB = doB;
//        this.origin = origin;
    }

    public EnrolStudentData( Long studentRegistrationId, String studentName, String fatherName, String sessionName, String programName, String segmentName, String motherName, String permanentAdd, String permanentAddPostCode, String presentAdd, String presentAddPostcode, LocalDate doB, LocalDate registrationDate, String bloodGroup, Gender gender, String contactNo, String remarks) {
        this.studentRegistrationId = studentRegistrationId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.sessionName = sessionName;
        this.programName = programName;
        this.segmentName = segmentName;
        this.motherName = motherName;
        this.permanentAdd = permanentAdd;
        this.permanentAddPostCode = permanentAddPostCode;
        this.presentAdd = presentAdd;
        this.presentAddPostcode = presentAddPostcode;
        this.doB = doB;
        this.registrationDate = registrationDate;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.contactNo = contactNo;
        this.remarks = remarks;
    }
}
