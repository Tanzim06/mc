package com.bz.mc.service;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.charge.Origin;
import com.bz.mc.model.item.ItemPrice;

import java.util.List;
import java.util.Optional;

public interface ChargeItemService {


    ChargeItem saveChargeItem(ChargeItem chargeItem);
    Optional<ChargeItem> findChargeItemById(Long id);
    List<ChargeGroupData> getChargeGroupList(Long chargeGroupId);
    List<ChargeGroupData> getChargeitemList(Long chargeGroupId);

//  public List<ChargeGroupData>  getChargeGroupSearchResult(String chargeGroupName,String remarks,Long chargeGroupId);
    ChargeItem getChagreItemByGroupId(Long id);
    ChargeItem getChagreItem(Long id);
    public List<ChargeGroupData>  getChargeSearchResult(String chargeGroupName, String remarks, Origin origin);

    public List<ChargeGroupData>  getScheduleSearchResult( Long sessionId,Long programId,Long programSegmentId);
    public List<ChargeGroupData>  getStudentChargeSearchResult( Long sessionId,String chargeGroupName, Origin origin);




}
