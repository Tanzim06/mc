package com.bz.mc.controller.studentRegistrationCont;

import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class StudentRegistrationForm {

    private Long studentRegistrationId;
    private Long branchId;
    private String visualId;
    private String studentName;
    private String fatherName;
    private String motherName;
    private String permanentAdd;
    private String permanentAddPostCode;
    private String presentAdd;
    private String presentAddPostcode;
    private float ageInYr ;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate doB;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate registrationDate;
    private String bloodGroup;
    private String picturePath;
    private byte [] picture;
    private Integer gender;
    private String contactNo;
    private Long  sessionId;
    private int activeStatus;
    private String remarks;


    public boolean isPersisted() {
        return studentRegistrationId != null;
    }


    public StudentRegistrationForm(StudentRegistrationInfo studentRegistrationInfo) {
        this.studentRegistrationId = studentRegistrationInfo.getStudentRegistrationId();
        this.branchId = studentRegistrationInfo.getBranchId();
        this.visualId = studentRegistrationInfo.getVisualId();
        this.studentName = studentRegistrationInfo.getStudentName();
        this.fatherName = studentRegistrationInfo.getFatherName();
        this.motherName = studentRegistrationInfo.getMotherName();
        this.permanentAdd = studentRegistrationInfo.getPermanentAdd();
        this.permanentAddPostCode = studentRegistrationInfo.getPermanentAddPostCode();
        this.presentAdd = studentRegistrationInfo.getPresentAdd();
        this.presentAddPostcode = studentRegistrationInfo.getPresentAddPostcode();
        this.ageInYr = studentRegistrationInfo.getAgeInYr();
        this.doB = studentRegistrationInfo.getDoB();
        this.registrationDate = studentRegistrationInfo.getRegistrationDate();
        this.bloodGroup = studentRegistrationInfo.getBloodGroup();
        this.picturePath = studentRegistrationInfo.getPicturePath();
        this.picture = studentRegistrationInfo.getPicture();
        this.gender = studentRegistrationInfo.getGender();
        this.contactNo = studentRegistrationInfo.getContactNo();
        this.sessionId = studentRegistrationInfo.getSessionId();
        this.activeStatus = studentRegistrationInfo.getActiveStatus();
        this.remarks = studentRegistrationInfo.getRemarks();
    }
}
