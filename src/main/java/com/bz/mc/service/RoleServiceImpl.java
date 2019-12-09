package com.bz.mc.service;

import com.bz.mc.model.security.Role;
import com.bz.mc.repository.RoleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ziaurrahman
 * Date: 2019-11-09
 * Time: 14:37
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RoleServiceImpl implements RoleService {
    @NonNull private final RoleRepository roleRepository;

    @Override public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
