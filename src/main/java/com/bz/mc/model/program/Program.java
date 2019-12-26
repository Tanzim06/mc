package com.bz.mc.model.program;


import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name="PROGRAM_INFO")
public class Program extends BaseEntity implements Auditable {

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
    private Long createdBy;

    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name="UPDATE_BY")
    private Long modifiedBy;

    @Column(name="UPDATE_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name="FLEX_FIELD1")
    private String flexField1;

    @Column(name="FLEX_FIELD2")
    private String flexField2;

    @Column(name="FLEX_FIELD3")
    private String flexField3;

    @Transient
    private boolean active;

    public Program(Long branchId, Long deptId, String programName, String programDesc, String userProgarmNo, String shortCode, Long progarmTypeId, int segmentNo, int createAutoSegment, int activeStatus, String remarks, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt, String flexField1, String flexField2, String flexField3, boolean active) {
        this.branchId = branchId;
        this.deptId = deptId;
        this.programName = programName;
        this.programDesc = programDesc;
        this.userProgarmNo = userProgarmNo;
        this.shortCode = shortCode;
        this.progarmTypeId = progarmTypeId;
        this.segmentNo = segmentNo;
        this.createAutoSegment = createAutoSegment;
        this.activeStatus = activeStatus;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.flexField1 = flexField1;
        this.flexField2 = flexField2;
        this.flexField3 = flexField3;
        this.active = active;
    }
}