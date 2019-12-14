package com.bz.mc.controller.shedule;


import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.shedule.ChargeShedule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ChargeSheduleController {


    private static final String BASE_ROUTE = "/shedule";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_LIST = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String shedule(Model model) {
        populateModel(model, new ChargeShedule());
        return "/web/pages/shedule/create";
    }


//    @GetMapping(ROUTE_LIST)
//    public String bookingList(Model model) {
//        populateModel(model, new ChargeGroup());
//        return "/web/pages/charge/list";
//    }



    private void populateModel(Model model, ChargeShedule chargeShedule) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("chargeSheduleForm", chargeShedule);


    }
}
