package com.bz.mc.controller.item;


import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.item.ItemInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ItemForm {

    private Long id;
    private String itemName;
    private int billFlag;
    private int inventoryFlag;
    private boolean bill;
    private boolean inventory;
    private boolean active;
    private String sActive;
    private String remarks;
    private int activeStatus;

     private ItemPriceForm itemPriceForm = new ItemPriceForm();
   // private List<ItemPriceData> iPriceForm = new ArrayList<>() ;
    private List<ItemPriceData> itemPriceFormList = new ArrayList<>();
    //private List<ItemPriceData> itemPriceDataList = new ArrayList<>();


    public ItemForm(ItemInfo itemInfo) {
        this.id = itemInfo.getId();
        this.itemName = itemInfo.getItemName();
        this.billFlag = itemInfo.getBillFlag();
        this.inventoryFlag = itemInfo.getInventoryFlag();
        this.bill = itemInfo.isBill();
        this.inventory = itemInfo.isInventory();
        this.active = itemInfo.isActive();
        this.sActive = itemInfo.getSActive();
        this.remarks = itemInfo.getRemarks();
        this.activeStatus= itemInfo.getActiveStatus();
    }

    public ItemForm(ItemInfo  itemInfo, List<ItemPriceData> priceList){
        this.id=itemInfo.getId();
        populateItemInfo(itemInfo);
        populateItemPrice(priceList);

    }


    public void populateItemInfo(ItemInfo itemInfo){
        this.id=itemInfo.getId();
        this.itemName=itemInfo.getItemName();
        this.billFlag = itemInfo.getBillFlag();
        this.inventoryFlag = itemInfo.getInventoryFlag();
        this.bill = itemInfo.isBill();
        this.inventory = itemInfo.isInventory();
        this.active = itemInfo.isActive();
        this.sActive = itemInfo.getSActive();
        this.remarks = itemInfo.getRemarks();
        this.activeStatus= itemInfo.getActiveStatus();


    }

    public void populateItemPrice(List<ItemPriceData> priceList){
        for(ItemPriceData p : priceList){
            itemPriceFormList.add(p);
        }
    }



    public boolean isPersisted() {
        return id != null;
    }






}
