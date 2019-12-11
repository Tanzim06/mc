package com.bz.mc.controller.admission;


import com.bz.mc.model.admission.AdmissionBooking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class AdmissionController {




//    @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/admission";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_LIST = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String batchInfo(Model model) {
        populateModel(model, new AdmissionBooking());
        return "/web/pages/admission/create";
    }


    @GetMapping(ROUTE_LIST)
    public String batchList(Model model) {
        populateModel(model, new AdmissionBooking());

        return "/web/pages/admission/list";
    }




    private void populateModel(Model model, AdmissionBooking admissionBooking) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("admissionForm", admissionBooking);


    }




}
