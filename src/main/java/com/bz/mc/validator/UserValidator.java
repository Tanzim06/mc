package com.bz.mc.validator;


import com.bz.mc.model.security.User;
import com.bz.mc.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * User: ziaurrahman
 * Date: 2019-11-08
 * Time: 00:05
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

@Component
public class UserValidator implements Validator {
    @NonNull private final UserService userService;

    @Override public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override public void validate(Object target, Errors errors) {

        User user = (User) target;
        if (user != null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName.required", "Name required default");
            ValidationUtils.rejectIfEmpty(errors, "userType", "userType.required", "Please select an user type");
            ValidationUtils.rejectIfEmpty(errors, "userStatus", "userStatus.required", "Please select a status");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required", "Please input username");
            if (!user.isPersisted()) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Please input password");
            }

//            if (user.getUserType() == UserType.EMPLOYEE) {
//                ValidationUtils.rejectIfEmpty(errors, "userRefId", "userRefId.required", "Please select an employee");
//            }

            if (userService.isUsernameExists(user.getUsername())) {
                errors.rejectValue("username", "username.already.exist", "This username is already taken");

            }
        }
    }
}
