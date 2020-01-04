package com.bz.mc.model.enrol;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * User: Moly
 * Date: 22/12/19
 * Time: 10:31 am
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "ENROL_STUDENT")
public class EnrolStudentInfo extends BaseEntity implements Auditable {


    @Column(name = "STUDENT_REGISTRATION_ID")
    private Long studentRegistrationId;

    @Column(name = "PROGRAM_SEGMENT_ID")
    private Long programSegmentId;

    @Column(name = "ENROL_TYPE")
    private int enrolType;

    @Column(name = "GROUP_ID")
    private Long groupId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ENROL_DATE")
    private LocalDate enrolDate;

    @Column(name = "SESSION_ID")
    private Long sessionId;

    @Column(name = "BATCH_ID")
    private Long batchId;

    @Column(name = "ROLL_NO")
    private int rollNo;

    @Column(name = "SECTION_ID")
    private Long sectionId;

    @Column(name = "CLOSE_FLAG")
    private int closeFlag;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "CLOSE_DATE")
    private LocalDateTime closeDate;

    @Column(name = "CLOSE_REASON")
    private String closeReason;

    @Column(name = "ADMISSION_FEE_PAYMENT_REQUIRED")
    private int admissionFeePaymentRequired;

    @Column(name = "ADMISSION_FEE_PAYMENT_FLAG")
    private int admissionFeePaymentFlag;

    @Column(name = "ACTIVE_STATUS")
    private int activeStatus;

    @Column(name = "REMARKS")
    private String remarks;

    @Transient
    private boolean active;

    @Transient
    private boolean newss;

    @Transient
    private boolean enrol;

    @Column(name = "ENTERED_BY")
    private Long createdBy;

    @Column(name = "UPDATED_BY")
    private Long modifiedBy;

    @Column(name = "ENTRY_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name = "FLEX_FIELD1")
    private String flex1;

    @Column(name = "FLEX_FIELD2")
    private String flex2;

    @Column(name = "FLEX_FIELD3")
    private String flex3;

}