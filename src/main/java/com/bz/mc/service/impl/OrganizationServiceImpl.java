package com.bz.mc.service.impl;


import com.bz.mc.exception.OrganizationNotFoundException;
import com.bz.mc.model.hr.Organization;
import com.bz.mc.repository.OrganizationRepository;
import com.bz.mc.service.OrganizationService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User: rafiq
 * Date: 4/11/19
 * Time: 12:33 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @NonNull private final OrganizationRepository organizationRepository;

    @Override public List<Organization> findOrganizations(Long countryId) {
        return organizationRepository.findOrganizationsByCountryIdAndActiveStatusOrderByOrgName(countryId, Constants.ACTIVE_STATUS);
    }

    @Override public Optional<Organization> findOrganizationById(Long orgId) {
        return organizationRepository.findById(orgId);
    }

    @Override public Organization getOrganization(Long orgId) {
        return findOrganizationById(orgId).orElseThrow(OrganizationNotFoundException::new);
    }
}
