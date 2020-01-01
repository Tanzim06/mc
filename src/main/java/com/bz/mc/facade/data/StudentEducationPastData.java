package com.bz.mc.facade.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class StudentEducationPastData {
    private Long id;
    private Long  studentRegistrationId;
    private String examName;
    private String groupName;
    private int yearPassed;
    private String rollNo;
    private String regNo;
    private String boardName;
    private float gpa;
    private float marksBiology;
    private String remarks;
    private int activeStatus;

    public StudentEducationPastData(){

    }

}
