package com.bz.mc.controller.studentChargeGroup;


import com.bz.mc.controller.charge.ChargeGroupForm;
import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.model.charge.Origin;
import com.bz.mc.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ChargeSheduleController {

    @NonNull
    private final ProgramService programService;
    @NonNull private final SessionService sessionService;
    @NonNull private final SegmentInfoService segmentInfoService;
    @NonNull private final ItemService itemService;
    @NonNull private final ChargeItemService chargeItemService;

    private static final String BASE_ROUTE = "/schedule";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    private static final String ROUTE_SEARCH_RESULT_GROUP = BASE_ROUTE + "/group";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    //public static final String ROUTE_DETAILS = BASE_ROUTE + "/details";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String shedule(Model model) {
        populateBillDateForm (model, new BillDateForm());
        return "web/pages/schedule/create";
    }

//    @GetMapping(ROUTE_DETAILS)
//    public String scheduleList(Model model) {
//        populateBillDateForm (model, new BillDateForm());
//        return "/web/pages/schedule/create";
//    }

    @GetMapping(ROUTE_SEARCH)
    public String search(Model model) {
        populateBillDateForm (model, new BillDateForm());
        return "web/pages/schedule/search";
    }

    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getGroupList(Model model, @RequestParam("sessionId") Long sessionId,@RequestParam("programId") Long programId,@RequestParam("programSegmentId") Long programSegmentId,BillDateForm billDateForm,ChargeGroupForm chargeGroupForm) {
        populateBillDateForm (model, billDateForm);
        List<ChargeGroupData>  groupData  = chargeItemService.getScheduleSearchResult(sessionId,programId,programSegmentId);
        model.addAttribute("groupdataList", groupData);
            if (groupData.size() != 0) {
                return "web/pages/schedule/search";
        }
        return REDIRECT + ROUTE_SEARCH;
    }

//    @GetMapping(ROUTE_SEARCH_RESULT_GROUP)
//    public String searchGroup(Model model) {
//        populateBillDateForm (model, new BillDateForm());
//        return "web/pages/schedule/studentGroupCharge";
//    }

    @GetMapping(ROUTE_UPDATE)
    public String updateChargeItem(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        //ChargeItem chargeItem = chargeItemService.getChagreItem(id);
//        this.chargeGroupId = chargeItem.getChargeGroupId();
//        ChargeGroup chargeGroup = chargeGroupService.getChargeGroup(chargeGroupId);
//        ChargeItemFrom chargeItemFrom = new ChargeItemFrom(chargeItemService.getChagreItem(id));
//        populateOtherFormData(model,chargeGroup, chargeItemFrom);


        return "/web/pages/schedule/create";
    }

//    @PostMapping(ROUTE_SAVE)
//    public String saveChargeGroup(Model model, @ModelAttribute ChargeGroupForm chargeGroupForm, BindingResult result, RedirectAttributes redirectAttributes) {
//        System.out.println("out");
//        //employeeFormValidator.validate(employeeForm, result);
//        if (result.hasErrors()) {
//            // System.out.println("testee");
//            populateChargeGroupForm( model,chargeGroupForm);
//            return "/web/pages/charge/create";
//        }
//        System.out.println("test");
//        //BatchInfo batchInfo =getBatchInfo(itemForm);
//
//        ChargeGroup chargeGroup = prepareChargeGroup(chargeGroupForm);
//        System.out.println("testyyy");
//        System.out.println("id " + chargeGroup.getId());
//
//        chargeGroup = chargeGroupService.saveChargeGroup(chargeGroup);
//
//        System.out.print("id="+chargeGroup.getId());
//
//        ChargeItem chargeItem = new ChargeItem();
//        chargeItem.setChargeGroupId(chargeGroup.getId());
//        System.out.print("itemid="+chargeItem.getItemId());
//        System.out.println("test1");
//        //return "/web/pages/batch/create";
//        redirectAttributes.addFlashAttribute("message", "charge.chargeGroup.info.saved");
//        return REDIRECT+ webLinkFactory.updateChargeUrl(chargeGroup.getId());
//    }





    private void populateBillDateForm (Model model, BillDateForm BillDateForm) {
        //model.addAttribute("chargeSheduleForm", chargeShedule);
        model.addAttribute("chargeSheduleForm", BillDateForm);
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        model.addAttribute("itemList", itemService.getAllActiveItem());
        model.addAttribute("origins", Origin.all());



    }


}
