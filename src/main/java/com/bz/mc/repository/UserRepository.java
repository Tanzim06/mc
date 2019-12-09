package com.bz.mc.repository;

import com.bz.mc.model.security.User;
import com.bz.mc.model.security.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User: ziaurrahman
 * Date: 2019-11-03
 * Time: 23:55
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Page<User> findAllByActiveStatus(Integer activeStatus, Pageable pageable);

    Long countByUsername(String username);
}
