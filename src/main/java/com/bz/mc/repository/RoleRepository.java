package com.bz.mc.repository;

import com.bz.mc.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: ziaurrahman
 * Date: 2019-11-09
 * Time: 14:41
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
