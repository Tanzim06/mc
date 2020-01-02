package com.bz.mc.model.admission;


import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
//@Builder(builderClassName = "Builder")
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="admission_booking")
public class AdmissionBooking extends BaseEntity implements Auditable {
    @Column(name="SESSION_ID")
    private Long sessionId;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="BOOKING_DATE")
    private LocalDate bookingDate;
    @Column(name="STUDENT_NAME")
    private String studentName;
    @Column(name="FATHER_NAME")
    private String fatherName;

    @Column(name="MOTHER_NAME")
    private String motherName;

    @Column(name="SPOUSE_NAME")
    private String spouseName;

    @Column(name="NID")
    private String NID;

    @Column(name="CONTACT_NO")
    private String contactNo;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="DOB")
    private LocalDate DOB;
    @Column(name="PRESENT_ADD")
    private String presentAdd;
    @Column(name="PERMANENT_ADD")
    private String permanentAdd;
    @Column(name="AMOUNT_TO_BE_PAID")
    private Double amountToBePaid;
    @Column(name="CURRENCY_ID")
    private Long currencyId;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="DATE_TO_BE_PAID")
    private LocalDate dateToBePaid;
    @Column(name="ADV_AMOUNT")
    private Double advAmount;
    @Column(name="CONFIRM_FLAG")
    private int confirmFlag;
    @Transient
    private boolean confirm;
    @Column(name="ACTIVE_STATUS")
    private int activeStatus;
    @Transient
    private boolean active;
    @Transient
    private String sActive;
    @Column(name="REMARKS")
    private String remarks;
    @Column(name="ENTERED_BY")
    private Long createdBy;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime createdAt;
    @Column(name="UPDATED_BY")
    private Long modifiedBy;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="UPDATE_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name="FLEX_FIELD1")
    private String flexField1;

    @Column(name="FLEX_FIELD2")
    private String flexField2;

    @Column(name="FLEX_FIELD3")
    private String flexField3;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="CONFIRM_DATE")
    private LocalDate confirmDate;

   @Builder
    public AdmissionBooking(Long sessionId, LocalDate bookingDate, String studentName, String fatherName, String motherName, String spouseName, String NID, String contactNo, LocalDate DOB, String presentAdd, String permanentAdd, Double amountToBePaid, Long currencyId, LocalDate dateToBePaid, Double advAmount, int confirmFlag, boolean confirm, int activeStatus, boolean active, String sActive, String remarks, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt, String flexField1, String flexField2, String flexField3, LocalDate confirmDate) {
        this.sessionId = sessionId;
        this.bookingDate = bookingDate;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.spouseName = spouseName;
        this.NID = NID;
        this.contactNo = contactNo;
        this.DOB = DOB;
        this.presentAdd = presentAdd;
        this.permanentAdd = permanentAdd;
        this.amountToBePaid = amountToBePaid;
        this.currencyId = currencyId;
        this.dateToBePaid = dateToBePaid;
        this.advAmount = advAmount;
        this.confirmFlag = confirmFlag;
        this.confirm = confirm;
        this.activeStatus = activeStatus;
        this.active = active;
        this.sActive = sActive;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.flexField1 = flexField1;
        this.flexField2 = flexField2;
        this.flexField3 = flexField3;
        this.confirmDate = confirmDate;
    }
}
