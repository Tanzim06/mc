package com.bz.mc.controller.admission;


import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.batch.BatchInfoForm;
import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.service.AdmissionService;
import com.bz.mc.service.ProgramService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class AdmissionController {

    @NonNull
    private final ProgramService programService;

    @NonNull
    private final AdmissionService admissionService;



   @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/admission";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_LIST = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/create/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String admission(Model model) {
        populateModel(model,  new AdmissionForm());
        return "/web/pages/admission/create";
    }

    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdateAdmission(Model model, @ModelAttribute AdmissionForm admissionForm, BindingResult result) {
        System.out.println("out");
        //employeeFormValidator.validate(employeeForm, result);
//        if (result.hasErrors()) {
//            System.out.println("testee");
//            populateModel(model, admissionForm);
//            return "/web/pages/admission/create";
//        }
        System.out.println("test");

        AdmissionBooking  admissionBooking = getAdmission(admissionForm);
        System.out.println("testyyy");
        System.out.println("id " + admissionBooking.getId());


        admissionBooking = admissionService.saveAdmission(admissionBooking);

        System.out.println("test1");

        return REDIRECT+ webLinkFactory.updateAdmissionUrl(admissionBooking);
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateAdmission(Model model, @PathVariable("id") Long id) {

        AdmissionBooking admissionBooking = admissionService.getAdmission(id).get();

        populateShowPageModel(model, admissionBooking);

        return "/web/pages/admission/create";
    }


    @GetMapping(ROUTE_LIST)
    public String bookingList(Model model) {
        populateModel(model, new AdmissionForm());

        return "/web/pages/admission/list";
    }




    private void populateModel(Model model, AdmissionForm admissionForm) {

        //model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("admissionForm", admissionForm);
        model.addAttribute("programs", programService.findPrograms());

    }

    private void populateShowPageModel(Model model, AdmissionBooking admissionBooking) {
        model.addAttribute("admissionForm", admissionBooking);

    }

    private AdmissionBooking getAdmission(AdmissionForm admissionForm ) {

        AdmissionBooking admissionBooking;
        if (admissionForm.isPersisted()) {
            System.out.println("0");

            //admissionBooking = batchInfoService.getBatchInfo(batchInfoForm.getId()).get();
            admissionBooking = admissionService.getAdmission(admissionForm.getId()).get();

            System.out.println("000");
        } else {
            System.out.println("1");
            //batchInfo = BatchInfo.builder().activeStatus(Constants.ACTIVE_STATUS).build();

            admissionBooking = AdmissionBooking.builder().activeStatus(Constants.ACTIVE_STATUS).build();
            System.out.println("2");
            //.orgId(sessionManagementService.getCurrentOrganization().getId())


//                  .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .build();
        }
        System.out.println("3");
        // batchInfo.setBatchId(batchInfo.getBatchId());
        System.out.println("4");
        admissionBooking.setSessionId(admissionForm.getSessionId());

        System.out.println("5");
        admissionBooking.setBookingDate(admissionForm.getBookingDate());
        System.out.println("6");
        admissionBooking.setStudentName(admissionForm.getStudentName());
        System.out.println("7");
        admissionBooking.setFatherName(admissionForm.getFatherName());
        System.out.println("8");
        admissionBooking.setMotherName(admissionForm.getMotherName());
        System.out.println("9");
        admissionBooking.setSpouseName(admissionForm.getSpouseName());
        System.out.println("10");
        admissionBooking.setBookingDate(admissionForm.getBookingDate());
        System.out.println("10");
        admissionBooking.setNID(admissionForm.getNID());
        System.out.println("10");
        admissionBooking.setContactNo(admissionForm.getContactNo());
        System.out.println("10");
        admissionBooking.setDOB(admissionForm.getDOB());
        System.out.println("10");
        admissionBooking.setPresentAdd(admissionForm.getPresentAdd());
        System.out.println("10");
        admissionBooking.setPermanentAdd(admissionForm.getPermanentAdd());
        System.out.println("10");

        admissionBooking.setAmountToBePaid(admissionForm.getAmountToBePaid());
        System.out.println("10");

        admissionBooking.setDateToBePaid(admissionForm.getDateToBePaid());
        System.out.println("10");

        admissionBooking.setAdvAmount(admissionForm.getAdvAmount());
        System.out.println("10");

        admissionBooking.setActiveStatus(admissionForm.getActiveStatus());
        admissionBooking.setActive(admissionForm.isActive());
        System.out.println("10");
        admissionBooking.setRemarks(admissionForm.getRemarks());
        System.out.println("10");


        return admissionBooking;


    }
    }
