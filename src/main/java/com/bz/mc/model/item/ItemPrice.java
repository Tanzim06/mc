package com.bz.mc.model.item;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "ITEM_PRICE")
public class ItemPrice  extends BaseEntity  implements Auditable {

    @Column(name="ITEM_ID")
    private Long itemId;
    @Column(name="ITEM_RATE")
    private Double itemRate;
    @Column(name="CURRENCY_ID")
    private Long currencyId;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="EFFECTIVE_FROM")
    private LocalDate effectiveFrom;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="EFFECTIVE_TO")
    private LocalDate effectiveTo;
    @Column(name="SEGMENT_EXIST")
    private int segmentExist;
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


    public ItemPrice(Long itemId, Double itemRate, Long currencyId, LocalDate effectiveFrom, LocalDate effectiveTo, int segmentExist, int activeStatus, boolean active, String sActive, String remarks, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt, String flexField1, String flexField2, String flexField3) {
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.segmentExist = segmentExist;
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
    }



}
