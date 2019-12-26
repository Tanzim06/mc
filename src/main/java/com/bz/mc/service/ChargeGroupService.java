package com.bz.mc.service;

import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.item.ItemInfo;

import java.util.Optional;

public interface ChargeGroupService {
    ChargeGroup saveChargeGroup(ChargeGroup chargeGroup);
    ChargeGroup getChargeGroup(Long id);

    Optional<ChargeGroup> findChargeGroupById(Long id);
}
