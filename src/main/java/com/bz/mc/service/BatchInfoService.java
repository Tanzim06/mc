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
   Optional <BatchInfo> getBatchInfo(Long id);

    Optional<BatchInfo> findBatchById(Long id);

   List<BatchInfo> getAllBatch(String batchName, String remarks, int activeStatus);

    BatchInfo getBatch(Long id);

//     public ArrayList<BatchInfo> getAllActiveBatch();
public List<BatchInfo> getBatchAllList();

}
