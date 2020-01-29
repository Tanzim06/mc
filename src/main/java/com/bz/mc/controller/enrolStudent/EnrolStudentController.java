package com.bz.mc.controller.enrolStudent;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.studentRegistration.StudentRegistrationForm;
import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.studentRegistration.Gender;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import com.bz.mc.service.*;
import com.bz.mc.util.Constants;
import com.bz.mc.validator.SessionFormValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 11:17 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class EnrolStudentController {

    @NonNull
    private final SessionFormValidator sessionFormValidator;
    @NonNull
    private final EnrolStudentService enrolStudentService;
    @NonNull
    private final StudentRegistrationService studentRegistrationService;
    @NonNull
    private final SessionService sessionService;
    @NonNull
    private final ProgramService programService;
    @NonNull
    private final SegmentInfoService segmentInfoService;
    @NonNull
    private final BatchInfoService batchInfoService;
    @NonNull
    private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/enrol-student";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_LIST = BASE_ROUTE + "/list";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    public static final String ROUTE_NEW_ENROL = BASE_ROUTE + "/createNew/{id}";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SELECT = BASE_ROUTE + "/select{id}";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";

    private static final String REDIRECT = "redirect:";

    private Long studentRegistrationId;
    private Long enrolId;

    @GetMapping(ROUTE_SEARCH)
    public String searchEnrolStudentInit(Model model) {
        List<EnrolStudentData> studentSearchList = new ArrayList<EnrolStudentData>();
        populateSearchResult(model, studentSearchList);
        return "/web/pages/enrol-student/search";
    }


    @PostMapping(ROUTE_SEARCH)
    public String searchEnrolStudentCustom(Model model, EnrolStudentForm enrolStudentForm,
                                           @RequestParam(name = "studentRegistrationId", required = false) Long studentRegistrationId,
                                           @RequestParam(name = "studentName", required = false) String studentName,
                                           @RequestParam(name = "sessionId", required = false) Long sessionId,
                                           @RequestParam(name = "programId", required = false) Long programId,
                                           @RequestParam(name = "programSegmentId", required = false) Long programSegmentId,
                                           @RequestParam(name = "batchId", required = false) Long batchId,
                                           @RequestParam(name = "isNewChk", required = false) boolean isNewChk,
                                           @RequestParam(name = "isEnrolChk", required = false) boolean isEnrolChk) {


        if (isNewChk == true && isEnrolChk == false) {
            List<EnrolStudentData> enrolStudentDataListNew = enrolStudentService.getStudentListForNewEnrol(studentRegistrationId, studentName, sessionId, programId, programSegmentId, batchId);
            populateSearchResult(model, enrolStudentDataListNew);

        } else if (isNewChk == false && isEnrolChk == true) {
            System.out.println("enrol ");
            List<EnrolStudentData> enrolStudentDataList = enrolStudentService.getEnrolStudentSearch(studentRegistrationId, studentName, sessionId, programId, programSegmentId, batchId);
            populateSearchResult(model, enrolStudentDataList);
//            model.addAttribute("studentRegistrationId", studentRegistrationId);
//            model.addAttribute("studentName", studentName);
//            model.addAttribute("sessionId", sessionId);
//            model.addAttribute("programId", programId);
//            model.addAttribute("programSegmentId", programSegmentId);
//            model.addAttribute("batchId", batchId);
//            model.addAttribute("isNewChk", isNewChk);
//            model.addAttribute("isEnrolChk", isEnrolChk);
        } else {
            List<EnrolStudentData> studentSearchList = new ArrayList<EnrolStudentData>();
            populateSearchResult(model, studentSearchList);

        }

        return "/web/pages/enrol-student/search";
    }


    @GetMapping(ROUTE_CREATE)
    public String createStudentRegistration(Model model) {
        this.studentRegistrationId = null;
        populateEnrolStudentForm(model, new EnrolStudentForm());
        System.out.println("enrol ++++ ");
        return "/web/pages/enrol-student/create";
    }

    /*
    created by: ashraf
    date: 8/1/20
    time: 1:07 PM

     */
    private void populateSearchResult(Model model, List<EnrolStudentData> enrolStudentDataList) {
        model.addAttribute("studentSearchList", enrolStudentDataList);
        populateEnrolStudentForm(model, new EnrolStudentForm());
    }

    private void populateEnrolStudentForm(Model model, EnrolStudentForm enrolStudentForm) {

        model.addAttribute("enrolStudentForm", enrolStudentForm);
        model.addAttribute("studentRegistrationList", enrolStudentForm.getStudentRegistrationForm());
        System.out.println("enrol stu Id " + enrolStudentForm.getId());
        System.out.println("stu regi Id " + enrolStudentForm.getStudentRegistrationId());
        model.addAttribute("studentRegistrationInfoList", studentRegistrationService.findStudentRegistrationList());
        System.out.println("stu list" + studentRegistrationService.findStudentRegistrationList().size());
        model.addAttribute("sessionList", sessionService.findSessionList());
        System.out.println("session List size" + sessionService.findSessionList().size());
        model.addAttribute("programList", programService.findPrograms());
        System.out.println("program List " + programService.findPrograms().size());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        System.out.println("segment List " + segmentInfoService.findSegmentList().size());
        model.addAttribute("batchInfoList", batchInfoService.getBatchAllList());
        System.out.println("bacth List " + batchInfoService.getBatchAllList().size());
        model.addAttribute("genders", Gender.all());
        System.out.println("gender" + Gender.all());
    }

    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdateEnrolStudent(Model model, @ModelAttribute EnrolStudentForm enrolStudentForm, BindingResult result, RedirectAttributes redirectAttributes) {
//        studentRegistrationFormValidator.validate(studentRegistrationForm, result);
        if (result.hasErrors()) {
            enrolStudentForm = enrolStudentInfomation(enrolStudentForm, null);
            populateEnrolStudentForm(model, enrolStudentForm);
            System.out.println("enrol Id 66666" + enrolStudentForm.getId());
            return "/web/pages/enrol-student/create";
        }

        System.out.println("student reg id before save form " +enrolStudentForm.getStudentRegistrationId() );
        EnrolStudentInfo enrolStudentInfo = prepareEnrolStudentInfo(enrolStudentForm);
        System.out.println("student reg id before save modal " +enrolStudentInfo.getStudentRegistrationId() );
        enrolStudentInfo = enrolStudentService.saveEnrolStudent(enrolStudentInfo);
        System.out.println("enrol info Id " + enrolStudentInfo.getId());
        redirectAttributes.addFlashAttribute("message", "enrol.student.info.saved");
        return REDIRECT + webLinkFactory.updateEnrolStudentUrl(enrolStudentInfo);
    }

    private EnrolStudentInfo prepareEnrolStudentInfo(EnrolStudentForm enrolStudentForm) {
        EnrolStudentInfo enrolStudentInfo;
        if (enrolStudentForm.isPersisted()) {
            System.out.println("persisted prepare student info");
            enrolStudentInfo = enrolStudentService.getEnrolStudentInfo(enrolStudentForm.getId()).get();
        } else {
            enrolStudentInfo = EnrolStudentInfo.builder()
                    .activeStatus(Constants.ACTIVE_STATUS)
                    .enrolDate(LocalDate.now())
                    .build();
        }
        enrolStudentInfo.setEnrolType(enrolStudentForm.getEnrolType());                           //data set afer save to enroll
        System.out.println("enrol student info set reg id " + enrolStudentForm.getStudentRegistrationId());
        enrolStudentInfo.setStudentRegistrationId(enrolStudentForm.getStudentRegistrationId());
        enrolStudentInfo.setSessionId(enrolStudentForm.getSessionId());
        enrolStudentInfo.setSectionId(enrolStudentForm.getSectionId());
        enrolStudentInfo.setProgramSegmentId(enrolStudentForm.getProgramSegmentId());
        enrolStudentInfo.setBatchId(enrolStudentForm.getBatchId());
        enrolStudentInfo.setGroupId(enrolStudentForm.getGroupId());
        enrolStudentInfo.setRollNo(enrolStudentForm.getRollNo());
        enrolStudentInfo.setRemarks(enrolStudentForm.getRemarks());
        return enrolStudentInfo;
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateEnrolStudent(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        this.enrolId = id;
        System.out.println("enrol id update  " + id);

        if (id != null) {
            System.out.println("Enroll Id 1111");
        } else {
            System.out.println("Enroll Id 2222");
        }

        EnrolStudentInfo enrolStudentInfo = enrolStudentService.getEnrolStudent(id);
        System.out.println("Enroll Id 1111");
        EnrolStudentForm form = new EnrolStudentForm(enrolStudentInfo);
        form = enrolStudentInfomation(form, form.getStudentRegistrationId());
        System.out.println("Enroll Student");
        populateEnrolStudentForm(model, form);

        return "/web/pages/enrol-student/create";

    }


    @GetMapping(ROUTE_NEW_ENROL)
    public String newEnrolStudent(Model model, @PathVariable("id")  Long id, RedirectAttributes redirectAttributes) {
        EnrolStudentInfo enrolStudentInfo = new EnrolStudentInfo();
        // new enrol
        System.out.println("new enrol or registration Id " + id);
        EnrolStudentForm form = new EnrolStudentForm(enrolStudentInfo);
        form = enrolStudentInfomation(form, id);
        populateEnrolStudentForm(model, form);
        System.out.println("populate 11 " + id);

        return "/web/pages/enrol-student/create";

    }

    public EnrolStudentForm enrolStudentInfomation(EnrolStudentForm enrolStudentForm, Long studentRegistrationId) {

        if (!enrolStudentForm.isPersisted()) {

            System.out.println("enrol Id 111  ");
            //for new enrol
            StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(studentRegistrationId);
            enrolStudentForm.setStudentRegistrationId(studentRegistrationId);
            System.out.println("stu Id " + studentRegistrationInfo.getId());
            enrolStudentForm.setStudentName(studentRegistrationInfo.getStudentName());
            System.out.println("stu name " + studentRegistrationInfo.getStudentName());
            enrolStudentForm.setFatherName(studentRegistrationInfo.getFatherName());
            System.out.println("father name " + studentRegistrationInfo.getFatherName());
            enrolStudentForm.setMotherName(studentRegistrationInfo.getMotherName());
            System.out.println("mother name " + studentRegistrationInfo.getMotherName());
            enrolStudentForm.setContactNo(studentRegistrationInfo.getContactNo());
            enrolStudentForm.setPresentAdd(studentRegistrationInfo.getPresentAdd());
            enrolStudentForm.setPresentAddPostcode(studentRegistrationInfo.getPresentAddPostcode());
            enrolStudentForm.setPermanentAdd(studentRegistrationInfo.getPermanentAdd());
            enrolStudentForm.setPermanentAddPostCode(studentRegistrationInfo.getPermanentAddPostCode());
            enrolStudentForm.setBloodGroup(studentRegistrationInfo.getBloodGroup());
            enrolStudentForm.setGender(studentRegistrationInfo.getGender());
            enrolStudentForm.setDoB(studentRegistrationInfo.getDoB());
            enrolStudentForm.setRegistrationDate(studentRegistrationInfo.getRegistrationDate());
            enrolStudentForm.setRegRemarks(studentRegistrationInfo.getRemarks());
            enrolStudentForm.setSessionId(studentRegistrationInfo.getSessionId());
            enrolStudentForm.setProgramId(studentRegistrationInfo.getProgramId());
            enrolStudentForm.setProgramSegmentId(studentRegistrationInfo.getProgramSegmentId());





        } else{ // for enrol                 //data set afer save to student registration
            System.out.println("enrol Id 222 " + enrolStudentForm.getId() + " reg id " + enrolStudentForm.getStudentRegistrationId());
//            EnrolStudentInfo enrolStudentInfo = enrolStudentService.getEnrolStudent(enrolStudentForm.getId());
            StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(enrolStudentForm.getStudentRegistrationId());
            enrolStudentForm.setStudentRegistrationId(studentRegistrationInfo.getId());
            System.out.println("stu Id " + studentRegistrationInfo.getId());
            enrolStudentForm.setStudentName(studentRegistrationInfo.getStudentName());
            System.out.println("stu name " + studentRegistrationInfo.getStudentName());
            enrolStudentForm.setFatherName(studentRegistrationInfo.getFatherName());
            System.out.println("father name " + studentRegistrationInfo.getFatherName());
            enrolStudentForm.setMotherName(studentRegistrationInfo.getMotherName());
            System.out.println("mother name " + studentRegistrationInfo.getMotherName());
            enrolStudentForm.setContactNo(studentRegistrationInfo.getContactNo());
            enrolStudentForm.setPresentAdd(studentRegistrationInfo.getPresentAdd());
            enrolStudentForm.setPresentAddPostcode(studentRegistrationInfo.getPresentAddPostcode());
            enrolStudentForm.setPermanentAdd(studentRegistrationInfo.getPermanentAdd());
            enrolStudentForm.setPermanentAddPostCode(studentRegistrationInfo.getPermanentAddPostCode());
            enrolStudentForm.setBloodGroup(studentRegistrationInfo.getBloodGroup());
            enrolStudentForm.setGender(studentRegistrationInfo.getGender());
            enrolStudentForm.setDoB(studentRegistrationInfo.getDoB());
            enrolStudentForm.setRegistrationDate(studentRegistrationInfo.getRegistrationDate());
            enrolStudentForm.setRegRemarks(studentRegistrationInfo.getRemarks());
            enrolStudentForm.setSessionId(studentRegistrationInfo.getSessionId());
            enrolStudentForm.setProgramId(studentRegistrationInfo.getProgramId());
            enrolStudentForm.setProgramSegmentId(studentRegistrationInfo.getProgramSegmentId());

             // endrol Information
            EnrolStudentInfo enrolStudentInfo = enrolStudentService.getEnrolStudent(enrolStudentForm.getId());
            enrolStudentInfo.setEnrolType(enrolStudentForm.getEnrolType());
            System.out.println("enrol id " + enrolStudentForm.getEnrolType());
            enrolStudentInfo.setEnrolDate(enrolStudentForm.getEnrolDate());
            System.out.println("enrol date " + enrolStudentForm.getEnrolDate());
            enrolStudentInfo.setStudentRegistrationId(enrolStudentForm.getStudentRegistrationId());
            System.out.println("stu Id " + enrolStudentForm.getStudentRegistrationId());
            enrolStudentInfo.setSessionId(enrolStudentForm.getSessionId());
            System.out.println("session " + enrolStudentForm.getSessionId());
            enrolStudentInfo.setSectionId(enrolStudentForm.getSectionId());
            System.out.println("section " + enrolStudentForm.getSectionId());
            enrolStudentInfo.setProgramSegmentId(enrolStudentForm.getProgramSegmentId());
            enrolStudentInfo.setBatchId(enrolStudentForm.getBatchId());
            enrolStudentInfo.setGroupId(enrolStudentForm.getGroupId());
            enrolStudentInfo.setRollNo(enrolStudentForm.getRollNo());
            enrolStudentInfo.setRemarks(enrolStudentForm.getRemarks());
            }
           return enrolStudentForm;
        }


//    @GetMapping(ROUTE_SELECT)
//    public String getSelectingStudentRegistration(Model model, @PathVariable Long id) {
//        EnrolStudentInfo enrolStudentInfo = enrolStudentService.getEnrolStudent(id);
//        populateForm(model, enrolStudentInfo, new EnrolStudentForm(enrolStudentInfo.getId()));
//        return "/web/pages/select-loan/select";
//    }

//    private void populateForm(Model model, EnrolStudentInfo enrolStudentInfo) {
//        model.addAttribute("enrolStudentInfo", enrolStudentInfo);
////        System.out.println("enrol stu Id " + enrolStudentForm.getId());
////        System.out.println("stu regi Id " + enrolStudentForm.getStudentRegistrationId());
////        model.addAttribute("studentRegistrationInfoList", studentRegistrationService.getStudentRegistration(enrolStudentInfo.getStudentRegistrationId()));
////        System.out.println("stu list" + studentRegistrationService.findStudentRegistrationList().size());
////        model.addAttribute("sessionList", sessionService.getSession(enrolStudentInfo.getSessionId()));
////        System.out.println("session List size" + sessionService.findSessionList().size());
////        model.addAttribute("programList", programService.findPrograms());
////        System.out.println("program List " + programService.findPrograms().size());
////        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
////        System.out.println("segment List " + segmentInfoService.findSegmentList().size());
////        model.addAttribute("batchInfoList", batchInfoService.getBatchAllList());
////        System.out.println("bacth List " + batchInfoService.getBatchAllList().size());
////        model.addAttribute("genders", Gender.all());
////        System.out.println("gender" + Gender.all());
////        model.addAttribute("enrolStudentForm", enrolStudentForm);
//    }


    }
