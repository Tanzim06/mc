package com.bz.mc.controller.session;


import lombok.NonNull;
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
public class SessionController {


    private static final String BASE_ROUTE = "/session";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";



    @GetMapping(ROUTE_CREATE)
    public String createEmployee(Model model) {
        populateModel(model, new SessionForm());
        return "/web/pages/session/session-form";
    }

    private void populateModel(Model model, SessionForm sessionForm) {
        model.addAttribute("sessionForm", sessionForm);
    }

}
