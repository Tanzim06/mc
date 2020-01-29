package com.bz.mc.service;

import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.item.ItemInfo;

import java.util.List;
import java.util.Optional;

public interface ChargeGroupService {
    ChargeGroup saveChargeGroup(ChargeGroup chargeGroup);
    ChargeGroup getChargeGroup(Long id);

    Optional<ChargeGroup> findChargeGroupById(Long id);
    List<ChargeItem> findChargeItem(ChargeGroup chargeGroup);

}
