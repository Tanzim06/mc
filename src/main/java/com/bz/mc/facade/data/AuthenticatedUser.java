package com.bz.mc.facade.data;

import com.bz.mc.model.security.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * User: rafiq
 * Date: 9/11/19
 * Time: 10:49 AM
 */
@Getter
@AllArgsConstructor
public class AuthenticatedUser {
    private Long id;
    private String username;
    private String fullName;
    private Long employeeId;
    private Set<Role> roleSet;

    public boolean isAdmin() {
        return roleSet.stream().anyMatch(role -> StringUtils.equalsIgnoreCase(role.getRole(), "ADMIN"));
    }

    public boolean isUser() {
        return roleSet.stream().anyMatch(role -> StringUtils.equalsIgnoreCase(role.getRole(), "USER"));
    }
}
