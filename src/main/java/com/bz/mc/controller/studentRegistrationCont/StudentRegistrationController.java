package com.bz.mc.controller.studentRegistrationCont;


import com.bz.mc.controller.session.SessionForm;
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



    @GetMapping(ROUTE_CREATE)
    public String createEmployee(Model model) {
        populateModel(model, new StudentRegistrationForm());
        return "/web/pages/student-registration/create";
    }

    private void populateModel(Model model, StudentRegistrationForm studentRegistrationForm) {
        model.addAttribute("studentRegistrationForm", studentRegistrationForm);
    }

}
