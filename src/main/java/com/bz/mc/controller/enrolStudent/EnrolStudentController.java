package com.bz.mc.controller.enrolStudent;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.session.SessionForm;
import com.bz.mc.controller.studentRegistration.StudentEducationPastForm;
import com.bz.mc.controller.studentRegistration.StudentRegistrationForm;
import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.facade.data.StudentEducationPastData;
import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.setup.SessionInfo;
import com.bz.mc.model.studentRegistration.Gender;
import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import com.bz.mc.service.*;
import com.bz.mc.util.Constants;
import com.bz.mc.validator.SessionFormValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 11:17 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class EnrolStudentController {

    @NonNull private final SessionFormValidator sessionFormValidator;
    @NonNull private final EnrolStudentService enrolStudentService;
    @NonNull private final StudentRegistrationService studentRegistrationService;
    @NonNull private final SessionService sessionService;
    @NonNull private final ProgramService programService;
    @NonNull private final BatchInfoService batchInfoService;
    @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/enrol-student";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_LIST = BASE_ROUTE + "/list";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    private static final String REDIRECT = "redirect:";

    private Long studentRegistrationId;
//    private Long studentRegistrationId;

    @GetMapping(ROUTE_SEARCH)
    public String searchEnrolStudent(Model model) {
        populateEnrolStudentForm(model, new EnrolStudentForm());
//        model.addAttribute("studentRegistrationInfoList", studentRegistrationService.findStudentRegistrationList());
//        model.addAttribute("sessionList", sessionService.findSessionList());
//        model.addAttribute("programList", programService.findPrograms());
        return "/web/pages/enrol-student/search";
    }

//    private void populateModel(Model model, EnrolStudentForm enrolStudentForm)
//    {
//        model.addAttribute("enrolStudentForm", enrolStudentForm);
//    }


    @PostMapping(value =ROUTE_SEARCH_RESULT)
    public String getEnrolStudentList(Model model,
                                      @RequestParam(name = "studentRegistrationId", required = false) Long studentRegistrationId,
                                      @RequestParam(name = "studentName", required = false) String studentName,
                                      @RequestParam(name = "sessionId", required = false) Long sessionId,
                                      @RequestParam(name = "programId", required = false) Long programId
//                                      @RequestParam(name = "batchId", required = false) Long batchId
                                             ){

        System.out.println("student registration Id : is " + studentRegistrationId);
        List<EnrolStudentData> enrolStudentDataList = enrolStudentService.getEnrolStudentSearch(studentRegistrationId, studentName,sessionId,programId);

        model.addAttribute("enrolStudentDataList", enrolStudentDataList);
        System.out.println("enrol List " + enrolStudentDataList.size());
        model.addAttribute("studentRegistrationInfoList", studentRegistrationService.findStudentRegistrationList());
        System.out.println("stu reg List " + studentRegistrationService.findStudentRegistrationList().size());
        model.addAttribute("sessionList", sessionService.findSessionList());
        System.out.println("session List " + sessionService.findSessionList().size());
        model.addAttribute("programList", programService.findPrograms());
//        model.addAttribute("batchInfoList", batchInfoService.getAllActiveBatch());
        if (enrolStudentDataList.size() != 0) {

            return "/web/pages/enrol-student/search";
        }
        return REDIRECT + ROUTE_SEARCH;
    }


    @GetMapping(ROUTE_CREATE)
    public String createStudentRegistration(Model model) {
        this.studentRegistrationId=null;
        populateEnrolStudentForm(model, new EnrolStudentForm());
        return "/web/pages/enrol-student/create";
    }




    private void populateEnrolStudentForm(Model model,EnrolStudentForm enrolStudentForm) {

        model.addAttribute("enrolStudentForm", enrolStudentForm);
        model.addAttribute("studentRegistrationList", enrolStudentForm.getStudentRegistrationForm());
//        model.addAttribute("studentEducationPastForm",studentRegistrationForm.getStudentEducationPastForm());
//        model.addAttribute("educationPastDataList",studentRegistrationForm.getEducationPastForm());
//        model.addAttribute("tabId",studentRegistrationForm.getTabId());
        model.addAttribute("sessionList", sessionService.findSessionList());
//        model.addAttribute("programList", programService.findPrograms());
        System.out.println("List size" + sessionService.findSessionList().size());
        model.addAttribute("genders", Gender.all());
        System.out.println("gender" + Gender.all());
    }


    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdateEnrolStudent(Model model, @ModelAttribute EnrolStudentForm enrolStudentForm, BindingResult result, RedirectAttributes redirectAttributes) {
//        studentRegistrationFormValidator.validate(studentRegistrationForm, result);
        if (result.hasErrors()) {
            populateEnrolStudentForm(model, enrolStudentForm);
            System.out.println("enrol Id " + enrolStudentForm.getId());
            return "/web/pages/enrol-student/create";
        }
      //  EnrolStudentInfo enrolStudentInfo = prepareEnrolStudentInfo(enrolStudentForm);  // stopped by ashraf
        EnrolStudentInfo enrolStudentInfo = new EnrolStudentInfo();    // coded by ashraf for temp
        enrolStudentInfo = enrolStudentService.saveEnrolStudent(enrolStudentInfo);
        System.out.println("enrol info Id " + enrolStudentInfo.getId());
        redirectAttributes.addFlashAttribute("message", "student.registration.info.saved");
        return REDIRECT + webLinkFactory.updateEnrolStudentUrl(enrolStudentInfo);
    }

    private EnrolStudentInfo prepareEnrolStudentInfo(EnrolStudentForm enrolStudentForm) {
        EnrolStudentInfo enrolStudentInfo;
        if (enrolStudentForm.isPersisted()) {
            enrolStudentInfo = enrolStudentService.getEnrolStudentInfo(enrolStudentForm.getId()).get();
        } else {
            enrolStudentInfo = EnrolStudentInfo.builder()
                    .activeStatus(Constants.ACTIVE_STATUS)
                    .build();
        }
        enrolStudentInfo.setEnrolType(enrolStudentForm.getEnrolType());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate enrolDate = LocalDate.parse(enrolStudentForm.getEnrolDate(), formatter);
        enrolStudentInfo.setEnrolDate(enrolDate);
        enrolStudentInfo.setStudentRegistrationId(enrolStudentForm.getStudentRegistrationId());
        enrolStudentInfo.setSessionId(enrolStudentForm.getSessionId());
        enrolStudentInfo.setSectionId(enrolStudentForm.getSectionId());
        enrolStudentInfo.setProgramSegmentId(enrolStudentForm.getProgramSegmentId());
        enrolStudentInfo.setBatchId(enrolStudentForm.getBatchId());
        enrolStudentInfo.setGroupId(enrolStudentForm.getGroupId());
        enrolStudentInfo.setRollNo(enrolStudentForm.getRollNo());
        enrolStudentInfo.setStudentRegistrationId(studentRegistrationId);

        return enrolStudentInfo;
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateEnrolStudent(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        this.studentRegistrationId = id;
        EnrolStudentInfo enrolStudentInfo = enrolStudentService.getEnrolStudent(id);
//        StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(id);
        StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(enrolStudentInfo.getStudentRegistrationId());
        StudentRegistrationInfo studentRegistrationInfoAll = studentRegistrationService.getStudentRegistration(studentRegistrationId);
//        StudentRegistrationForm form=new StudentRegistrationForm(enrolStudentInfo,studentRegistrationInfo,studentRegistrationInfoAll);
//        List<StudentRegistrationInfo> studentRegistrationDataList = studentRegistrationService.findStudentRegistrationList();
//        populateStudentRegistrationFormandEnrolStudent(model,new EnrolStudentForm(studentRegistrationInfo,enrolStudentInfo));
        return "/web/pages/enrol-student/create";

    }

    private EnrolStudentForm studentInfomation(EnrolStudentForm enrolStudentForm){

            if(enrolStudentForm.isPersisted()){

                EnrolStudentInfo enrolStudentInfo=enrolStudentService.getEnrolStudent(enrolStudentForm.getId());
                    enrolStudentInfo.setEnrolType(enrolStudentForm.getEnrolType());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate enrolDate = LocalDate.parse(enrolStudentForm.getEnrolDate(), formatter);
                    enrolStudentInfo.setEnrolDate(enrolDate);
                    enrolStudentInfo.setStudentRegistrationId(enrolStudentForm.getStudentRegistrationId());
                    enrolStudentInfo.setSessionId(enrolStudentForm.getSessionId());
                    enrolStudentInfo.setSectionId(enrolStudentForm.getSectionId());
                    enrolStudentInfo.setProgramSegmentId(enrolStudentForm.getProgramSegmentId());
                    enrolStudentInfo.setBatchId(enrolStudentForm.getBatchId());
                    enrolStudentInfo.setGroupId(enrolStudentForm.getGroupId());
                    enrolStudentInfo.setRollNo(enrolStudentForm.getRollNo());
//                    enrolStudentInfo.setStudentRegistrationId(enrolStudentId);
                    StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(studentRegistrationId);
                }


        else{

            if(enrolStudentForm.isPersisted()){
                EnrolStudentInfo enrolStudentInfo=enrolStudentService.getEnrolStudent(enrolStudentForm.getId());
                if(enrolStudentForm.getStudentRegistrationId()!=null) {
                    StudentRegistrationInfo studentRegistrationInfo =  studentRegistrationService.getStudentRegistration(enrolStudentForm.getStudentRegistrationId());
//                    Samity samity = samityService.getSamity(member.getSamityId());
                    enrolStudentInfo.setEnrolType(enrolStudentForm.getEnrolType());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate enrolDate = LocalDate.parse(enrolStudentForm.getEnrolDate(), formatter);
                    enrolStudentInfo.setEnrolDate(enrolDate);
                    enrolStudentInfo.setStudentRegistrationId(enrolStudentForm.getStudentRegistrationId());
                    enrolStudentInfo.setSessionId(enrolStudentForm.getSessionId());
                    enrolStudentInfo.setSectionId(enrolStudentForm.getSectionId());
                    enrolStudentInfo.setProgramSegmentId(enrolStudentForm.getProgramSegmentId());
                    enrolStudentInfo.setBatchId(enrolStudentForm.getBatchId());
                    enrolStudentInfo.setGroupId(enrolStudentForm.getGroupId());
                    enrolStudentInfo.setRollNo(enrolStudentForm.getRollNo());
                }
            }
        }
       return enrolStudentForm;
    }


    private void populateStudentRegistrationFormandEnrolStudent(Model model,StudentRegistrationForm studentRegistrationForm){

        List<StudentRegistrationInfo> studentRegistrationList = studentRegistrationService.findStudentRegistrationList();
        model.addAttribute("genders", Gender.all());
        EnrolStudentForm form= new EnrolStudentForm();
        form.setStudentRegistrationForm(studentRegistrationForm);
//        form.setTabId(currentTab);
        populateEnrolStudentForm(model,form);

    }

//    private void populateEnrolStudent(Model model, EnrolStudentForm enrolStudentForm) {
//
//        model.addAttribute("studentRegistrationForm", studentRegistrationForm);
//        model.addAttribute("studentEducationPastForm",studentRegistrationForm.getStudentEducationPastForm());
//        model.addAttribute("educationPastDataList",studentRegistrationForm.getEducationPastForm());
//        model.addAttribute("tabId",studentRegistrationForm.getTabId());
//        model.addAttribute("sessionList", sessionService.findSessionList());
//        System.out.println("List size" + sessionService.findSessionList().size());
//        model.addAttribute("genders", Gender.all());
//        System.out.println("gender" + Gender.all());
//    }





//    @GetMapping(ROUTE_CREATE)
//    public String createSession(Model model) {
//        populateModel(model, new SessionForm());
//
//        return "/web/pages/session/create";
//    }
//
//    @GetMapping(ROUTE_UPDATE)
//    public String updateSession(Model model, @PathVariable Long id, SessionForm sessionForm) {
//        SessionInfo sessionInfo = sessionService.getSession(id);
//        populateModel(model, new SessionForm(sessionInfo));
//
//        return "/web/pages/session/create";
//    }
//
//    @GetMapping(ROUTE_LIST)
//    public String getSessionList(Model model) {
//          List<SessionInfo> sessionlist = sessionService.findSessionList();
//          model.addAttribute("sessionlist", sessionlist);
//
//          return "/web/pages/session/list";
//    }
//
//    private void populateModel(Model model, SessionForm sessionForm)
//    {
//        model.addAttribute("sessionForm", sessionForm);
//    }
//
//    @PostMapping(ROUTE_SAVE)
//    public String saveOrUpdatesSession(Model model, @ModelAttribute SessionForm sessionForm, BindingResult result) {
//        sessionFormValidator.validate(sessionForm, result);
//        if (result.hasErrors()) {
//            populateModel(model, sessionForm);
//            return "/web/pages/session/create";
//        }
//        SessionInfo sessionInfo = getSessionInfo(sessionForm);
//        sessionInfo = sessionService.saveSession(sessionInfo);
//
//        return REDIRECT + webLinkFactory.updateSessionUrl(sessionInfo);
//}
//
//    private SessionInfo getSessionInfo(SessionForm sessionForm) {
//        SessionInfo sessionInfo ;
//        if (sessionForm.isPersisted()) {
//            sessionInfo= sessionService.getSessionInfo(sessionForm.getId()).get();
//        } else {
//            sessionInfo = SessionInfo.builder()
//                     .activeStatus(Constants.ACTIVE_STATUS)
//                     .build();
//        }
//        sessionInfo.setSessionName(sessionForm.getSessionName());
//        sessionInfo.setStartDate(sessionForm.getStartDate());
//        sessionInfo.setEndDate(sessionForm.getEndDate());
//        sessionInfo.setRemarks(sessionForm.getRemarks());
//        return sessionInfo;
//
//    }

}
