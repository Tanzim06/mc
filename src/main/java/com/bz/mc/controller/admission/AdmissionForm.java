package com.bz.mc.controller.admission;

;
import com.bz.mc.model.admission.AdmissionBooking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class AdmissionForm {

    private Long id;
    private Long sessionId;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private String bookingDate;
    private String studentName;
    private String fatherName;
    private String motherName;
    private String spouseName;
    private String NID;
    private String contactNo;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private String DOB;
    private String presentAdd;
    private String permanentAdd;
    private Double amountToBePaid;
    private Long currencyId;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private String dateToBePaid;
    private Double advAmount;
    private int confirmFlag;
    private boolean confirm;
    private int activeStatus;
    private String remarks;
    private boolean active;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private String confirmDate;

    public AdmissionForm(AdmissionBooking admissionBooking) {
        this.id = admissionBooking.getId();
        this.sessionId = admissionBooking.getSessionId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.bookingDate = formatter.format(admissionBooking.getBookingDate());
        this.studentName = admissionBooking.getStudentName();
        this.fatherName = admissionBooking.getFatherName();
        this.motherName = admissionBooking.getMotherName();
        this.spouseName = admissionBooking.getSpouseName();
        this.NID = admissionBooking.getNID();
        this.contactNo = admissionBooking.getContactNo();
        this.DOB = admissionBooking.getContactNo();
        this.presentAdd = admissionBooking.getPresentAdd();
        this.permanentAdd = admissionBooking.getPermanentAdd();
        this.amountToBePaid = admissionBooking.getAmountToBePaid();
        this.currencyId = admissionBooking.getCurrencyId();
        DateTimeFormatter formatterpaid = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateToBePaid = formatterpaid.format(admissionBooking.getDateToBePaid());
        this.advAmount = admissionBooking.getAdvAmount();
        this.confirmFlag = admissionBooking.getConfirmFlag();
        this.confirm = admissionBooking.isConfirm();
        this.activeStatus = admissionBooking.getActiveStatus();
        this.remarks = admissionBooking.getRemarks();
        this.active = admissionBooking.isActive();
        DateTimeFormatter formatterConfirm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.confirmDate = formatterConfirm.format(admissionBooking.getConfirmDate());
    }

    public boolean isPersisted() {
        return id != null;
    }
}
