package com.bz.mc.controller.studentRegistration;

import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class StudentEducationPastForm {

    private Long studentEduPastId;
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



    public boolean isPersisted() {
        return studentEduPastId != null;
    }

    public StudentEducationPastForm(StudentEducationPastInfo studentEducationPastInfo) {
        this.studentEduPastId = studentEducationPastInfo.getStudentEduPastId();
        this.studentRegistrationId = studentEducationPastInfo.getStudentRegistrationId();
        this.examName = studentEducationPastInfo.getExamName();
        this.groupName = studentEducationPastInfo.getGroupName();
        this.yearPassed = studentEducationPastInfo.getYearPassed();
        this.rollNo = studentEducationPastInfo.getRollNo();
        this.regNo = studentEducationPastInfo.getRegNo();
        this.boardName = studentEducationPastInfo.getBoardName();
        this.gpa = studentEducationPastInfo.getGpa();
        this.marksBiology = studentEducationPastInfo.getMarksBiology();
        this.remarks = studentEducationPastInfo.getRemarks();
    }
}
