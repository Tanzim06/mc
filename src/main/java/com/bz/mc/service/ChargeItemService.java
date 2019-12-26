package com.bz.mc.service;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.item.ItemPrice;

import java.util.List;
import java.util.Optional;

public interface ChargeItemService {


    ChargeItem saveChargeItem(ChargeItem chargeItem);
    Optional<ChargeItem> findChargeItemById(Long id);
    List<ChargeGroupData> getChargeGroupList(Long id);

    ChargeItem getChagreItem(Long id);
}