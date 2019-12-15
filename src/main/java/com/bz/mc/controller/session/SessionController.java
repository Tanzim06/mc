package com.bz.mc.controller.session;


import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.controller.batch.BatchInfoForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.model.setup.QSessionInfo;
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
import org.springframework.web.bind.annotation.PostMapping;

import static com.bz.mc.model.batch.QBatchInfo.batchInfo;

/**
 * User: Moly
 * Date: 10/12/19
 * Time: 11:17 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class SessionController {

    @NonNull private final SessionFormValidator sessionFormValidator;
    @NonNull private final SessionService  sessionService;
    @NonNull private final SessionManagementService sessionManagementService;
    @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/session";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_LIST = BASE_ROUTE + "/list";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE)
    public String createSession(Model model) {
        populateModel(model, new SessionForm());
        return "/web/pages/session/create";
    }

    @GetMapping(ROUTE_LIST)
    public String createSessionList(Model model) {
        populateModel(model, new SessionForm());
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

        return REDIRECT + webLinkFactory.showSessionUrl(sessionInfo);

    }



    private SessionInfo getSessionInfo(SessionForm sessionForm) {
            SessionInfo sessionInfo ;
        if (sessionForm.isPersisted()) {
            sessionInfo= sessionService.getSessionInfo(sessionForm.getSessionId());
        } else {
            sessionInfo = SessionInfo.builder()

//                    .orgId(sessionManagementService.getCurrentOrganization().getId())
                    .activeStatus(Constants.ACTIVE_STATUS)
//                    .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                    .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
                    .build();
        }

        sessionInfo.setSessionId(sessionForm.getSessionId());
        sessionInfo.setSessionName(sessionForm.getSessionName());
        sessionInfo.setStartDate(sessionForm.getStartDate());
        sessionInfo.setEndDate(sessionForm.getEndDate());
        sessionInfo.setRemarks(sessionForm.getRemarks());
        return sessionInfo;

    }


}
