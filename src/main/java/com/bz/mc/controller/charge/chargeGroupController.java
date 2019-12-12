package com.bz.mc.controller.charge;

import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.charge.ChargeGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class chargeGroupController {


    private static final String BASE_ROUTE = "/charge";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_LIST = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String charge(Model model) {
        populateModel(model, new ChargeGroup());
        return "/web/pages/charge/create";
    }


    @GetMapping(ROUTE_LIST)
    public String bookingList(Model model) {
        populateModel(model, new ChargeGroup());
        return "/web/pages/charge/list";
    }



    private void populateModel(Model model, ChargeGroup chargeGroup) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("chargeForm", chargeGroup);


    }



}
