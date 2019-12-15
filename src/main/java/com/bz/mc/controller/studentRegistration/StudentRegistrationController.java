package com.bz.mc.controller.studentRegistration;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 11:17 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class StudentRegistrationController {


    private static final String BASE_ROUTE = "/studentregistration";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SEARCH = BASE_ROUTE + "/search";


    @GetMapping(ROUTE_CREATE)
    public String createEmployee(Model model) {
        populateModel(model, new StudentRegistrationForm());
        return "/web/pages/student-registration/create";
    }

    @GetMapping(ROUTE_SEARCH)
    public String searchStudentReg(Model model) {
        populateModel(model, new StudentRegistrationForm());
        return "/web/pages/student-registration/search";
    }

    private void populateModel(Model model, StudentRegistrationForm studentRegistrationForm) {
        model.addAttribute("studentRegistrationForm", studentRegistrationForm);
    }

}
