package com.bz.mc.repository;

import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.item.ItemPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemPriceRepository extends JpaRepository <ItemPrice,Long>{


    @Query("select a from ItemPrice a where   a.itemId=:itemId ")
    public List<ItemPrice> findItemPriceListByItemId(@Param("itemId") Long itemId);

    @Query("SELECT new com.bz.mc.facade.data.ItemPriceData( b.id,a.id,a.itemName,a.billFlag,a.inventoryFlag, b.itemRate, b.activeStatus," +
            "b.currencyId,b.effectiveFrom,b.effectiveTo,b.remarks) FROM ItemInfo a inner join ItemPrice b on a.id = b.itemId " +
            " where  a.id = coalesce(:id,a.id)")
    List<ItemPriceData> findItemPriceList(@Param("id") Long id);



    @Query("SELECT new com.bz.mc.facade.data.ItemPriceData(b.id,a.id, a.itemName,a.billFlag,a.inventoryFlag, b.itemRate, b.activeStatus," +
            " b.currencyId,b.effectiveFrom,b.effectiveTo,b.remarks) FROM ItemInfo a inner join ItemPrice b on a.id = b.itemId " +
            " where  a.itemName LIKE CONCAT('%',:itemName, '%') and " +
            " b.remarks LIKE CONCAT('%',:remarks, '%')")
    List<ItemPriceData> findItemPrice(@Param("itemName") String itemName, @Param("remarks") String remarks);

//    @Query("SELECT new com.bz.mc.facade.data.ItemPriceData(a.id, a.itemName,a.billFlag,a.inventoryFlag, b.itemRate, b.activeStatus," +
//            " b.currencyId,b.effectiveFrom,b.effectiveTo,b.remarks) FROM ItemInfo a inner join ItemPrice b on a.id = b.itemId " +
//            " where  a.id = coalesce(:id,a.id)" )
//    List<ItemPriceData> findItemPriceEdit(@Param("id") Long id);





}
