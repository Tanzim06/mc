package com.bz.mc.controller.admission;


import com.bz.mc.controller.batch.BatchInfoForm;
import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.batch.BatchInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String admissionb(Model model) {
        populateModel(model, new AdmissionBooking());
        return "/web/pages/admission/create";
    }

//    @PostMapping(ROUTE_SAVE)
//    public String saveOrUpdateAdmission(Model model, @ModelAttribute AdmissionForm admissionForm, BindingResult result) {
////        System.out.println("out");
////        //employeeFormValidator.validate(employeeForm, result);
////        if (result.hasErrors()) {
////            // System.out.println("testee");
////            populateModel(model, batchInfoForm);
////            return "/web/pages/batch/create";
////        }
////        System.out.println("test");
////        BatchInfo batchInfo =getBatchInfo(batchInfoForm);
////        System.out.println("testyyy");
////        System.out.println("id " + batchInfo.getId());
////        batchInfo = batchInfoService.saveBatchInfo(batchInfo);
////
////        System.out.println("test1");
////        //return "/web/pages/batch/create";
//        return REDIRECT+ webLinkFactory.updateBatchUrl(batchInfo);
//    }


    @GetMapping(ROUTE_LIST)
    public String bookingList(Model model) {
        populateModel(model, new AdmissionBooking());

        return "/web/pages/admission/list";
    }




    private void populateModel(Model model, AdmissionBooking admissionBooking) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("admissionForm", admissionBooking);


    }




}
