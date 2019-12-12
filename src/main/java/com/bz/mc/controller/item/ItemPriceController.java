package com.bz.mc.controller.item;


import com.bz.mc.model.item.ItemPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ItemPriceController {


    private static final String BASE_ROUTE = "/item";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    //private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_LIST = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

//    @GetMapping(ROUTE_CREATE )
//    public String itemPrice(Model model) {
//        populateModel(model, new ItemPrice());
//        return "/web/pages/item/create";
//    }




//    @GetMapping(ROUTE_LIST)
//    public String priceList(Model model) {
//        populateModel(model, new ItemPrice());
//
//        return "/web/pages/item/list";
//    }




    private void populateModel(Model model, ItemPrice itemPrice) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("itemPriceForm", itemPrice);


    }

}
