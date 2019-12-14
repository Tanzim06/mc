package com.bz.mc.controller.studentRegistrationCont;

import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;


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
