package com.bz.mc.facade.data;

/*
name: moly
date: 21/12/19
time: 10:18 am
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class StudentRegistrationData {
    private Long id;
    private String studentName;
    private String fatherName;
    private String motherName;
    private String contactNo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate doB;
    private String sessionName;
    //    private String registrationDate;




//    public StudentRegistrationData(StudentRegistrationInfo studentRegistrationInfo) {
//        this.id = studentRegistrationInfo.getId();
//        this.studentName = studentRegistrationInfo.getStudentName();
//        this.fatherName = studentRegistrationInfo.getFatherName();
//        this.motherName = studentRegistrationInfo.getMotherName();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        this.doB = formatter.format(studentRegistrationInfo.getDoB());
//        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        this.registrationDate = formatters.format(studentRegistrationInfo.getRegistrationDate());
////        this.registrationDate = registrationDate;
//        this.contactNo = studentRegistrationInfo.getContactNo();
////        this.sessionName = studentRegistrationInfo.getSessionId();
//    }
//    public StudentRegistrationData(Long id, String studentName, String fatherName, String motherName, String contactNo, Long sessionId) {
//        this.id = id;
//        this.studentName = studentName;
//        this.fatherName = fatherName;
//        this.motherName = motherName;
////        this.doB = doB;
////        this.registrationDate = registrationDate;
//        this.contactNo = contactNo;
//        this.sessionId = sessionId;
//    }


//    private Long id;
//    private String studentName;
//    private String fatherName;
//    private String motherName;
//    private String contactNo;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private LocalDate doB;
//    private String sessionName;
//    //    private String registrationDate;
}
