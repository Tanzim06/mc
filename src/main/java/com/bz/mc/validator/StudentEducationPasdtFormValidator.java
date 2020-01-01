package com.bz.mc.validator;


import com.bz.mc.controller.studentRegistration.StudentEducationPastForm;
import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.service.StudentEducationPastService;
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
public class StudentEducationPasdtFormValidator implements Validator {

    @NonNull private final StudentEducationPastService studentEducationPastService;
    @NonNull private final SessionManagementService sessionManagementService;

    @Override public boolean supports(Class<?> clazz) {
        return StudentEducationPastForm.class.equals(clazz);
    }

    @Override public void validate(Object target, Errors errors) {
        StudentEducationPastForm studentEducationPastForm = (StudentEducationPastForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "examName", "examName.required","Please Enter Your Exam Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boardName", "boardName.required","Please Enter Your Board Name Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupName", "groupName.required","Please Enter Your Group Name ");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gpa", "gpa.required","Please Enter Your GPA");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marksBiology", "marksBiology.required","Please Enter Your Marks Biology");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearPassed", "yearPassed.required","Please Enter Your Passed Year");


    }
}
