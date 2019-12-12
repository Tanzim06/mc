package com.bz.mc.model.charge;

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
@Table(name="CHARGE_GROUP")
public class ChargeGroup {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CHARGE_GROUP_ID")
    private Long chargeGroupId;

    @Column(name="CHARGE_GROUP_NAME")
    private String chargeGroupName;

    @Column(name="SHORT_CODE")
    private String shortCode;

    @Column(name="SESSION_ID")
    private Long sessionId;

    @Column(name="PROGRAM_ID")
    private Long programId;

    @Column(name="PROGRAM_SEGMENT_ID")
    private Long programSegmentId;

    @Column(name="CHARGE_CYCLE")
    private int chargeCycle;

    @Column(name="PAYMENT_CYCLE")
    private int paymentCycle;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;

    @Transient
    private boolean active;

    @Transient
    private boolean group;

    @Transient
    private String sActive;

    @Column(name="REMARKS")
    private String remarks;


    @Column(name="ENTERED_BY")
    private Long enteredBy;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;

    @Column(name="UPDATED_BY")
    private Long updatedBy;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @Column(name="FLEX_FIELD1")
    private String flexField1;

    @Column(name="FLEX_FIELD2")
    private String flexField2;


    @Column(name="FLEX_FIELD3")
    private String flexField3;
}
