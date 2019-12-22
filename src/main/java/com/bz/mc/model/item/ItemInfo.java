package com.bz.mc.model.item;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ITEM_INFO")
public class ItemInfo extends BaseEntity {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ITEM_ID")
//    private Long itemId;



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


    @Builder
    public ItemInfo(String itemName, int billFlag, int inventoryFlag, int activeStatus, boolean bill, boolean inventory, boolean active, String sActive, String remarks, Long enteredBy, LocalDateTime entryTimestamp, Long updatedBy, LocalDateTime updateTimestamp, String flexField1, String flexField2, String flexField3) {
        this.itemName = itemName;
        this.billFlag = billFlag;
        this.inventoryFlag = inventoryFlag;
        this.activeStatus = activeStatus;
        this.bill = bill;
        this.inventory = inventory;
        this.active = active;
        this.sActive = sActive;
        this.remarks = remarks;
        this.enteredBy = enteredBy;
        this.entryTimestamp = entryTimestamp;
        this.updatedBy = updatedBy;
        this.updateTimestamp = updateTimestamp;
        this.flexField1 = flexField1;
        this.flexField2 = flexField2;
        this.flexField3 = flexField3;
    }




}
