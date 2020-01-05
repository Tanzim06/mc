package com.bz.mc.controller.studentRegistration;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.facade.data.StudentEducationPastData;
import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.setup.ProgramSegment;
import com.bz.mc.model.studentRegistration.Gender;
import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import com.bz.mc.service.*;
import com.bz.mc.util.Constants;
import com.bz.mc.validator.StudentEducationPasdtFormValidator;
import com.bz.mc.validator.StudentRegistrationFormValidator;
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
public class StudentRegistrationController {

    @NonNull private final StudentRegistrationFormValidator studentRegistrationFormValidator;
    @NonNull private final StudentEducationPasdtFormValidator studentEducationPasdtFormValidator;
    @NonNull private final StudentRegistrationService studentRegistrationService;
    @NonNull private final ProgramService programService;
    @NonNull private final SegmentInfoService segmentInfoService;
    @NonNull private final StudentEducationPastService studentEducationPastService;
    @NonNull private final SessionService sessionService;
    @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/student-registration";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    public static final String ROUTE_EDIT = BASE_ROUTE + "/edit/{id}";
    private static final String ROUTE_SAVE_STUDENT_INFORMATION = BASE_ROUTE + "/save-student-informatoin";
    private static final String ROUTE_SAVE_STUDENT_EDUCATION = BASE_ROUTE + "/save-student-education";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/student-education/update/{id}";

    private static final String REDIRECT = "redirect:";

    private Long studentRegistrationId;

    @GetMapping(ROUTE_CREATE)
    public String createStudentRegistration(Model model) {
        this.studentRegistrationId=null;
        populateStudentRegistrationForm(model, new StudentRegistrationForm());
        return "/web/pages/student-registration/create";
    }

    @GetMapping(ROUTE_SEARCH)
    public String searchStudentRegistration(Model model) {
//        populateModel(model, new StudentRegistrationForm());
//        model.addAttribute("studentRegistrationInfoList", studentRegistrationInfoList);
         model.addAttribute("sessionList", sessionService.findSessionList());
        return "/web/pages/student-registration/search";
    }



