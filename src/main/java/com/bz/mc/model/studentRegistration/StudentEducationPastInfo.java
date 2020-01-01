package com.bz.mc.model.studentRegistration;

import com.bz.mc.model.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 10:52 am
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_EDU_PAST")
@ToString
public class StudentEducationPastInfo extends BaseEntity {

    @Column(name="STUDENT_REGISTRATION_ID")
    private Long  studentRegistrationId;

    @Column(name="EXAM_NAME")
    private String examName;

    @Column(name="GROUP_NAME")
    private String groupName;

    @Column(name="YEAR_PASSED")
    private int yearPassed;

    @Column(name="ROLL_NO")
    private String rollNo;

    @Column(name="REG_NO")
    private String regNo;

    @Column(name="BOARD_NAME")
    private String boardName;

    @Column(name="GPA")
    private float gpa;

    @Column(name="MARKS_BIOLOGY")
    private float marksBiology;

    @Column(name="REMARKS")
    private String remarks;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;

    @Transient
    private boolean active;

    @Column(name="ENTERED_BY")
    private Long enteredBy ;

    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;

    @Column(name="UPDATED_BY")
    private LocalDateTime updatedBy ;

    @Column(name="UPDATE_TIMESTAMP" , nullable=true)
    private LocalDateTime updateTimestap;

    @Column(name="FLEX_FIELD1")
    private String flex1  ;

    @Column(name="FLEX_FIELD2")
    private String flex2  ;

    @Column(name="FLEX_FIELD3")
    private String flex3  ;

    @Builder
    public StudentEducationPastInfo(Long studentRegistrationId, String examName, String groupName, int yearPassed, String rollNo, String regNo, String boardName, float gpa, float marksBiology, String remarks, int activeStatus, boolean active, Long enteredBy, LocalDateTime entryTimestamp, LocalDateTime updatedBy, LocalDateTime updateTimestap, String flex1, String flex2, String flex3) {
        this.studentRegistrationId = studentRegistrationId;
        this.examName = examName;
        this.groupName = groupName;
        this.yearPassed = yearPassed;
        this.rollNo = rollNo;
        this.regNo = regNo;
        this.boardName = boardName;
        this.gpa = gpa;
        this.marksBiology = marksBiology;
        this.remarks = remarks;
        this.activeStatus = activeStatus;
        this.active = active;
        this.enteredBy = enteredBy;
        this.entryTimestamp = entryTimestamp;
        this.updatedBy = updatedBy;
        this.updateTimestap = updateTimestap;
        this.flex1 = flex1;
        this.flex2 = flex2;
        this.flex3 = flex3;
    }
}
