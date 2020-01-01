package com.bz.mc.validator;


import com.bz.mc.controller.studentRegistration.StudentRegistrationForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.service.StudentRegistrationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * User: moly
 * Date: 2019-12-24
 * Time: 10:48
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class StudentRegistrationFormValidator implements Validator {

    @NonNull private final StudentRegistrationService studentRegistrationService;
    @NonNull private final SessionManagementService sessionManagementService;

    @Override public boolean supports(Class<?> clazz) {
        return StudentRegistrationForm.class.equals(clazz);
    }

    @Override public void validate(Object target, Errors errors) {
        StudentRegistrationForm studentRegistrationForm = (StudentRegistrationForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName", "studentName.required","Please input Student Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherName", "fatherName.required","Please input Father Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motherName", "motherName.required","Please input Mother Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doB", "doB.required","Please Enter Date of Birth");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationDate", "registrationDate.required","Please Enter Registration Date");


    }
}
