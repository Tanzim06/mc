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
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@NoArgsConstructor
public class ItemPriceForm {
    private Long id;
    private Long itemId;
    private Double itemRate;
    private Long currencyId;
   // @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private String effectiveFrom;
   // @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private String effectiveTo;
    private int activeStatus;
    private boolean active;
    //private String sActive;
    private String remarks;


    public ItemPriceForm(ItemPrice itemPrice ) {
        this.id = itemPrice.getId();
        this.itemId = itemPrice.getItemId();
        this.itemRate = itemPrice.getItemRate();
        this.currencyId =itemPrice.getCurrencyId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.effectiveFrom = formatter.format(itemPrice.getEffectiveFrom());
        DateTimeFormatter formatterTo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.effectiveTo = formatterTo.format(itemPrice.getEffectiveTo());;
        this.activeStatus = itemPrice.getActiveStatus();
        this.active=itemPrice.isActive();
        this.remarks = itemPrice.getRemarks();
    }


    public boolean isPersisted() {
        return id != null;
    }

}
