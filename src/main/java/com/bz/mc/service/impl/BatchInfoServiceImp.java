package com.bz.mc.service.impl;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.repository.BatchInfoRepository;
import com.bz.mc.service.BatchInfoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    @Transactional
    @Override
    public BatchInfo saveBatchInfo(BatchInfo batchInfo) {
        return batchInfoRepository.save(batchInfo);
    }

    @Override
    public Optional<BatchInfo> getBatchInfo(Long batchId) {
        return findBatchByBatchId(batchId);
        //return findBatchByBatchId(batchId).orElseThrow(NotFoundException::new);

    }

    @Override
    public Optional<BatchInfo> findBatchByBatchId(Long batchId) {
        return batchInfoRepository.findById(batchId);
    }


}
