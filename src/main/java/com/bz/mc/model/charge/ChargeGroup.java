package com.bz.mc.model.charge;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="CHARGE_GROUP")
public class ChargeGroup extends BaseEntity implements Auditable {

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
    @Column(name="EFFECTIVE_FROM")
    private LocalDate effectiveFrom;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="EFFECTIVE_TO")
    private LocalDate effectiveTo;
    @Column(name="origin")
    private Origin origin;

    @Builder
    public ChargeGroup(String chargeGroupName, String shortCode, Long sessionId, Long programId, Long programSegmentId, int chargeCycle, int paymentCycle, int activeStatus, boolean active, boolean group, String sActive, String remarks, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt, String flexField1, String flexField2, String flexField3, LocalDate effectiveFrom, LocalDate effectiveTo, Origin origin) {
        this.chargeGroupName = chargeGroupName;
        this.shortCode = shortCode;
        this.sessionId = sessionId;
        this.programId = programId;
        this.programSegmentId = programSegmentId;
        this.chargeCycle = chargeCycle;
        this.paymentCycle = paymentCycle;
        this.activeStatus = activeStatus;
        this.active = active;
        this.group = group;
        this.sActive = sActive;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.flexField1 = flexField1;
        this.flexField2 = flexField2;
        this.flexField3 = flexField3;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.origin = origin;
    }
}
