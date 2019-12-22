package com.bz.mc.service;

import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.model.item.ItemPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ItemPriceService {


    ItemPrice saveItemPrice(ItemPrice itemPrice);

    List<ItemPriceData> getItemPriceList(Long id);

    Optional<ItemPrice> findItemPriceById(Long id);

    public ArrayList<ItemPrice> getAllActivePrice();

    public List<ItemPrice> getItemPriceListByItemId(Long itemId);

    public List<ItemPriceData>  getItemPriceSearchResult(String itemName,String remarks);

    public List<ItemPriceData> getItemPriceEdit(Long id);


    ItemPrice getPrice(Long id);

}
