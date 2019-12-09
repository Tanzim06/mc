package com.bz.mc.service;


import com.bz.mc.model.security.CustomUserDetails;
import com.bz.mc.model.security.User;
import com.bz.mc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: ziaurrahman
 * Date: 2019-11-04
 * Time: 00:09
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new CustomUserDetails(user);
    }
}
