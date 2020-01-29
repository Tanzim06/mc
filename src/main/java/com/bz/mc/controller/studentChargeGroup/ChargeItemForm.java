package com.bz.mc.controller.studentChargeGroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChargeItemForm {
    private  Long id;
    private String itemName;
    private Double itemRate;
    private Long currencyId;

//    private List<ChargeItem> chargeItemsForms = new ArrayList<>();
    public ChargeItemForm(Long id, String itemName, double itemRate, Long currencyId) {
        this.id = id;
        this.itemName = itemName;
        this.itemRate = itemRate;
        this.currencyId = currencyId;
    }

//    public ChargeItemForm(List<ChargeItem> chargeItemsForms) {
//        this.chargeItemsForms = chargeItemsForms;
//    }

    public boolean isPersisted() {
        return id != null;
    }



}
