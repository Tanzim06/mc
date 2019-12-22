package com.bz.mc.service;

//import com.bz.mc.facade.data.ItemData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.model.item.ItemInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemService {


    ItemInfo saveItemInfo(ItemInfo itemInfo);
    ItemInfo getItem(Long id);

    Optional<ItemInfo> findItemById(Long id);

//    List<ItemPriceData> findItems(Long itemId);
    //List<ItemInfo> findItems();
}
