package com.bz.mc.model.charge;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

//created by SHAHIDUL 24/12/19

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="CHARGE_ITEM")
public class ChargeItem extends BaseEntity implements Auditable {

	@Column(name="CHARGE_GROUP_ID")
	private Long chargeGroupId;
	@Column(name="ITEM_ID")
	private Long itemId;
	@Column(name="ITEM_RATE")
	private Double itemRate;
	@Column(name="CURRENCY_ID")
	private Long currencyId;
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
	private boolean individual;
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

    @Builder
	public ChargeItem(Long chargeGroupId, Long itemId, Double itemRate, Long currencyId, String shortCode, Long sessionId, Long programId, Long programSegmentId, int chargeCycle, int paymentCycle, int activeStatus, boolean active, boolean individual, String sActive, String remarks, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt, String flexField1, String flexField2, String flexField3) {
		this.chargeGroupId = chargeGroupId;
		this.itemId = itemId;
		this.itemRate = itemRate;
		this.currencyId = currencyId;
		this.shortCode = shortCode;
		this.sessionId = sessionId;
		this.programId = programId;
		this.programSegmentId = programSegmentId;
		this.chargeCycle = chargeCycle;
		this.paymentCycle = paymentCycle;
		this.activeStatus = activeStatus;
		this.active = active;
		this.individual = individual;
		this.sActive = sActive;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.flexField1 = flexField1;
		this.flexField2 = flexField2;
		this.flexField3 = flexField3;
	}
}
