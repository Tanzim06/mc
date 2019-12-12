package com.bz.mc.model.admission;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="admission_booking")
public class AdmissionBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADMISSION_BOOKING_ID")
    private Long admissionBookingId;


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


}
