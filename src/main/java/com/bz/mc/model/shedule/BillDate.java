package com.bz.mc.model.shedule;


import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

//created by SHAHIDUL 31/12/19
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name="BILL_DATE")
public class BillDate extends BaseEntity implements Auditable{

    @Column(name="CHARGE_GROUP_ID")
    private Long chargeGroupId;
    @Column(name="BILL_DATE")
    private LocalDate billDate;
    @Column(name="SL_NO")
    private int slNo;
    @Column(name="YEAR")
    private int year;
    @Column(name="ACTIVE_STATUS")
    private int activeStatus;
    @Transient
    private boolean active;
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

}
