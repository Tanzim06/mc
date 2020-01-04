package com.bz.mc.controller.charge;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.item.ItemForm;
import com.bz.mc.controller.item.ItemPriceForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.model.item.ItemPrice;
import com.bz.mc.service.*;
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
import java.util.List;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ChargeGroupController {


    @NonNull
    private final ChargeGroupService chargeGroupService;
    @NonNull  private final ChargeItemService chargeItemService;
    @NonNull private final WebLinkFactory webLinkFactory;
    @NonNull private final SessionManagementService sessionManagementService;
    @NonNull private final ProgramService programService;
    @NonNull private final SessionService sessionService;
    @NonNull private final SegmentInfoService segmentInfoService;
    @NonNull private final ItemService itemService;

    private static final String BASE_ROUTE = "/charge";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE_CHARGE_GROUP= BASE_ROUTE + "/save";
    private static final String ROUTE_SAVE_CHARGE_ITEM = BASE_ROUTE + "/chargeItem/save";
    public static final String ROUTE_EDIT = BASE_ROUTE + "/edit/{id}";
    public static final String ROUTE_EDIT_ITEM = BASE_ROUTE + "/item/edit/{id}";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    private static final String REDIRECT = "redirect:";

    private Long chargeGroupId;
    //private Long id;

    @GetMapping(ROUTE_CREATE )
    public String charge(Model model) {
        populateChargeGroupForm( model,new ChargeGroupForm());
        return "/web/pages/charge/create";
    }

    @PostMapping(ROUTE_SAVE_CHARGE_GROUP)
    public String saveChargeGroup(Model model, @ModelAttribute ChargeGroupForm chargeGroupForm, BindingResult result,RedirectAttributes redirectAttributes) {
        System.out.println("out");
        //employeeFormValidator.validate(employeeForm, result);
        if (result.hasErrors()) {
            // System.out.println("testee");
            populateChargeGroupForm( model,chargeGroupForm);
            return "/web/pages/charge/create";
        }
        System.out.println("test");
        //BatchInfo batchInfo =getBatchInfo(itemForm);

        ChargeGroup chargeGroup = prepareChargeGroup(chargeGroupForm);
        System.out.println("testyyy");
        System.out.println("id " + chargeGroup.getId());

        chargeGroup = chargeGroupService.saveChargeGroup(chargeGroup);

        System.out.print("id="+chargeGroup.getId());

        ChargeItem chargeItem = new ChargeItem();
        chargeItem.setChargeGroupId(chargeGroup.getId());
        System.out.print("itemid="+chargeItem.getItemId());
        System.out.println("test1");
        //return "/web/pages/batch/create";
        redirectAttributes.addFlashAttribute("message", "charge.chargeGroup.info.saved");
        return REDIRECT+ webLinkFactory.updateChargeUrl(chargeGroup.getId());
    }


    @PostMapping(ROUTE_SAVE_CHARGE_ITEM)
    public String savePrice(Model model, @ModelAttribute ChargeItemFrom chargeItemFrom, BindingResult result, RedirectAttributes redirectAttributes) {

        if(chargeGroupId!=null) {
            if (result.hasErrors()) {
                System.out.println("error");
                ChargeGroup chargeGroup = chargeGroupService.getChargeGroup(chargeGroupId);
                List<ChargeGroupData> chargeList = chargeItemService.getChargeGroupList(chargeGroupId);
                //ChargeGroupForm form= new ItemForm(itemInfo,priceList);
                ChargeGroupForm form = new ChargeGroupForm(chargeGroup, chargeList);
                //form.setItemPriceForm(itemPriceForm);
                form.setChargeItemFrom(chargeItemFrom);
                populateChargeGroupForm(model, form);
                return "/web/pages/charge/create";
            } else {

                System.out.println("out");
                ChargeItem chargeItem = prepareChargeItem(chargeItemFrom);
                // itemPrice = itemPriceService.saveItemPrice(itemPrice);
                chargeItem = chargeItemService.saveChargeItem(chargeItem);

              //model.addAttribute("chargeItemList", chargeItemService.getChargeitemList(chargeItem.getChargeGroupId()));
                List<ChargeGroupData> chargeItemList =chargeItemService.getChargeitemList(chargeItem.getChargeGroupId());
                System.out.println("chargeItemList Size = " +chargeItemList.size() );
                model.addAttribute("chargeItemList",chargeItemList );

                System.out.println("chargeGroupId = " + chargeItem.getChargeGroupId());
                redirectAttributes.addFlashAttribute("message", "charge.chargeItem.info.saved");
                //return REDIRECT + webLinkFactory.updateChargeUrl(chargeItem.getChargeGroupId());
                return REDIRECT + webLinkFactory.updateChargeUrl(chargeGroupId);

            }
        }
        redirectAttributes.addFlashAttribute("message", "charge.chargeItem.info.empty");
        return REDIRECT + ROUTE_CREATE;
    }

    @GetMapping(ROUTE_EDIT)
    public String editCharge(Model model, @PathVariable Long id) {
       this.chargeGroupId=id;
        ChargeGroup chargeGroup = chargeGroupService.getChargeGroup(chargeGroupId);
        ChargeItemFrom chargeItemFrom = new ChargeItemFrom();
        populateOtherFormData(model,chargeGroup, chargeItemFrom);
        return "/web/pages/charge/create";
    }
//
//    @GetMapping(ROUTE_EDIT_ITEM)
//    public String editItem(Model model, @PathVariable Long id) {
//
//        ChargeGroup chargeGroup = new ChargeGroup();
//        ChargeItemFrom chargeItemFrom = new ChargeItemFrom();
//        populateChargeGroupForm( model,new ChargeGroupForm());
////        model.addAttribute("chargeItemList", chargeItemService.getChargeitemList(id));
////        System.out.print("size"+chargeItemService.getChargeitemList(id).size());
////        List<ChargeGroupData> chargeItemList = chargeItemService.getChargeitemList(id);
////        ChargeGroupForm chargeGroupForm= new ChargeGroupForm(chargeGroup,chargeItemList);
//        //populateChargeGroupForm( model,chargeGroupForm);
//        //model.addAttribute("chargeItemList", chargeItemService.getChargeitemList(id));
//       // populateOtherFormData(model,chargeGroup, chargeItemFrom);
//
//        return "/web/pages/charge/create";
//
//    }

    @GetMapping(ROUTE_UPDATE)
    public String updateChargeItem(Model model, @PathVariable Long id,RedirectAttributes redirectAttributes) {
        ChargeItem chargeItem = chargeItemService.getChagreItem(id);
        this.chargeGroupId = chargeItem.getChargeGroupId();
        ChargeGroup  chargeGroup = chargeGroupService.getChargeGroup(chargeGroupId);
        ChargeItemFrom chargeItemFrom = new ChargeItemFrom(chargeItemService.getChagreItem(id));
        populateOtherFormData(model,chargeGroup, chargeItemFrom);
        return "/web/pages/charge/create";
    }

    private void populateOtherFormData(Model model,ChargeGroup chargeGroup,ChargeItemFrom chargeItemFrom){

        List<ChargeGroupData> chargeItemList =chargeItemService.getChargeitemList(chargeGroupId);
        System.out.println("chargeItemList = "+chargeItemList.size());
        ChargeGroupForm chargeGroupForm= new ChargeGroupForm(chargeGroup,chargeItemList);

        //form.setRemarks(itemInfo.getRemarks());
        chargeGroupForm.setChargeItemFrom(chargeItemFrom);

        if (chargeGroup.getActiveStatus()== 1 ) {
            chargeGroupForm.setActive(true);
        }
        else{
            chargeGroupForm.setActive(false);
        }

        if(chargeGroup.getId()!=null || chargeGroupId !=null){
            ChargeGroup c = chargeGroupService.getChargeGroup(chargeGroupId);
        }

        populateChargeGroupForm( model,chargeGroupForm);

    }


    @GetMapping(ROUTE_SEARCH)
    public String search(Model model) {
        populateChargeGroupForm( model,new ChargeGroupForm());
        return "/web/pages/charge/list";
    }


    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getChargeList(Model model, @RequestParam("chargeGroupName") String chargeGroupName, @RequestParam("remarks") String remarks,ChargeGroupForm chargeGroupForm,ChargeItemFrom chargeItemFrom) {

        List<ChargeGroupData> allchargeGroupList = chargeItemService.getChargeSearchResult(chargeGroupName,remarks);

        model.addAttribute("allchargeGroupList", allchargeGroupList);
        System.out.print("size"+allchargeGroupList.size());

        if (allchargeGroupList.size() != 0) {

            return "/web/pages/charge/list";
        }

//         if (chargeGroupForm.isGroup() == true){
//
//            System.out.print("group");
//
//            List<ChargeGroupData> allchargeGroupList = chargeItemService.getChargeSearchResult(chargeGroupName,remarks);
//
//            model.addAttribute("allchargeGroupList", allchargeGroupList);
//            System.out.print("size"+allchargeGroupList.size());
//
//            List<ChargeGroupData> allGroup = chargeItemService.getChargeGroupSearchResult(chargeGroupName,remarks,chargeGroupId);
//            model.addAttribute("allchargeGroupList", allGroup);
//            System.out.print("size"+allGroup.size());
//
//            if (allGroup.size() != 0) {
//
//                return "/web/pages/charge/list";
//            }
//        }
//        else{
//
//            List<ChargeGroupData> allchargeGroupList = chargeItemService.getChargeSearchResult(chargeGroupName,remarks);
//
//            model.addAttribute("allchargeGroupList", allchargeGroupList);
//            System.out.print("size"+allchargeGroupList.size());
//
//
//            if (allchargeGroupList.size() != 0) {
//
//                return "/web/pages/charge/list";
//            }
//        }


        return REDIRECT + ROUTE_SEARCH;
    }

    private void populateChargeGroupForm(Model model, ChargeGroupForm chargeGroupForm) {
        model.addAttribute("chargeGroupForm", chargeGroupForm);
        model.addAttribute("ChargeItemForm", chargeGroupForm.getChargeItemFrom());
        model.addAttribute("chargeItemList",chargeGroupForm.getChargeFormList());
        System.out.println("chargeItemListForm="+chargeGroupForm.getChargeFormList().size());
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        model.addAttribute("itemList", itemService.getAllActiveItem());

    }

    private ChargeGroup prepareChargeGroup(ChargeGroupForm chargeGroupForm ) {

        ChargeGroup chargeGroup ;
        if (chargeGroupForm.isPersisted()) {
            System.out.println("0");
            chargeGroup = chargeGroupService.getChargeGroup(chargeGroupForm.getId());
            System.out.println("000");
        }
        else {
            System.out.println("1");
            chargeGroup = ChargeGroup.builder().activeStatus(Constants.ACTIVE_STATUS).build();
            System.out.println("2");
        }

        System.out.println("4");
        chargeGroup.setChargeGroupName(chargeGroupForm.getChargeGroupName());
        System.out.println("5");
        chargeGroup.setShortCode(chargeGroupForm.getShortCode());
        System.out.println("6");
        chargeGroup.setSessionId(chargeGroupForm.getSessionId());
        System.out.println("7");
        chargeGroup.setProgramId(chargeGroupForm.getProgramId());
        System.out.println("8");
        chargeGroup.setProgramSegmentId(chargeGroupForm.getProgramSegmentId());
        System.out.println("9");
        chargeGroup.setChargeCycle(chargeGroupForm.getChargeCycle());
        System.out.println("10");
        chargeGroup.setPaymentCycle(chargeGroupForm.getPaymentCycle());
        System.out.println("11");
        chargeGroup.setRemarks(chargeGroupForm.getRemarks());
        System.out.println("12");
        chargeGroup.setActiveStatus(1);
        System.out.println("13");
        DateTimeFormatter formatterFrom = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate effectiveFrom = LocalDate.parse(chargeGroupForm.getEffectiveFrom(), formatterFrom);
        chargeGroup.setEffectiveFrom(effectiveFrom);
        System.out.println("14");
        DateTimeFormatter formatterTo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate effectiveTo= LocalDate.parse(chargeGroupForm.getEffectiveTo(), formatterTo);
        chargeGroup.setEffectiveTo(effectiveTo);
        System.out.println("15");
        chargeGroup.setOrigin(chargeGroupForm.getOrigin());
        System.out.println("16");

        return chargeGroup;
    }


    private ChargeItem prepareChargeItem(ChargeItemFrom chargeItemFrom) {
        ChargeItem chargeItem ;
        if (chargeItemFrom.isPersisted()) {
            //chargeItem = itemPriceService.getPrice(itemPriceForm.getId());
            chargeItem = chargeItemService.getChagreItem(chargeItemFrom.getId());
        }
        else {
            chargeItem = ChargeItem.builder()
                    .activeStatus(Constants.ACTIVE_STATUS)
                    .createdBy(sessionManagementService.getAuthenticatedUser().getId())
                    .build();
        }


        chargeItem.setChargeGroupId(chargeGroupId);
        chargeItem.setItemId(chargeItemFrom.getItemId());
        System.out.println("5");
        chargeItem.setItemRate(chargeItemFrom.getItemRate());
        System.out.println("6");
        chargeItem.setCurrencyId(chargeItemFrom.getCurrencyId());
        System.out.println("7");
        chargeItem.setRemarks(chargeItemFrom.getRemarks());
        System.out.println("8");
        chargeItem.setSessionId(chargeItemFrom.getSessionId());
        System.out.println("9");
        chargeItem.setProgramId(chargeItemFrom.getProgramId());
        System.out.println("10");
        chargeItem.setProgramSegmentId(chargeItemFrom.getProgramSegmentId());
        System.out.println("11");
        chargeItem.setActiveStatus(1);

//        if (chargeItemFrom.isActive()==true ) {
//            chargeItem.setActiveStatus(1);
//        }
//        else{
//            chargeItem.setActiveStatus(0);
//        }

        //itemPrice.setActiveStatus(1);
        chargeItem.setModifiedBy(sessionManagementService.getAuthenticatedUser().getId());
        return chargeItem;
    }
}
