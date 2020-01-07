package com.bz.mc.controller.schedule;

import com.bz.mc.controller.charge.ChargeGroupForm;
import com.bz.mc.controller.charge.ChargeItemFrom;
import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.charge.Origin;
import com.bz.mc.model.shedule.StudentChargeGroup;
import com.bz.mc.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class StudentChargeGroupController {

    @NonNull
    private final ProgramService programService;
    @NonNull private final SessionService sessionService;
    @NonNull private final SegmentInfoService segmentInfoService;
    @NonNull private final ItemService itemService;
    @NonNull private final ChargeItemService chargeItemService;
    @NonNull private final ChargeGroupService chargeGroupService;
    @NonNull private final StudentChargeGroupService studentChargeGroupService;

    private static final String BASE_ROUTE = "/studentChargeGroup";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_DETAILS = BASE_ROUTE + "/details/{id}";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    private static final String REDIRECT = "redirect:";
    Long chargeGroupId;

    @GetMapping(ROUTE_SEARCH)
    public String searchGroup(Model model) {
        populateStudentGroupChargeForm(model,new StudentChargeGroupFrom());
        return "web/pages/schedule/studentGroupCharge";
    }

    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getGroupList(Model model, @RequestParam("sessionId") Long sessionId, @RequestParam("chargeGroupName") String chargeGroupName, @RequestParam("origin") Origin origin, StudentChargeGroupFrom studentChargeGroupFrom, ChargeGroupForm chargeGroupForm) {
        populateStudentGroupChargeForm(model,studentChargeGroupFrom);
        List<ChargeGroupData> studentChargeData = chargeItemService.getStudentChargeSearchResult(sessionId,chargeGroupName,origin);
        model.addAttribute("studentChargeDataList", studentChargeData);
        if (studentChargeData.size() != 0) {
            return "web/pages/schedule/studentGroupCharge";
        }
        return REDIRECT + ROUTE_SEARCH;
    }
    @GetMapping(ROUTE_DETAILS)
    public String studentChargeDetails(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        ChargeItem chargeItem = chargeItemService.getChagreItem(id);
        this.chargeGroupId = chargeItem.getChargeGroupId();
        ChargeGroup  chargeGroup = chargeGroupService.getChargeGroup(chargeGroupId);
        ChargeItemFrom chargeItemFrom = new ChargeItemFrom(chargeItemService.getChagreItem(id));
        populateOtherFormData(model,chargeGroup, chargeItemFrom);
//        populateOtherFormData(model,studentChargeGroup,chargeGroup,chargeItemFrom);
        return "web/pages/schedule/create";
    }

    private void populateOtherFormData(Model model,ChargeGroup chargeGroup,ChargeItemFrom chargeItemFrom){

        List<ChargeGroupData> chargeItemList =chargeItemService.getChargeitemList(chargeGroupId);
        System.out.println("chargeItemList = "+chargeItemList.size());
        ChargeGroupForm chargeGroupForm= new ChargeGroupForm(chargeGroup,chargeItemList);

        //form.setRemarks(itemInfo.getRemarks());
        chargeGroupForm.setChargeItemFrom(chargeItemFrom);

//        if (chargeGroup.getActiveStatus()== 1 ) {
//            chargeGroupForm.setActive(true);
//        }
//        else{
//            chargeGroupForm.setActive(false);
//        }

        if(chargeGroup.getId()!=null || chargeGroupId !=null){
            ChargeGroup c = chargeGroupService.getChargeGroup(chargeGroupId);
        }

        populateChargeGroupForm( model,chargeGroupForm);
    }

//    private void populateOtherFormData(Model model,StudentChargeGroup studentChargeGroup,ChargeGroup chargeGroup,ChargeItemFrom chargeItemFrom){
//        List<ChargeGroupData> chargeItemList =chargeItemService.getChargeitemList(chargeGroupId);
//        System.out.println("chargeItemList = "+chargeItemList.size());
//        ChargeGroupForm chargeGroupForm= new ChargeGroupForm(chargeGroup,chargeItemList);
//        chargeGroupForm.setChargeItemFrom(chargeItemFrom);
//        StudentChargeGroupFrom studentChargeGroupFrom = new StudentChargeGroupFrom(studentChargeGroup,chargeItemList);
//        populateStudentGroupChargeForm(model,studentChargeGroupFrom);
//
//    }
    private void populateChargeGroupForm(Model model, ChargeGroupForm chargeGroupForm) {
        model.addAttribute("chargeGroupForm", chargeGroupForm);
        model.addAttribute("ChargeItemForm", chargeGroupForm.getChargeItemFrom());
        model.addAttribute("chargeItemList",chargeGroupForm.getChargeFormList());
        System.out.println("chargeItemListForm="+chargeGroupForm.getChargeFormList().size());
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        model.addAttribute("itemList", itemService.getAllActiveItem());
        model.addAttribute("origins", Origin.all());
        System.out.println("origins"+Origin.all());

    }
    private void populateStudentGroupChargeForm (Model model, StudentChargeGroupFrom studentChargeGroupFrom) {
        model.addAttribute("studentChargeGroupFrom", studentChargeGroupFrom);
        model.addAttribute("chargeGroupForm", studentChargeGroupFrom.getChargeGroupFrom());
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        model.addAttribute("itemList", itemService.getAllActiveItem());
        model.addAttribute("origins", Origin.all());
    }


}
