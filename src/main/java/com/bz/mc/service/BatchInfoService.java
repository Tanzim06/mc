package com.bz.mc.service;

import com.bz.mc.model.batch.BatchInfo;

/**
 * User: SHAHIDUL
 * Date: 11/12/19
 * Time: 10:00 PM
 */

public interface BatchInfoService {


    BatchInfo saveBatchInfo(BatchInfo batchInfo);
    BatchInfo getBatchInfo(Long batchId);

}
