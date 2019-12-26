package com.bz.mc.repository;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.charge.ChargeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChargeItemRepository extends JpaRepository<ChargeItem,Long> {

    @Query("SELECT new com.bz.mc.facade.data.ChargeGroupData(b.id,a.chargeGroupName,a.shortCode,b.sessionId, b.programId, b.programSegmentId,a.chargeCycle,a.paymentCycle,b.activeStatus,b.chargeGroupId,b.itemId,b.itemRate,b.currencyId,b.remarks)" +
            " FROM ChargeGroup a inner join ChargeItem b on a.id = b.chargeGroupId " +
            " where  b.id = coalesce(:id,b.id)")
    List<ChargeGroupData> findChargeItemList(@Param("id") Long id);

}
