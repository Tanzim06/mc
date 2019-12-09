package com.bz.mc.controller;


import com.bz.mc.model.common.UserStatus;
import com.bz.mc.model.security.User;
import com.bz.mc.service.RoleService;
import com.bz.mc.service.UserService;
import com.bz.mc.validator.UserValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * User: ziaurrahman
 * Date: 2019-11-04
 * Time: 22:18
 */

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class UserController {

    @NonNull private final UserService userService;
    @NonNull private final UserValidator userValidator;
    @NonNull private final RoleService roleService;
    @NonNull private final PasswordEncoder passwordEncoder;
    //@NonNull private final EmployeeServiceFacade employeeServiceFacade;


    private static final String BASE_ROUTE = "/user";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    private static final String ROUTE_LIST = BASE_ROUTE + "/list";
    private static final String ROUTE_EDIT = BASE_ROUTE + "/edit/{id}";
    private static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String ROUTE_DELETE = BASE_ROUTE + "/delete/{id}";
    private static final String REDIRECT = "redirect:";

    private static final int PAGE_SIZE = 5;


    @GetMapping(ROUTE_CREATE)
    public String createUser(Model model) {
        populateModel(model, new User());
        return "/web/pages/user/create";
    }

    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdateUser(@ModelAttribute("user") User user, @RequestParam(required = false) String confirmPassword, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            populateModel(model, user);
            return "/web/pages/user/create";
        }
        if (user.getId() == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userService.saveUser(user);
        return REDIRECT + "/user/list";
    }

    @GetMapping(ROUTE_EDIT)
    public String editUser(Model model, @PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.getRoles().stream().findFirst().ifPresent(role -> model.addAttribute("userRoleId", role.getId()));
        populateModel(model, user);
        return "/web/pages/user/create";
    }

    @GetMapping(ROUTE_DELETE)
    public String deleteUser(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(user);
        return "redirect:/user/list";
    }

    @GetMapping(ROUTE_SHOW)
    public String showUser(Model model, @PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "/web/pages/user/show";
    }

    @GetMapping(ROUTE_LIST)
    public String userList(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(PAGE_SIZE);

        Page<User> userPage = userService.findAllUsers(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("userPage", userPage);

        int totalPages = userPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "/web/pages/user/list";
    }

    @ModelAttribute("user")
    public User loadUser(@RequestParam(name = "userId", required = false) Long userId) {
        User user;
        if (userId == null || userId <= 0) {
            user = new User();
        } else {
            user = userService.findById(userId).orElse(null);
        }
        return user;
    }

    private void populateModel(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("userStatus", UserStatus.values());
        //model.addAttribute("userTypes", UserType.values());
        //model.addAttribute("employees", employeeServiceFacade.findEmployees());
    }
}
