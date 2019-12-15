package com.bz.mc.service;

import com.bz.mc.model.batch.BatchInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User: SHAHIDUL
 * Date: 11/12/19
 * Time: 10:00 PM
 */

public interface BatchInfoService {


   BatchInfo saveBatchInfo(BatchInfo batchInfo);
   Optional <BatchInfo> getBatchInfo(Long batchId);

    Optional<BatchInfo> findBatchByBatchId(Long batchId);

//    List<BatchInfo> findBatch(Long  programId, String batchName);

     public ArrayList<BatchInfo> getAllActiveBatch();

}
