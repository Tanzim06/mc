package com.bz.mc.model.setup;


import com.bz.mc.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Entity
@Table(name = "session_info")
@ToString
public class SessionInfo extends BaseEntity {

    @Column(name="SESSION_ID")
    private Long sessionId;

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

    @Column(name="ENTERED_BY")
    private Long enteredBy ;

    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;

    @Column(name="UPDATED_BY")
    private Long updatedBy ;

    @Column(name="UPDATE_TIMESTAMP" , nullable=true)
    private LocalDateTime updateTimestap;

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

}
