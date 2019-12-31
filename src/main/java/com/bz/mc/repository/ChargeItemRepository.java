package com.bz.mc.repository;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.charge.ChargeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChargeItemRepository extends JpaRepository<ChargeItem,Long> {

    @Query("SELECT new com.bz.mc.facade.data.ChargeGroupData(b.id,a.chargeGroupName,a.shortCode,b.sessionId, b.programId, b.programSegmentId,a.chargeCycle,a.paymentCycle,b.activeStatus,b.chargeGroupId,b.itemId,b.itemRate,b.currencyId,b.remarks,i.itemName,s.sessionName)" +
            " FROM ChargeGroup a inner join ChargeItem b on a.id = b.chargeGroupId inner join ItemInfo i on b.itemId = i.id  inner join SessionInfo s on   b.sessionId = s.id  " +
            " where b.chargeGroupId = coalesce(:chargeGroupId,b.chargeGroupId)")
    List<ChargeGroupData> findChargeItemList(@Param("chargeGroupId") Long chargeGroupId);

//    @Query("SELECT new com.bz.mc.facade.data.ChargeGroupData(b.id,a.chargeGroupName,a.shortCode,b.sessionId, b.programId, b.programSegmentId,a.chargeCycle,a.paymentCycle,b.activeStatus,b.chargeGroupId,b.itemId,b.itemRate,b.currencyId,b.remarks,i.itemName,s.sessionName)" +
//            " FROM ChargeGroup a inner join ChargeItem b on a.id = b.chargeGroupId inner join ItemInfo i on b.itemId = i.id  inner join SessionInfo s on   b.sessionId = s.id  " +
//            " where b.id = coalesce(:id,b.id)")
//    List<ChargeGroupData> findChargeItemListById(@Param("id") Long id);



    @Query("SELECT new com.bz.mc.facade.data.ChargeGroupData(b.id,a.chargeGroupName,a.shortCode,b.sessionId, b.programId, b.programSegmentId,a.chargeCycle,a.paymentCycle,b.activeStatus,b.chargeGroupId,b.itemId,b.itemRate,b.currencyId,a.remarks,i.itemName,s.sessionName)" +
            " FROM ChargeGroup a inner join ChargeItem b on a.id = b.chargeGroupId inner join ItemInfo i on b.itemId = i.id inner join SessionInfo s on   b.sessionId = s.id  " +
            " where  a.chargeGroupName LIKE CONCAT('%',:chargeGroupName, '%') and  a.remarks LIKE CONCAT('%',:remarks, '%') and  b.chargeGroupId  = coalesce(:chargeGroupId,b.chargeGroupId) ")
    List<ChargeGroupData> findAllGroup(@Param("chargeGroupName") String chargeGroupName, @Param("remarks") String remarks,@Param("chargeGroupId") Long chargeGroupId);

    @Query("SELECT new com.bz.mc.facade.data.ChargeGroupData(b.id,a.chargeGroupName,a.shortCode,b.sessionId, b.programId, b.programSegmentId,a.chargeCycle,a.paymentCycle,b.activeStatus,b.chargeGroupId,b.itemId,b.itemRate,b.currencyId,a.remarks,i.itemName,s.sessionName)" +
            " FROM ChargeGroup a inner join ChargeItem b on a.id = b.chargeGroupId inner join ItemInfo i on b.itemId = i.id inner join SessionInfo s on   b.sessionId = s.id  " +
            " where  a.chargeGroupName LIKE CONCAT('%',:chargeGroupName, '%') and  a.remarks LIKE CONCAT('%',:remarks, '%') ")
    List<ChargeGroupData> findAllChargeList(@Param("chargeGroupName") String chargeGroupName, @Param("remarks") String remarks);

    @Query("SELECT new com.bz.mc.facade.data.ChargeGroupData(a.id,a.chargeGroupName,a.shortCode,a.sessionId,a.programId, a.programSegmentId,a.chargeCycle,a.paymentCycle,b.activeStatus,b.chargeGroupId,b.itemId,b.itemRate,b.currencyId,a.remarks,i.itemName,s.sessionName,p.programName,ps.segmentName)" +
            " FROM ChargeGroup a inner join ChargeItem b on a.id = b.chargeGroupId inner join ItemInfo i on b.itemId = i.id inner join SessionInfo s on   b.sessionId = s.id inner join Program p on a.programId = p.id inner join ProgramSegment ps on a.programSegmentId = ps.id  " +
            " where  a.sessionId = coalesce(:sessionId,a.sessionId ) and a.programId = coalesce(:programId ,a.programId ) and a.programSegmentId = coalesce(:programSegmentId ,a.programSegmentId ) ")
    List<ChargeGroupData> findAllScheduleGroupData(@Param("sessionId") Long sessionId, @Param("programId") Long programId,@Param("programSegmentId") Long programSegmentId);

}
