package com.bz.mc.controller.item;

import com.bz.mc.model.item.ItemPrice;
import com.bz.mc.model.item.QItemPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class ItemPriceForm {
    private Long id;
    private Long itemId;
    private Double itemRate;
    private Long currencyId;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDate effectiveFrom;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDate effectiveTo;
    private int activeStatus;
    private boolean active;
    private String sActive;
    private String remarks;


    public ItemPriceForm(ItemPrice itemPrice ) {
        this.id = id;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.activeStatus = activeStatus;
        this.active = active;
        this.sActive = sActive;
        this.remarks = remarks;
    }


    public boolean isPersisted() {
        return id != null;
    }

}
