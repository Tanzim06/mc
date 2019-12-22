package com.bz.mc.service.impl;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.repository.BatchInfoRepository;
import com.bz.mc.repository.ItemRepository;
import com.bz.mc.service.ItemService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ItemServiceImp implements ItemService {

    @NonNull
    private final ItemRepository itemRepository;


    @Override
    public ItemInfo saveItemInfo(ItemInfo itemInfo) {
        return itemRepository.save(itemInfo);
    }

    @Override
    public ItemInfo getItem(Long id) {
        return findItemById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<ItemInfo> findItemById(Long id) {
        return itemRepository.findById(id);
    }
}