    @GetMapping(ROUTE_EDIT)
    public String updateStudentRegistration(Model model, @PathVariable Long id, StudentRegistrationForm studentRegistrationForm ,@RequestParam(required = false, defaultValue = "1") int currentTab) {
        this.studentRegistrationId = id;
        StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(id);
        StudentEducationPastForm studentEducationPastForm=new StudentEducationPastForm();
        populateOtherTabData(model,studentRegistrationInfo,studentEducationPastForm,currentTab);
        model.addAttribute("sessionList", sessionService.findSessionList());
        return "/web/pages/student-registration/create";
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateStudentEducation(Model model, @PathVariable Long id,RedirectAttributes redirectAttributes) {
        StudentEducationPastInfo studentEducationPastInfo = studentEducationPastService.getStudentEducationPast(id);
        StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(studentEducationPastInfo.getStudentRegistrationId());
        StudentEducationPastForm form=new StudentEducationPastForm(studentEducationPastInfo);
        populateOtherTabData(model,studentRegistrationInfo,form,2);
        return "/web/pages/student-registration/create";
    }

    @PostMapping(ROUTE_SAVE_STUDENT_INFORMATION)
    public String saveOrUpdateStudentRegistration(Model model, @ModelAttribute StudentRegistrationForm studentRegistrationForm,BindingResult result,RedirectAttributes redirectAttributes) {
        studentRegistrationFormValidator.validate(studentRegistrationForm, result);
        if (result.hasErrors()) {
            studentRegistrationForm.setTabId(1);
            populateStudentRegistrationForm(model, studentRegistrationForm);
            System.out.println("gender11 " + Gender.FEMALE);
            return "/web/pages/student-registration/create";
        }
        StudentRegistrationInfo studentRegistrationInfo = prepareStudentRegistrationInfo(studentRegistrationForm);
        studentRegistrationInfo = studentRegistrationService.saveStudentRegistration(studentRegistrationInfo);
        redirectAttributes.addFlashAttribute("message", "student.registration.info.saved");
        System.out.println("gender12 " + Gender.MALE);
        return REDIRECT + webLinkFactory.updateStudentRegistrationUrl(studentRegistrationInfo.getId(),2);
    }

    private StudentRegistrationInfo prepareStudentRegistrationInfo(StudentRegistrationForm studentRegistrationForm) {
        StudentRegistrationInfo studentRegistrationInfo;
        if (studentRegistrationForm.isPersisted()) {
            studentRegistrationInfo = studentRegistrationService.getStudentRegistrationInfo(studentRegistrationForm.getId()).get();
        } else {
            studentRegistrationInfo = StudentRegistrationInfo.builder()
                    .activeStatus(Constants.ACTIVE_STATUS)
                    .build();
        }
        studentRegistrationInfo.setStudentName(studentRegistrationForm.getStudentName());
        studentRegistrationInfo.setFatherName(studentRegistrationForm.getFatherName());
        studentRegistrationInfo.setMotherName(studentRegistrationForm.getMotherName());
        studentRegistrationInfo.setContactNo(studentRegistrationForm.getContactNo());
        studentRegistrationInfo.setPresentAdd(studentRegistrationForm.getPresentAdd());
        studentRegistrationInfo.setPresentAddPostcode(studentRegistrationForm.getPresentAddPostcode());
        studentRegistrationInfo.setPermanentAdd(studentRegistrationForm.getPermanentAdd());
        studentRegistrationInfo.setPermanentAddPostCode(studentRegistrationForm.getPermanentAddPostCode());
        studentRegistrationInfo.setPicture(studentRegistrationForm.getPicture());
        studentRegistrationInfo.setPicturePath(studentRegistrationForm.getPicturePath());
        studentRegistrationInfo.setBloodGroup(studentRegistrationForm.getBloodGroup());
        studentRegistrationInfo.setGender(studentRegistrationForm.getGender());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(studentRegistrationForm.getDoB(), formatter);
        studentRegistrationInfo.setDoB(dateOfBirth);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate regDate = LocalDate.parse(studentRegistrationForm.getRegistrationDate(), formatters);
        studentRegistrationInfo.setRegistrationDate(regDate);

        //       studentRegistrationInfo.setDoB(studentRegistrationForm.getDoB());
//        studentRegistrationInfo.setRegistrationDate(studentRegistrationForm.getRegistrationDate());
        studentRegistrationInfo.setRemarks(studentRegistrationForm.getRemarks());
        studentRegistrationInfo.setVisualId(studentRegistrationForm.getVisualId());
        studentRegistrationInfo.setSessionId(studentRegistrationForm.getSessionId());
        studentRegistrationInfo.setProgramId(studentRegistrationForm.getProgramId());

        return studentRegistrationInfo;
    }

    @PostMapping(value =ROUTE_SEARCH_RESULT)
    public String getStudentRegistrationList(Model model,
                                             @RequestParam(name = "sessionId", required = false) Long sessionId,
                                             @RequestParam(name = "id", required = false) Long id,
                                             @RequestParam("studentName") String studentName,
                                             @RequestParam("fatherName") String fatherName,
                                             @RequestParam("motherName") String motherName,
                                             @RequestParam("contactNo") String contactNo,
                                             @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam("doB")Date doB,
                                             @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam("registrationDate")Date registrationDate
    ){
         System.out.println("date of birth : is " + doB);

        List<StudentRegistrationData> studentRegistrationDataList = studentRegistrationService.getStudentRegistrationSearch(sessionId,id, studentName,fatherName,motherName,contactNo ,doB,registrationDate);

        for(StudentRegistrationData stu : studentRegistrationDataList){
            System.out.println("date of birth "+ stu.getDoB());
        }

        model.addAttribute("studentRegistrationDataList", studentRegistrationDataList);
        model.addAttribute("sessionList", sessionService.findSessionList());
        if (studentRegistrationDataList.size() != 0) {

            return "/web/pages/student-registration/search";
        }
        return REDIRECT + ROUTE_SEARCH;
    }


    private void populateStudentRegistrationForm(Model model, StudentRegistrationForm studentRegistrationForm) {

        model.addAttribute("studentRegistrationForm", studentRegistrationForm);
        model.addAttribute("studentEducationPastForm",studentRegistrationForm.getStudentEducationPastForm());
        model.addAttribute("educationPastDataList",studentRegistrationForm.getEducationPastForm());
        model.addAttribute("tabId",studentRegistrationForm.getTabId());
        model.addAttribute("sessionList", sessionService.findSessionList());
        model.addAttribute("programList", programService.findPrograms());
        model.addAttribute("segmentList", segmentInfoService.findSegmentList());
        System.out.println("List size" + sessionService.findSessionList().size());
        model.addAttribute("genders", Gender.all());
        System.out.println("gender" + Gender.all());
    }

    @PostMapping(ROUTE_SAVE_STUDENT_EDUCATION)
    public String saveSamityMember(Model model, @ModelAttribute StudentEducationPastForm studentEducationPastForm, BindingResult result, RedirectAttributes redirectAttributes) {
        studentEducationPasdtFormValidator.validate(studentEducationPastForm, result);
        if (studentRegistrationId != null) {
            if (result.hasErrors()) {
                StudentRegistrationInfo studentRegistrationInfo = studentRegistrationService.getStudentRegistration(studentRegistrationId);
//               List<StudentEducationPastInfo>educationPastDataListList = studentEducationPastService.findStudentEducationPast(studentRegistrationId);
                List<StudentEducationPastData>educationPastDataList = studentEducationPastService.findStudentEducationPast(studentRegistrationId);
                System.out.println("eduList" + educationPastDataList.size());
                StudentRegistrationForm form = new StudentRegistrationForm(studentRegistrationInfo,educationPastDataList);
                form.setStudentEducationPastForm(studentEducationPastForm);
                form.setTabId(2);
                populateStudentRegistrationForm(model, form);


                return "/web/pages/student-registration/create";
            } else {
                StudentEducationPastInfo studentEducationPastInfo = prepareStudentEducationPast (studentEducationPastForm);
                studentEducationPastInfo = studentEducationPastService.saveStudentEducationPast(studentEducationPastInfo);

                model.addAttribute("educationPastDataList",studentEducationPastService.findStudentEducationPast(studentRegistrationId));
                redirectAttributes.addFlashAttribute("message", "student.education.past.info.saved");
                return REDIRECT + webLinkFactory.updateStudentRegistrationUrl(studentRegistrationId,2);
            }
        }
        redirectAttributes.addFlashAttribute("message", "student.education.past.empty.saved");
        return REDIRECT + ROUTE_CREATE;
    }

        private StudentEducationPastInfo prepareStudentEducationPast (StudentEducationPastForm studentEducationPastForm) {
            StudentEducationPastInfo studentEducationPastInfo;
            if (studentEducationPastForm.isPersisted()) {
                studentEducationPastInfo = studentEducationPastService.getStudentEducationPast(studentEducationPastForm.getId());
            } else {
                studentEducationPastInfo = StudentEducationPastInfo.builder()
                        .activeStatus(Constants.ACTIVE_STATUS)
//                        .createdBy(sessionManagementService.getAuthenticatedUser().getId())
                        .build();
            }
                studentEducationPastInfo.setExamName(studentEducationPastForm.getExamName());

                studentEducationPastInfo.setBoardName(studentEducationPastForm.getBoardName());
                studentEducationPastInfo.setGroupName(studentEducationPastForm.getGroupName());
                studentEducationPastInfo.setGpa(studentEducationPastForm.getGpa());
                studentEducationPastInfo.setRegNo(studentEducationPastForm.getRegNo());
                studentEducationPastInfo.setRollNo(studentEducationPastForm.getRollNo());
                studentEducationPastInfo.setMarksBiology(studentEducationPastForm.getMarksBiology());
                studentEducationPastInfo.setStudentRegistrationId(studentEducationPastForm.getStudentRegistrationId());
                studentEducationPastInfo.setYearPassed(studentEducationPastForm.getYearPassed());
                studentEducationPastInfo.setStudentRegistrationId(studentRegistrationId);

                 return studentEducationPastInfo;
            }


    private void populateOtherTabData(Model model, StudentRegistrationInfo studentRegistrationInfo, StudentEducationPastForm studentEducationPastForm, int currentTab){

        List<StudentEducationPastData>educationPastDataList = studentEducationPastService.findStudentEducationPast(studentRegistrationId);
        model.addAttribute("genders", Gender.all());
        StudentRegistrationForm form= new StudentRegistrationForm(studentRegistrationInfo,educationPastDataList);
        form.setStudentEducationPastForm(studentEducationPastForm);
        form.setTabId(currentTab);
        populateStudentRegistrationForm(model,form);

    }


}