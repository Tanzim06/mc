package com.bz.mc.facade;

//import com.bz.mc.facade.data.ItemData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.item.ItemInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemServiceFacade {



    List<ItemPriceData> findItems();

}
