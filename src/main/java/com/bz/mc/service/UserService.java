package com.bz.mc.service;


import com.bz.mc.model.security.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * User: ziaurrahman
 * Date: 2019-11-04
 * Time: 22:20
 */
public interface UserService {
    Page<User> findUsers(Integer activeStatus, Pageable pageable);

    Page<User> findAllUsers(Pageable pageable);

    Optional<User> findById(Long id);

    User saveUser(User user);

    void deleteUser(User user);

    Optional<User> findByUsername(String username);

    boolean isUsernameExists(String username);
}
