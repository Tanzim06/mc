package com.bz.mc.service;


import com.bz.mc.model.hr.Organization;

import java.util.List;
import java.util.Optional;

/**
 * User: rafiq
 * Date: 4/11/19
 * Time: 12:32 AM
 */
public interface OrganizationService {
    List<Organization> findOrganizations(Long countryId);

    Optional<Organization> findOrganizationById(Long orgId);

    Organization getOrganization(Long orgId);
}
