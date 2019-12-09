package com.bz.mc.repository;


import com.bz.mc.model.hr.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: rafiq
 * Date: 4/11/19
 * Time: 12:01 AM
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findOrganizationsByCountryIdAndActiveStatusOrderByOrgName(Long countryId, Integer activeStatus);
}
