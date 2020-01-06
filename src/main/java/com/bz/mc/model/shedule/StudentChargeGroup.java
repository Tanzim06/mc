package com.bz.mc.model.shedule;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name="STUDENT_CHARGE_GROUP")
public class StudentChargeGroup extends BaseEntity implements Auditable {

    @Column(name="STUDENT_REGISTRATION_ID")
    private Long studentRegistrationId;
    @Column(name="CHARGE_GROUP_ID")
    private Long chargeGroupId;
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
