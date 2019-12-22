package com.bz.mc.service.impl;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.item.ItemPrice;
import com.bz.mc.repository.ItemPriceRepository;
import com.bz.mc.repository.ItemRepository;
import com.bz.mc.service.ItemPriceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ItemPriceServiceImp implements ItemPriceService {


    @NonNull
    private final ItemPriceRepository itemPriceRepository;

    @Override
    public ItemPrice saveItemPrice(ItemPrice itemPrice) {
        return itemPriceRepository.save(itemPrice);
    }

    @Override
    public List<ItemPriceData> getItemPriceList(Long id) {
        return itemPriceRepository.findItemPriceList(id);
    }

//    @Override
//    public Optional<ItemPrice> getItemPrice(Long id) {
//        return findItemPriceById(id);
//    }

    @Override
    public Optional<ItemPrice> findItemPriceById(Long id) {
        return itemPriceRepository.findById(id);
    }

    @Override
    public ArrayList<ItemPrice> getAllActivePrice() {
        return (ArrayList<ItemPrice>) itemPriceRepository.findAll();
    }

    @Override
    public List<ItemPrice> getItemPriceListByItemId(Long itemId) {
        return itemPriceRepository.findItemPriceListByItemId(itemId);
    }

    @Override
    public List<ItemPriceData> getItemPriceSearchResult(String itemName, String remarks) {
        return  itemPriceRepository.findItemPrice(itemName,remarks) ;
    }

    @Override
    public List<ItemPriceData> getItemPriceEdit(Long id) {
        return itemPriceRepository.findItemPriceEdit(id);
    }

    @Override
    public ItemPrice getPrice(Long id) {
        return findItemPriceById(id).orElseThrow(NotFoundException::new);
    }
}
