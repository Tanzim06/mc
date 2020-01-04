package com.bz.mc.controller.admission;

/**
 * User: shahidul
 * Date: 02-01-2020
 * Time: 16:31
 */
import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.batch.BatchInfoForm;
import com.bz.mc.controller.item.ItemForm;
import com.bz.mc.controller.item.ItemPriceForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.facade.data.ItemPriceData;
import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.model.item.ItemInfo;
import com.bz.mc.service.AdmissionService;
import com.bz.mc.service.ProgramService;
import com.bz.mc.service.SessionService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class AdmissionController {
    @NonNull
    private final ProgramService programService;
    @NonNull
    private final AdmissionService admissionService;
    @NonNull private final SessionService sessionService;
   @NonNull private final WebLinkFactory webLinkFactory;
    @NonNull private final SessionManagementService sessionManagementService;

    private static final String BASE_ROUTE = "/admission";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    public static final String ROUTE_SEARCH_RESULT= BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/create/{id}";
    private static final String REDIRECT = "redirect:";

    private Long id;

    @GetMapping(ROUTE_CREATE )
    public String admission(Model model) {
        populateAdmissionForm(model,  new AdmissionForm());
        return "/web/pages/admission/create";
    }

    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdateAdmission(Model model, @ModelAttribute AdmissionForm admissionForm, BindingResult result, RedirectAttributes redirectAttributes) {
        System.out.println("out");
        //employeeFormValidator.validate(employeeForm, result);
        if (result.hasErrors()) {
            System.out.println("testee");
            populateAdmissionForm(model, admissionForm);
            return "/web/pages/admission/create";
        }
        System.out.println("test");
        AdmissionBooking  admissionBooking = getAdmission(admissionForm);
        System.out.println("testyyy");
        System.out.println("id " + admissionBooking.getId());
        admissionBooking = admissionService.saveAdmission(admissionBooking);
        System.out.println("test1");
        redirectAttributes.addFlashAttribute("message", "admission.admissionBooking.info.saved");
        return REDIRECT+ webLinkFactory.updateAdmissionUrl(admissionBooking.getId());
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateAdmission(Model model, @PathVariable("id") Long id) {
        AdmissionBooking admissionBooking = admissionService.getAdmission(id).get();
        AdmissionForm admissionForm = new AdmissionForm(admissionBooking);
        populateFormData(model,admissionBooking,admissionForm);
        //populateAdmissionForm(model, admissionForm);
        return "/web/pages/admission/create";
    }


    @GetMapping(ROUTE_SEARCH)
    public String bookingList(Model model) {
        populateAdmissionForm(model, new AdmissionForm());

        return "/web/pages/admission/list";
    }



    private void populateFormData(Model model, AdmissionBooking admissionBooking, AdmissionForm admissionForm){

//        List<ItemPriceData> priceList =itemPriceService.getItemPriceList(itemId);
//        ItemForm form= new ItemForm(itemInfo,priceList);
        if (admissionBooking.getActiveStatus()==1){
            admissionForm.setActive(true);
        }else {
            admissionForm.setActive(false);
        }

        if (admissionBooking.getConfirmFlag()==1){
            admissionForm.setConfirm(true);
        }else {
            admissionForm.setConfirm(false);
        }

        populateAdmissionForm(model, admissionForm);
    }


    private void populateAdmissionForm(Model model, AdmissionForm admissionForm) {
        model.addAttribute("admissionForm", admissionForm);
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());

    }

//    private void populateShowPageModel(Model model, AdmissionBooking admissionBooking) {
//        model.addAttribute("admissionForm", admissionBooking);
//
//    }

    private AdmissionBooking getAdmission(AdmissionForm admissionForm ) {

        AdmissionBooking admissionBooking;
        if (admissionForm.isPersisted()) {
            System.out.println("0");
            admissionBooking = admissionService.getAdmission(admissionForm.getId()).get();
            System.out.println("000");
        } else {
            System.out.println("1");
            //batchInfo = BatchInfo.builder().activeStatus(Constants.ACTIVE_STATUS).build();

            admissionBooking = AdmissionBooking.builder().activeStatus(Constants.ACTIVE_STATUS)
                    .createdBy(sessionManagementService.getAuthenticatedUser().getId())
                    .build();
            System.out.println("2");
        }
        System.out.println("3");
        System.out.println("4");
        admissionBooking.setSessionId(admissionForm.getSessionId());
        System.out.println("5");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bookingdate = LocalDate.parse(admissionForm.getBookingDate(), formatter);
        admissionBooking.setBookingDate(bookingdate);
        System.out.println("6");
        admissionBooking.setStudentName(admissionForm.getStudentName());
        System.out.println("7");
        admissionBooking.setFatherName(admissionForm.getFatherName());
        System.out.println("8");
        admissionBooking.setMotherName(admissionForm.getMotherName());
        System.out.println("9");
        admissionBooking.setSpouseName(admissionForm.getSpouseName());
        System.out.println("10");
        admissionBooking.setNID(admissionForm.getNID());
        System.out.println("11");
        admissionBooking.setContactNo(admissionForm.getContactNo());
        System.out.println("12");
        DateTimeFormatter formatterDob = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DOB = LocalDate.parse(admissionForm.getDOB(), formatterDob);
        admissionBooking.setDOB(DOB);
        System.out.println("13");
        admissionBooking.setPresentAdd(admissionForm.getPresentAdd());
        System.out.println("14");
        admissionBooking.setPermanentAdd(admissionForm.getPermanentAdd());
        System.out.println("15");
        admissionBooking.setAmountToBePaid(admissionForm.getAmountToBePaid());
        System.out.println("16");
        DateTimeFormatter formatterDateToPaid = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DateToPaid = LocalDate.parse(admissionForm.getDateToBePaid(), formatter);
        admissionBooking.setDateToBePaid(DateToPaid);
        System.out.println("17");
        admissionBooking.setAdvAmount(admissionForm.getAdvAmount());
        System.out.println("18");
        admissionBooking.setConfirmFlag(admissionForm.getConfirmFlag());
        admissionBooking.setActiveStatus(admissionForm.getActiveStatus());
       admissionBooking.setCurrencyId(admissionForm.getCurrencyId());
        System.out.println("19");
        admissionBooking.setRemarks(admissionForm.getRemarks());
        System.out.println("20");
        DateTimeFormatter formatterConfirmDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ConfirmDate = LocalDate.parse(admissionForm.getConfirmDate(), formatter);
        admissionBooking.setConfirmDate(ConfirmDate);
        System.out.println("21");


        if (admissionForm.isActive()==true){
            admissionBooking.setActiveStatus(1);
        }else {
            admissionBooking.setActiveStatus(0);
        }

        if (admissionForm.isConfirm()== true){
            admissionBooking.setConfirmFlag(1);
        }else {
            admissionBooking.setConfirmFlag(0);

        }

        return admissionBooking;
    }
    }
