package com.bz.mc.validator;

import com.bz.mc.controller.session.SessionForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.service.SessionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:57 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class SessionFormValidator implements Validator {

    @NonNull private final SessionService sessionService;
    @NonNull private final SessionManagementService sessionManagementService;

    @Override public boolean supports(Class<?> clazz) {return SessionForm.class.equals(clazz);}

    @Override public void validate(Object target, Errors errors) {
        SessionForm sessionForm = (SessionForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sessionName", "sessionName.required","Please input Session Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.required","Please input Start Date");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "endDate.required","Please input EndDate");

     }
}
