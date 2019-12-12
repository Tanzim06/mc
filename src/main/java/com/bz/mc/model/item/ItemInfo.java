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
@Table(name = "ITEM_INFO")
public class ItemInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ITEM_ID")
    private Long itemId;

    @Column(name="ITEM_NAME")
    private String itemName;

    @Column(name="BILL_FLAG")
    private int billFlag;

    @Column(name="INVENTORY_FLAG")
    private int inventoryFlag;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;



    @Transient
    private boolean bill;

    @Transient
    private boolean inventory;

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
