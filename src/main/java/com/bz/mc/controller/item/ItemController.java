package com.bz.mc.controller.item;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.batch.BatchInfoForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.model.item.ItemPrice;
import com.bz.mc.service.BatchInfoService;
import com.bz.mc.service.ItemPriceService;
import com.bz.mc.service.ItemService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ItemController {


    @NonNull  private final ItemService itemService;
    @NonNull  private final ItemPriceService itemPriceService;
    @NonNull private final WebLinkFactory webLinkFactory;
    @NonNull private final SessionManagementService sessionManagementService;

    private static final String BASE_ROUTE = "/item";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE_ITEM = BASE_ROUTE + "/save";
    private static final String ROUTE_SAVE_PRICE = BASE_ROUTE + "/price/save";
    public static final String ROUTE_EDIT = BASE_ROUTE + "/edit/{id}";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/price/update/{id}";
    private static final String REDIRECT = "redirect:";

    private Long itemId;

    @GetMapping(ROUTE_CREATE )
    public String itemInfo(Model model) {
       populateItemForm(model, new ItemForm());
        return "/web/pages/item/create";
    }


    @PostMapping(ROUTE_SAVE_ITEM)
    public String saveItem(Model model, @ModelAttribute ItemForm itemForm, BindingResult result,RedirectAttributes redirectAttributes) {
        System.out.println("out");
        //employeeFormValidator.validate(employeeForm, result);
        if (result.hasErrors()) {
            // System.out.println("testee");
            populateItemForm(model, itemForm);
            return "/web/pages/item/create";
        }
        System.out.println("test");
        //BatchInfo batchInfo =getBatchInfo(itemForm);
        ItemInfo itemInfo = prepareItem(itemForm);
        System.out.println("testyyy");
        System.out.println("id " + itemInfo.getId());

        itemInfo = itemService.saveItemInfo(itemInfo);

              System.out.print("id="+itemInfo.getId());

          ItemPrice  itemPrice = new ItemPrice();
          itemPrice.setItemId(itemInfo.getId());

        System.out.print("itemid="+itemPrice.getItemId());

        System.out.println("test1");
        //return "/web/pages/batch/create";
        redirectAttributes.addFlashAttribute("message", "item.info.saved");
        return REDIRECT+ webLinkFactory.updatePriceUrl(itemInfo.getId());
    }

    @PostMapping(ROUTE_SAVE_PRICE)
    public String savePrice(Model model, @ModelAttribute ItemPriceForm itemPriceForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if(itemId!=null){
            if (result.hasErrors()) {

                System.out.println("error");
                ItemInfo itemInfo = itemService.getItem(itemId);
                List<ItemPriceData> priceList =itemPriceService.getItemPriceList(itemId);
                ItemForm form= new ItemForm(itemInfo,priceList);
                form.setItemPriceForm(itemPriceForm);
                populateItemForm(model,form);
                return "/web/pages/item/create";
            }
            else{
                System.out.println("out");
                ItemPrice itemPrice=prepareItemPrice(itemPriceForm);
                itemPrice = itemPriceService.saveItemPrice(itemPrice);

                model.addAttribute("itemPriceList",itemPriceService.getItemPriceListByItemId(itemPrice.getItemId()));

                redirectAttributes.addFlashAttribute("message", "item.price.info.saved");
                return REDIRECT + webLinkFactory.updatePriceUrl(itemId);
            }
        }
        redirectAttributes.addFlashAttribute("message", "item.price.info.saved");
        return REDIRECT + ROUTE_CREATE;
    }

    @GetMapping(ROUTE_EDIT)
    public String editItem(Model model, @PathVariable Long id) {
        this.itemId=id;
        ItemInfo itemInfo = itemService.getItem(itemId);
        //List<ItemPriceData> priceList =itemPriceService.getItemPriceList(itemId);
       // ItemForm itemForm= new ItemForm(itemInfo, priceList);

        ItemPriceForm itemPriceform = new ItemPriceForm();

        populateOtherFormData(model,itemInfo, itemPriceform);
        //populateItemForm(model,form);
        return "/web/pages/item/create";
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateItemPrice(Model model, @PathVariable Long id,RedirectAttributes redirectAttributes) {
        ItemPrice itemPrice=itemPriceService.getPrice(id);
        this.itemId=itemPrice.getItemId();
        ItemInfo itemInfo = itemService.getItem(itemId);
        //List<ItemPriceData> priceList =itemPriceService.getItemPriceList(itemId);
        //ItemForm form= new ItemForm(itemInfo,ROUTE_EDIT priceList);
        ItemPriceForm itemPriceform = new ItemPriceForm(itemPriceService.getPrice(id));
        populateOtherFormData(model,itemInfo, itemPriceform);
        model.addAttribute("mode","edit");
        return "/web/pages/item/create";
    }


    @GetMapping(ROUTE_SEARCH)
    public String itemList(Model model) {
        populateItemForm(model, new ItemForm());
        return "/web/pages/item/search";
    }


    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getItemList(Model model, @RequestParam("itemName") String itemName, @RequestParam("remarks") String remarks) {

        List<ItemPriceData> itemPriceDataList = itemPriceService.getItemPriceSearchResult(itemName,remarks);

        model.addAttribute("itemPriceDataList", itemPriceDataList);
        if (itemPriceDataList.size() != 0) {

            return "/web/pages/item/search";
        }
        return REDIRECT + ROUTE_SEARCH;
    }

    private void populateOtherFormData(Model model,ItemInfo itemInfo,ItemPriceForm itemPriceForm){

        List<ItemPriceData> priceList =itemPriceService.getItemPriceList(itemId);
        ItemForm form= new ItemForm(itemInfo,priceList);

        if (itemInfo.getBillFlag()== 1 && itemInfo.getInventoryFlag() ==1 ) {
            form.setBill(true);
            form.setInventory(true);
        }
        else if (itemInfo.getBillFlag()== 1) {
            form.setBill(true);
        }
        else if (itemInfo.getInventoryFlag() ==1 ) {
            form.setInventory(true);
        }
        else {
            form.setBill(false);
            form.setInventory(false);
        }


        if (itemInfo.getActiveStatus()== 1 ) {
            form.setActive(true);

        }
        else{
            form.setActive(false);
        }
        form.setRemarks(itemInfo.getRemarks());
        form.setItemPriceForm(itemPriceForm);

        //form.setTabId(currentTab);
        if(itemInfo.getId()!=null || itemId !=null){
            ItemInfo i=itemService.getItem(itemId);
        }
        populateItemForm(model,form);
    }




    private ItemInfo prepareItem(ItemForm itemForm ) {

        ItemInfo itemInfo ;
        if (itemForm.isPersisted()) {
            System.out.println("0");

            //batchInfo = batchInfoService.getBatchInfo(batchInfoForm.getId()).get();
            itemInfo = itemService.getItem(itemForm.getId());
            System.out.println("000");
        }
        else {
            System.out.println("1");
            itemInfo = ItemInfo.builder().activeStatus(Constants.ACTIVE_STATUS).build();
            System.out.println("2");
            //.orgId(sessionManagementService.getCurrentOrganization().getId())
//                  .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .build();
        }
        System.out.println("3");
        // batchInfo.setBatchId(batchInfo.getBatchId());
        System.out.println("4");
        itemInfo.setItemName(itemForm.getItemName());
        System.out.println("5");
        itemInfo.setBillFlag(itemForm.getBillFlag());
        System.out.println("6");
        itemInfo.setBill(itemForm.isBill());
        System.out.println("7");
        itemInfo.setInventoryFlag(itemForm.getInventoryFlag());
        System.out.println("8");
        itemInfo.setInventory(itemForm.isInventory());
        System.out.println("9");
        itemInfo.setActiveStatus(itemForm.getActiveStatus());
//        System.out.println("10");

        itemInfo.setActive(itemForm.isActive());
//        System.out.println("10");
        itemInfo.setRemarks(itemForm.getRemarks());
        System.out.println("10");

        if (itemForm.isBill() == true && itemForm.isInventory() == true ) {
            itemInfo.setBillFlag(1);
            itemInfo.setInventoryFlag(1);
        }
        else if (itemForm.isBill() == true) {
            itemInfo.setBillFlag(1);
        }
        else if (itemForm.isInventory() == true) {
            itemInfo.setInventoryFlag(1);
        }
        else {
            itemInfo.setBillFlag(0);
            itemInfo.setInventoryFlag(0);
        }

        if (itemForm.isActive()==true ) {
            itemInfo.setActiveStatus(1);
        }
        else{
            itemInfo.setActiveStatus(0);
        }

        //itemInfo.setActiveStatus(1);

        return itemInfo;

    }



    private void populateItemForm(Model model, ItemForm itemForm) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("itemForm", itemForm);
        model.addAttribute("itemPriceForm", itemForm.getItemPriceForm());
        model.addAttribute("itemPriceList",itemForm.getItemPriceFormList());
    }


    private ItemPrice prepareItemPrice(ItemPriceForm itemPriceForm) {
        ItemPrice itemPrice ;
        if (itemPriceForm.isPersisted()) {
            itemPrice = itemPriceService.getPrice(itemPriceForm.getId());
        }
        else {
            itemPrice = ItemPrice.builder()
                    .activeStatus(Constants.ACTIVE_STATUS)
                    .createdBy(sessionManagementService.getAuthenticatedUser().getId())
                    .build();
        }
        itemPrice.setItemId(itemId);
        System.out.println("5");
        itemPrice.setItemRate(itemPriceForm.getItemRate());
        System.out.println("6");
        itemPrice.setCurrencyId(itemPriceForm.getCurrencyId());
        System.out.println("7");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate effectiveFrom = LocalDate.parse(itemPriceForm.getEffectiveFrom(), formatter);
        itemPrice.setEffectiveFrom(effectiveFrom);

        DateTimeFormatter formatterTo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate effectiveTo = LocalDate.parse(itemPriceForm.getEffectiveTo(), formatter);
        itemPrice.setEffectiveTo(effectiveTo);

        System.out.println("9");
        itemPrice.setActiveStatus(itemPriceForm.getActiveStatus());
        System.out.println("10");
        itemPrice.setActive(itemPriceForm.isActive());
        System.out.println("10");
        itemPrice.setRemarks(itemPriceForm.getRemarks());
        System.out.println("10");

        if (itemPriceForm.isActive()==true ) {
            itemPrice.setActiveStatus(1);
        }
        else{
            itemPrice.setActiveStatus(0);
        }

        //itemPrice.setActiveStatus(1);
        itemPrice.setModifiedBy(sessionManagementService.getAuthenticatedUser().getId());
        return itemPrice;
    }

    private void populateModelPrice(Model model, ItemPriceForm itemPriceForm) {
        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("itemPriceForm", itemPriceForm);
    }


}
