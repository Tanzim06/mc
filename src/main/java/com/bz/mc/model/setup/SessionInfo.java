package com.bz.mc.model.setup;


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

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 10:52 am
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "SESSION_INFO")
@ToString
public class SessionInfo extends BaseEntity implements Auditable {

    @Column(name="SESSION_NAME")
    private String sessionName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="START_DATE")
    private LocalDate startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="END_DATE")
    private LocalDate endDate;

    @Column(name="VISUAL_ID")
    private String visualId;

    @Column(name="SHORT_CODE")
    private String shortCode;

    @Column(name="BRANCH_ID")
    private Long branchId;

    @Column(name = "ENTERED_BY")
    private Long createdBy;

    @Column(name = "UPDATED_BY")
    private Long modifiedBy;

    @Column(name = "ENTRY_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name="FLEX_FIELD1")
    private String flex1  ;

    @Column(name="FLEX_FIELD2")
    private String flex2  ;

    @Column(name="FLEX_FIELD3")
    private String flex3  ;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;

    @Column(name="REMARKS")
    private String remarks;

    @Transient
    private boolean active;

//    @Builder
//    public SessionInfo(String sessionName, LocalDate startDate, LocalDate endDate, String visualId, String shortCode, Long branchId, Long enteredBy, LocalDateTime entryTimestamp, Long updatedBy, LocalDateTime updateTimestap, String flex1, String flex2, String flex3, int activeStatus, String remarks, boolean active) {
//        this.sessionName = sessionName;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.visualId = visualId;
//        this.shortCode = shortCode;
//        this.branchId = branchId;
//        this.flex1 = flex1;
//        this.flex2 = flex2;
//        this.flex3 = flex3;
//        this.activeStatus = activeStatus;
//        this.remarks = remarks;
//        this.active = active;
//    }



}
