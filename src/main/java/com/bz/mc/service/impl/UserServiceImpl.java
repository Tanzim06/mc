package com.bz.mc.service.impl;


import com.bz.mc.model.security.User;
import com.bz.mc.repository.UserRepository;
import com.bz.mc.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * User: ziaurrahman
 * Date: 2019-11-04
 * Time: 22:24
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    @NonNull private final UserRepository userRepository;


    @Override public Page<User> findUsers(Integer activeStatus, Pageable pageable) {
        return userRepository.findAllByActiveStatus(activeStatus, pageable);
    }

    @Override public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override public boolean isUsernameExists(String username) {
        return userRepository.countByUsername(username) > 0;
    }
}
