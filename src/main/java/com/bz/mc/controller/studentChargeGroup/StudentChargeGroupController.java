package com.bz.mc.controller.studentChargeGroup;

import com.bz.mc.facade.data.ChargeGroupData;
import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.model.charge.ChargeGroup;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.charge.Origin;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.shedule.StudentChargeGroup;
import com.bz.mc.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    @NonNull private final EnrolStudentService enrolStudentService;
    private static final String BASE_ROUTE = "/student-charge-group";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    private static final String ROUTE_POPULATE_STUDENT_CHARGE = BASE_ROUTE + "/populate-student-charge-list";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    private static final String ROUTE_DETAILS = BASE_ROUTE + "/details/{id}";
    private static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    private static final String REDIRECT = "redirect:";
//    private Long chargeGroupId ;    // will be stopped


    @GetMapping(ROUTE_SEARCH)
    public String searchGroup(Model model) {
        populateStudentGroupChargeForm(model,new StudentChargeGroupForm());
        return "web/pages/schedule/studentGroupCharge";
    }

    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getGroupList(Model model, @RequestParam("sessionId") Long sessionId, @RequestParam("chargeGroupName") String chargeGroupName, @RequestParam("origin") Origin origin, StudentChargeGroupForm studentChargeGroupForm, com.bz.mc.controller.charge.ChargeGroupForm chargeGroupForm) {
        populateStudentGroupChargeForm(model, studentChargeGroupForm);
        List<ChargeGroupData> studentChargeData = chargeItemService.getStudentChargeSearchResult(sessionId,chargeGroupName,origin);
        model.addAttribute("studentChargeDataList", studentChargeData);
        if (studentChargeData.size() != 0) {
            return "web/pages/schedule/studentGroupCharge";
        }
        return REDIRECT + ROUTE_SEARCH;
    }


    @GetMapping(ROUTE_DETAILS)
    public String getStudentChargeDetails(Model model, @PathVariable Long id) {
        System.out.println("chargeGroup 55555");
        ChargeGroup chargeGroup = chargeGroupService.getChargeGroup(id);
        System.out.println("chargeGroup 4444" + chargeGroupService.getChargeGroup(id));
        List<ChargeItem> chargeItemList = chargeGroupService.findChargeItem(chargeGroup);
        ChargeItem chargeItem = chargeItemService.getChagreItemByGroupId(id);
        String itemName=itemService.findItemById(chargeItem.getItemId()).get().getItemName();
        List<ChargeItemForm> chargeItemForms=populatechargeItem(chargeItemList,itemName);
        System.out.println("Item Name" + itemName);
        String sessionName = sessionService.findSessionById(chargeGroup.getSessionId()).get().getSessionName();
        String programName = programService.getProgramById(chargeGroup.getProgramId()).get().getProgramName();
        String segmentName = segmentInfoService.getSegment(chargeGroup.getProgramSegmentId()).getSegmentName();

        System.out.println("charge group Id " + chargeGroup.getId());
        ChargeGroupForm chargeGroupForm = new ChargeGroupForm(chargeGroup,sessionName,programName,segmentName);
        System.out.println("charge group form Id " + chargeGroupForm.getId());
        populateChargeGroup(model,chargeGroupForm,chargeItemForms );

        return "web/pages/schedule/create";
    }

    private void populateChargeGroup(Model model,ChargeGroupForm chargeGroupForm,List<ChargeItemForm> chargeItemForms){
        model.addAttribute("chargeGroupForm", chargeGroupForm);
        System.out.println("chargeGroupForm 222 " + chargeGroupForm.getChargeGroupName());
        model.addAttribute("chargeItemForms", chargeItemForms);
        System.out.println("charge Item Form size " + chargeItemForms.size());
        model.addAttribute("origins", Origin.all());
        System.out.println("origins 777 "+Origin.all());

    }

    private void populateStudentGroupChargeForm (Model model, StudentChargeGroupForm studentChargeGroupForm) {
        model.addAttribute("studentChargeGroupFrom", studentChargeGroupForm);
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        model.addAttribute("itemList", itemService.getAllActiveItem());
        model.addAttribute("origins", Origin.all());

    }

    @PostMapping(ROUTE_POPULATE_STUDENT_CHARGE)
    public String studentChargeGroup(Model model, ChargeGroupForm chargeGroupForm,
                                     @RequestParam(name = "sessionId", required= false) Long sessionId,
                                     @RequestParam(name = "isAllChk", required = false) boolean isAllChk) {
        System.out.println("student List YYYYYY ");
        System.out.println("session id  " + sessionId );
//        List<StudentChargeGroupData> studentChargeGroupList= studentChargeGroupService.getStudentChargeGroupData(sessionId);
        List<EnrolStudentData> enrolStudentDataList=enrolStudentService.getStudentForEnrol(sessionId);
        System.out.println("student List 1111 " + enrolStudentDataList.size());
        model.addAttribute("enrolStudentDataList", enrolStudentDataList );
        model.addAttribute("chargeGroupForm", chargeGroupForm );
        System.out.println("charge group id " + chargeGroupForm.getId());

        ChargeGroup chargeGroup=chargeGroupService.getChargeGroup(chargeGroupForm.getId());            // after click populate button show charge Item List.
        List<ChargeItem> chargeItemList = chargeGroupService.findChargeItem(chargeGroup);
        ChargeItem chargeItem = chargeItemService.getChagreItemByGroupId(chargeGroup.getId());
        String itemName=itemService.findItemById(chargeItem.getItemId()).get().getItemName();
        List<ChargeItemForm> chargeItemForms=populatechargeItem(chargeItemList,itemName);
        model.addAttribute("chargeItemForms",chargeItemForms);

        return "web/pages/schedule/create";
    }


    private List<ChargeItemForm> populatechargeItem(List<ChargeItem> chargeItemList, String itemName){
        List<ChargeItemForm> chargeItemForms = new ArrayList<>();
        chargeItemForms.clear();
        chargeItemList.forEach(chargeItem ->
                chargeItemForms.add(new ChargeItemForm(chargeItem.getId(), itemName ,chargeItem.getItemRate(), chargeItem.getCurrencyId()))
        );
        return chargeItemForms;
    }
   /* @PostMapping(ROUTE_SAVE)
    public String saveChargeGroup(Model model, @ModelAttribute ChargeGroupForm chargeGroupForm, BindingResult result, RedirectAttributes redirectAttributes) {
        System.out.println("out");
        //employeeFormValidator.validate(employeeForm, result);
        if (result.hasErrors()) {
            // System.out.println("testee");
            populateChargeGroup( model,chargeGroupForm,);
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
*/

    @PostMapping(ROUTE_SAVE)
    public String saveStudentGroupCharge(Model model, @ModelAttribute("studentChargeGroupForm") StudentChargeGroupForm studentChargeGroupForm, BindingResult result, RedirectAttributes redirectAttributes) {
        List<EnrolStudentInfo> studentChargeGroups = prepareStudentChargeGroup(studentChargeGroupForm);
        enrolStudentService.saveEnroll(studentChargeGroups);
        redirectAttributes.addFlashAttribute("message", "admin.office.information.saved");
        return REDIRECT+ROUTE_SEARCH;
    }

    private List<EnrolStudentInfo> prepareStudentChargeGroup(StudentChargeGroupForm studentChargeGroupForm){
        System.out.println("student charge group form ");
        List<EnrolStudentInfo> enrolStudentInfoList=enrolStudentService.enrollList(studentChargeGroupForm.getStudentRegistrationId());
        System.out.println("Enrol student List " + enrolStudentInfoList.size());
        System.out.println("student Registration Id " + studentChargeGroupForm.getStudentRegistrationId());
        for (EnrolStudentForm form : studentChargeGroupForm.getEnrolStudentDataList()){
//            OfficeAssign officeHistory=null;
//            if(form.isPersisted()){
//                officeHistory = officeAssignList.stream().filter(history -> Objects.equals(history.getId(), form.getId())).findFirst().orElse(null);
//            }
//
//            if (officeHistory == null) {
//                officeHistory = officeHistory.builder()
//                        .userId(signUpForm.getId())
//                        .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                        .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
//                        .officeId(form.getOfficeId())
//                        .postId(form.getPostId())
//                        .chargeStatus(ChargeStatus.getByChargeName(form.getChargeStatus()))
//                        .build();
//                officeAssignList.add(officeHistory);
//            }
//
//            officeHistory.setActiveStatus(form.isActiveStatus()==true?1:0);
//
        }
        return enrolStudentInfoList;
    }



    }