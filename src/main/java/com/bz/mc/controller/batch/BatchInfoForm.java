package com.bz.mc.controller.batch;

import com.bz.mc.model.batch.BatchInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: SHI
 * Date: 10/11/19
 * Time: 04:39 pm
 */
@Getter
@Setter
@NoArgsConstructor
public class BatchInfoForm {
    private Long id;
    private String batchName;
    private String visualId;
    private String shortCode;
    private Long programId;
    private Long sessionId;
    private String remarks;


    public BatchInfoForm(BatchInfo batchInfo) {
        this.id = batchInfo.getId();
        this.batchName = batchInfo.getBatchName();
        this.visualId = batchInfo.getVisualId();
        this.shortCode = batchInfo.getShortCode();
        this.programId = batchInfo.getProgramId();
        this.sessionId = batchInfo.getSessionId();
        this.remarks = batchInfo.getRemarks();

    }

    public boolean isPersisted() {
        return id != null;
    }
}
