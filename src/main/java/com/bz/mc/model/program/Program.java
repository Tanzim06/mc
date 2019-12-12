package com.bz.mc.model.program;


import com.bz.mc.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="PROGRAM_INFO")
public class Program extends BaseEntity {

    @Column(name="PROGRAM_ID")
    private Long programId;

    @Column(name="BRANCH_ID")
    private Long branchId;

    @Column(name="DEPT_ID")
    private Long deptId;

    @Column(name="PROGRAM_NAME")
    private String programName;

    @Column(name="PROGRAM_DESC")
    private String programDesc;

    @Column(name="USER_PROGRAM_NO")
    private String userProgarmNo;

    @Column(name="SHORT_CODE")
    private String shortCode;

    @Column(name="PROGRAM_TYPE_ID")
    private Long progarmTypeId;

    @Column(name="SEGMENT_NO")
    private int segmentNo;

    @Column(name="CREATE_AUTO_SEGMENT")
    private int createAutoSegment;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;

    @Column(name="REMARKS")
    private String remarks;

    @Column(name="ENTERED_BY")
    private Long enteredBy;

    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimeStamp;

    @Column(name="UPDATE_BY")
    private Long updateBy;

    @Column(name="UPDATE_TIMESTAMP")
    private LocalDateTime updateTimeStamp;

    @Column(name="FLEX_FIELD1")
    private String flexField1;

    @Column(name="FLEX_FIELD2")
    private String flexField2;

    @Column(name="FLEX_FIELD3")
    private String flexField3;

    @Transient
    private boolean active;


}