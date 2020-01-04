package com.bz.mc.facade.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDateFormData {
    private Long id;
    private Long chargeGroupId;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate billDate;
    private int slNo;
    private int year;
    private int activeStatus;
    private String remarks;
    private String chargeGroupName;
    private Long sessionId;
    private Long programId;
    private Long programSegmentId;
    private int chargeCycle;
    private int paymentCycle;
    private String itemName;
    private String sessionName;
    private String programName;
    private String segmentName;

}
