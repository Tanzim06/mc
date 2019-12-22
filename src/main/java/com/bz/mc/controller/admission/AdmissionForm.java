package com.bz.mc.controller.admission;

;
import com.bz.mc.model.admission.AdmissionBooking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AdmissionForm {


    private Long id;
    private Long sessionId;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDateTime bookingDate;
    private String studentName;
    private String fatherName;
    private String motherName;
    private String spouseName;
    private String NID;
    private String contactNo;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDateTime DOB;
    private String presentAdd;
    private String permanentAdd;
    private Double amountToBePaid;
    private Long currencyId;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDateTime dateToBePaid;
    private Double advAmount;
    private int activeStatus;
    private String remarks;
    private boolean active;



    public AdmissionForm(AdmissionBooking admissionBooking) {
        this.id = id;
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
        this.remarks = remarks;
        this.active = active;
    }

    public boolean isPersisted() {
        return id != null;
    }
}
