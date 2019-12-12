package com.bz.mc.model.item;

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
@Table(name = "ITEM_PRICE")
public class ItemPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ITEM_PRICE_ID")
    private Long itemPriceId;


    @Column(name="ITEM_ID")
    private Long itemId;

    @Column(name="ITEM_RATE")
    private Double itemRate;


    @Column(name="CURRENCY_ID")
    private Long currencyId;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="EFFECTIVE_FROM")
    private LocalDateTime effectiveFrom;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    @Column(name="EFFECTIVE_TO")
    private LocalDateTime effectiveTo;

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
