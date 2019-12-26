package com.bz.mc.service.impl;


import com.bz.mc.exception.NotFoundException;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.repository.ChargeGroupRepository;
import com.bz.mc.repository.ItemRepository;
import com.bz.mc.service.ChargeGroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ChargeGroupServiceImp implements ChargeGroupService {


    @NonNull
    private final ChargeGroupRepository chargeGroupRepository;

    @Override
    public ChargeGroup saveChargeGroup(ChargeGroup ChargeGroup) {
        return chargeGroupRepository.save(ChargeGroup);
    }


    @Override
    public Optional<ChargeGroup> findChargeGroupById(Long id) {
        return chargeGroupRepository.findById(id);
    }

    @Override
    public ChargeGroup getChargeGroup(Long id) {
        return findChargeGroupById(id).orElseThrow(NotFoundException::new);
    }


}
