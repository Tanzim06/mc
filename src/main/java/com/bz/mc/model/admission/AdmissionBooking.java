package com.bz.mc.model.admission;


import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="admission_booking")
public class AdmissionBooking extends BaseEntity  {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ADMISSION_BOOKING_ID")
//    private Long admissionBookingId;


    @Column(name="SESSION_ID")
    private Long sessionId;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="BOOKING_DATE")
    private LocalDateTime bookingDate;


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
    private LocalDateTime DOB;

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
    private LocalDateTime dateToBePaid;

    @Column(name="ADV_AMOUNT")
    private Double advAmount;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;

    @Transient
    private boolean active;

    @Transient
    private String sActive;


    @Column(name="REMARKS")
    private String remarks;

    @Column(name="ENTERED_BY")
    private Long enteredBy;

    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime EntryTimestamp;

    @Column(name="UPDATED_BY")
    private Long updatedBy;

    @Column(name="UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @Column(name="FLEX_FIELD1")
    private String flexField1;

    @Column(name="FLEX_FIELD2")
    private String flexField2;

    @Column(name="FLEX_FIELD3")
    private String flexField3;


    @Builder
    public AdmissionBooking(Long sessionId, LocalDateTime bookingDate, String studentName, String fatherName, String motherName, String spouseName, String NID, String contactNo, LocalDateTime DOB, String presentAdd, String permanentAdd, Double amountToBePaid, Long currencyId, LocalDateTime dateToBePaid, Double advAmount, int activeStatus, boolean active, String sActive, String remarks, Long enteredBy, LocalDateTime entryTimestamp, Long updatedBy, LocalDateTime updateTimestamp, String flexField1, String flexField2, String flexField3) {
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
        this.activeStatus = activeStatus;
        this.active = active;
        this.sActive = sActive;
        this.remarks = remarks;
        this.enteredBy = enteredBy;
        EntryTimestamp = entryTimestamp;
        this.updatedBy = updatedBy;
        this.updateTimestamp = updateTimestamp;
        this.flexField1 = flexField1;
        this.flexField2 = flexField2;
        this.flexField3 = flexField3;
    }



}
