package com.bz.mc.facade.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private Long itemId;


    public ItemPriceData(Long id, Long itemId,String itemName, int billFlag, int inventoryFlag, Double itemRate, int activeStatus, Long currencyId, LocalDate effectiveFrom,LocalDate effectiveTo,String remarks) {
    this.id=id;
    this.itemId = itemId;
    this.itemName=itemName;
    this.billFlag=billFlag;
    this.inventoryFlag=inventoryFlag;
    this.itemRate = itemRate;
    this.activeStatus = activeStatus;
    this.currencyId = currencyId;
    this.effectiveFrom =effectiveFrom;
    this.effectiveTo = effectiveTo;
    this.remarks = remarks;
    }



}
