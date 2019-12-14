package com.bz.mc.model.studentRegistration;

import com.bz.mc.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    @Column(name="STUDENT_EDU_PAST_ID")
    private Long studentEduPastId;

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
}
