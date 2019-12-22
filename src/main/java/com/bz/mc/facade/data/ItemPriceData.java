package com.bz.mc.facade.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class ItemPriceData {

    private Long id;
    private String itemName;
    private int billFlag;
    private int inventoryFlag;
    private String remarks;
    private int activeStatus;
    private Double itemRate;
    private Long currencyId;



    public ItemPriceData(Long id, String itemName, int billFlag, int inventoryFlag, Double itemRate, int activeStatus, Long currencyId) {

    this.id=id;
    this.itemName=itemName;
    this.billFlag=billFlag;
    this.inventoryFlag=inventoryFlag;
    this.itemRate = itemRate;
    this.activeStatus = activeStatus;
    this.currencyId = currencyId;


    }
}
