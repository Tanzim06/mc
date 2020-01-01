package com.bz.mc.controller.session;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.model.setup.SessionInfo;
import com.bz.mc.service.SessionService;
import com.bz.mc.util.Constants;
import com.bz.mc.validator.SessionFormValidator;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 11:17 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class SessionController {

    @NonNull private final SessionFormValidator sessionFormValidator;
    @NonNull private final SessionService sessionService;
    @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/session";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_LIST = BASE_ROUTE + "/list";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/update/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE)
    public String createSession(Model model) {
        populateModel(model, new SessionForm());

        return "/web/pages/session/create";
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateSession(Model model, @PathVariable Long id, SessionForm sessionForm) {
        SessionInfo sessionInfo = sessionService.getSession(id);
        populateModel(model, new SessionForm(sessionInfo));

        return "/web/pages/session/create";
    }

    @GetMapping(ROUTE_LIST)
    public String getSessionList(Model model) {
          List<SessionInfo> sessionlist = sessionService.findSessionList();
          model.addAttribute("sessionlist", sessionlist);

          return "/web/pages/session/list";
    }

    private void populateModel(Model model, SessionForm sessionForm) {
        model.addAttribute("sessionForm", sessionForm);
    }

    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdatesSession(Model model, @ModelAttribute SessionForm sessionForm, BindingResult result) {
        sessionFormValidator.validate(sessionForm, result);
        if (result.hasErrors()) {
            populateModel(model, sessionForm);
            return "/web/pages/session/create";
        }
        SessionInfo sessionInfo = getSessionInfo(sessionForm);
        sessionInfo = sessionService.saveSession(sessionInfo);

        return REDIRECT + webLinkFactory.updateSessionUrl(sessionInfo);
}

    private SessionInfo getSessionInfo(SessionForm sessionForm) {
        SessionInfo sessionInfo ;
        if (sessionForm.isPersisted()) {
            sessionInfo= sessionService.getSessionInfo(sessionForm.getId()).get();
        } else {
            sessionInfo = SessionInfo.builder()
                     .activeStatus(Constants.ACTIVE_STATUS)
                     .build();
        }
        sessionInfo.setSessionName(sessionForm.getSessionName());
//        sessionInfo.setStartDate(sessionForm.getStartDate());
//        sessionInfo.setEndDate(sessionForm.getEndDate());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(sessionForm.getStartDate(), formatter);
        sessionInfo.setStartDate(startDate);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(sessionForm.getEndDate(), formatters);
        sessionInfo.setEndDate(endDate);

        sessionInfo.setRemarks(sessionForm.getRemarks());
        return sessionInfo;

    }

}
