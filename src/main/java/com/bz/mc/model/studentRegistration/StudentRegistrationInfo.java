package com.bz.mc.model.studentRegistration;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 10:52 am
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "STUDENT_REGISTRATION")
public class StudentRegistrationInfo extends BaseEntity implements Auditable {

    @Column(name="BRANCH_ID")
    private Long branchId;

    @Column(name="PROGRAM_ID")
    private Long programId;

    @Column(name="PROGRAM_SEGMENT_ID")
    private Long programSegmentId;

    @Column(name="STATUS_ID")
    private Long statusId;

    @Column(name="VISUAL_ID")
    private String visualId;

    @Column(name="STUDENT_NAME")
    private String studentName;

    @Column(name="FATHER_NAME")
    private String fatherName;

    @Column(name="MOTHER_NAME")
    private String motherName;

    @Column(name="PERMANENT_ADD")
    private String permanentAdd;

    @Column(name="PERMANENT_ADD_POST_CODE")
    private String permanentAddPostCode;

    @Column(name="PRESENT_ADD")
    private String presentAdd;

    @Column(name="PRESENT_ADD_POST_CODE")
    private String presentAddPostcode;

    @Column(name="AGE_IN_YR")
    private float ageInYr ;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="DOB")
    private LocalDate doB;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="REGISTRATION_DATE")
    private LocalDate registrationDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="CALCULATED_DOB")
    private LocalDate calculatedDOB;

    @Column(name="BLOOD_GROUP")
    private String bloodGroup;

    @Column(name="PICTURE_PATH")
    private String picturePath;

    @Lob
    @Column(name="PICTURE")
    private byte [] picture;

    @Column(name="GENDER")
    private Gender gender;

    @Column(name="CONTACT_NO")
    private String contactNo;


    @Column(name="SESSION_ID")
    private Long  sessionId;

    @Column(name="CLOSE_FLAG")
    private int closeFlag;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="CLOSE_DATE")
    private LocalDateTime closeDate;

    @Column(name="CLOSE_REASON")
    private String closeReason;

    @Column(name="HOBBY")
    private String hobby;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;

    @Column(name="REMARKS")
    private String remarks;

    @Transient
    private boolean active;

    @Column(name = "ENTERED_BY")
    private Long createdBy;

    @Column(name = "UPDATED_BY")
    private Long modifiedBy;

    @Column(name = "ENTRY_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name="FLEX_FIELD1")
    private String flex1  ;

    @Column(name="FLEX_FIELD2")
    private String flex2  ;

    @Column(name="FLEX_FIELD3")
    private String flex3  ;

    /*@Builder
    public StudentRegistrationInfo(Long branchId, String visualId, String studentName, String fatherName, String motherName, String permanentAdd, String permanentAddPostCode, String presentAdd, String presentAddPostcode, float ageInYr, LocalDate doB, LocalDate registrationDate, LocalDate calculatedDOB, String bloodGroup, String picturePath, byte[] picture, Integer gender, String contactNo, Long sessionId, int closeFlag, LocalDateTime closeDate, String closeReason, String hobby, int activeStatus, String remarks, boolean active) {
        this.branchId = branchId;
        this.visualId = visualId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.permanentAdd = permanentAdd;
        this.permanentAddPostCode = permanentAddPostCode;
        this.presentAdd = presentAdd;
        this.presentAddPostcode = presentAddPostcode;
        this.ageInYr = ageInYr;
        this.doB = doB;
        this.registrationDate = registrationDate;
        this.calculatedDOB = calculatedDOB;
        this.bloodGroup = bloodGroup;
        this.picturePath = picturePath;
        this.picture = picture;
        this.contactNo = contactNo;
        this.sessionId = sessionId;
        this.closeFlag = closeFlag;
        this.closeDate = closeDate;
        this.closeReason = closeReason;
        this.hobby = hobby;
        this.activeStatus = activeStatus;
        this.remarks = remarks;
        this.active = active;

    }*/
}
