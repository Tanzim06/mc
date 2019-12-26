package com.bz.mc.repository;


//import com.bz.mc.facade.data.ItemData;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.model.item.ItemPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemInfo,Long> {


    public List<ItemInfo> findAllItemByActiveStatus(int activeStatus);
}
