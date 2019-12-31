package com.bz.mc.service.impl;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.item.ItemPrice;
import com.bz.mc.repository.ChargeGroupRepository;
import com.bz.mc.repository.ChargeItemRepository;
import com.bz.mc.repository.ItemPriceRepository;
import com.bz.mc.service.ChargeItemService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ChargeItemServiceImp implements ChargeItemService {


    @NonNull
    private final ChargeItemRepository chargeItemRepository;

    @Override
    public ChargeItem saveChargeItem(ChargeItem chargeItem) {
        return chargeItemRepository.save(chargeItem);
    }

    @Override
    public Optional<ChargeItem> findChargeItemById(Long id) {
        return chargeItemRepository.findById(id);
    }

    @Override
    public List<ChargeGroupData> getChargeGroupList(Long chargeGroupId) {
        return chargeItemRepository.findChargeItemList(chargeGroupId);
    }

    @Override
    public List<ChargeGroupData> getChargeGroupSearchResult(String chargeGroupName, String remarks, Long chargeGroupId) {
        return chargeItemRepository.findAllGroup(chargeGroupName,remarks,chargeGroupId) ;
    }

//    @Override
//    public List<ChargeGroupData> getChargeitemList(Long id) {
//        return chargeItemRepository.findChargeItemListById(id);
//    }

    @Override
    public ChargeItem getChagreItem(Long id) {
        return chargeItemRepository.findById(id).get();
    }

    @Override
    public List<ChargeGroupData> getChargeSearchResult(String chargeGroupName, String remarks) {
        return chargeItemRepository.findAllChargeList(chargeGroupName,remarks);
    }

    @Override
    public List<ChargeGroupData> getScheduleSearchResult(Long sessionId, Long programId, Long programSegmentId) {
        return chargeItemRepository.findAllScheduleGroupData(sessionId,programId,programSegmentId);
    }


}
