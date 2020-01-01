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
@AllArgsConstructor
public class EnrolStudentData {
    private Long id;
    private Long studentRegistrationId;
    private String studentName;
    private String fatherName;
    private String sessionName;
    private String programName;
//    private String batchName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate enrolDate;
//    private String programSegmentName;
//    private String doB;


    public EnrolStudentData() {

    }


}
