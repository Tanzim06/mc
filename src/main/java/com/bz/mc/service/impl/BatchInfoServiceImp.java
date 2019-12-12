package com.bz.mc.service.impl;

import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.repository.BatchInfoRepository;
import com.bz.mc.service.BatchInfoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: SHAHIDUL
 * Date: 11/12/19
 * Time: 10:00 PM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class BatchInfoServiceImp implements BatchInfoService {


    @NonNull
    private final BatchInfoRepository  batchInfoRepository ;

    @Override
    public BatchInfo saveBatchInfo(BatchInfo batchInfo) {
        return batchInfoRepository.save(batchInfo);
    }

    @Override
    public BatchInfo getBatchInfo(Long batchId) {
        return null;
    }


}
