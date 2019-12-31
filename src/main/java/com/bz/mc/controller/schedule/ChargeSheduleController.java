package com.bz.mc.controller.schedule;


import com.bz.mc.controller.charge.ChargeGroupForm;
import com.bz.mc.controller.charge.ChargeItemFrom;
import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.model.shedule.ChargeShedule;
import com.bz.mc.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_DETAILS = BASE_ROUTE + "/details";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String shedule(Model model) {
        populateBillDateForm (model, new BillDateForm());
        return "web/pages/schedule/search";
    }


    @GetMapping(ROUTE_DETAILS)
    public String scheduleList(Model model) {
        populateBillDateForm (model, new BillDateForm());
        return "/web/pages/schedule/charge-schedule";
    }

    @GetMapping(ROUTE_SEARCH)
    public String search(Model model) {
        populateBillDateForm (model, new BillDateForm());
        return "web/pages/schedule/search";
    }


    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getGroupList(Model model, BillDateForm billDateForm) {
//        List<ChargeGroupData>  groupData  = chargeItemService.getScheduleSearchResult(sessionId,programId,programSegmentId);
//        model.addAttribute("groupdataList", groupData);
//
//            if (groupData.size() != 0) {
//
//                return "web/pages/schedule/search";
//        }
        return REDIRECT + ROUTE_SEARCH;
    }




    private void populateBillDateForm (Model model, BillDateForm BillDateForm) {
        //model.addAttribute("chargeSheduleForm", chargeShedule);
        model.addAttribute("chargeSheduleForm", BillDateForm);
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        model.addAttribute("itemList", itemService.getAllActiveItem());


    }


}
