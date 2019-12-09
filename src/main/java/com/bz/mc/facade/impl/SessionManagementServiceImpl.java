package com.bz.mc.facade.impl;

import com.bz.mc.facade.SessionManagementService;
import com.bz.mc.facade.data.AuthenticatedUser;
import com.bz.mc.model.hr.Organization;
import com.bz.mc.model.security.User;
import com.bz.mc.service.UserService;
import com.bz.mc.service.OrganizationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * User: rafiq
 * Date: 9/11/19
 * Time: 9:49 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionManagementServiceImpl implements SessionManagementService {

    @NonNull private final OrganizationService organizationService;
    @NonNull private final UserService userService;
   // @NonNull private final BasicCenterService basicCenterService;
   // @NonNull private final EmployeeService employeeService;
   // @NonNull private final DivisionService divisionService;
    //@NonNull private final DistrictService districtService;
    //@NonNull private final UpzillaService upzillaService;
   //@NonNull private final UnionService unionService;

   // private Office office;

   // @Override public Office getCurrentOffice() {
       // return office;
    //}

    @Override
    public Organization getCurrentOrganization() {
        return organizationService.getOrganization(1L);
    }

    @Override public AuthenticatedUser getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.findByUsername(currentUserName).orElseThrow(() -> new AccessDeniedException("Authenticated User not found"));
            //Long officeId = 1L;

/*
            if (user.getUserRefId() == null) {
                Employee employee = employeeService.getEmployee(1L);
                officeId = employee.getCurrentOfficeId();
            }


 */
           /* office = basicCenterService.findBasicCenterById(officeId).map(basicCenter -> {         // office assign
                Long divisionId = basicCenter.getDivisionId();
                if (divisionId == null) {
                    divisionId = 1L;
                }
                Long districtId = basicCenter.getDistrictId();
                if (districtId == null) {
                    districtId = 1L;
                }
                Long upzillaId = basicCenter.getUpzillaId();
                if (upzillaId == null) {
                    upzillaId = 1L;
                }
                Long unionId = basicCenter.getUnionId();
                if (unionId == null) {
                    unionId = 1L;
                }





               // Division division = divisionService.findDivisionById(divisionId).orElseGet(()-> divisionService.findDivisionById(1L).orElseThrow(NotFoundException::new));
                //District district = districtService.findDistrictById(districtId).orElseGet(()-> districtService.findDistrictById(1L).orElseThrow(NotFoundException::new));
                //Upzilla upzilla = upzillaService.findUpzillaById(upzillaId).orElseGet(()-> upzillaService.findUpzillaById(1L).orElseThrow(NotFoundException::new));
               // Union union = unionService.findUnionById(unionId).orElseGet(()-> unionService.findUnionById(1L).orElseThrow(NotFoundException::new));

            return Office.builder()
                        .id(basicCenter.getId())
                        .shortCode(basicCenter.getShortCode())
                        .officeName(basicCenter.getBasicCenterName())
                        .officeType(OfficeType.CENTER)
                        .division(division)
                        .district(district)
                        .upzilla(upzilla)
                        .union(union)
                        .build();
            }).orElse(Office.builder()
                    .id(1L)
                    .shortCode("C001")
                    .officeName("Basic Center 1")
                    .officeType(OfficeType.CENTER)
                    .division(divisionService.findDivisionById(1L).orElseThrow(NotFoundException::new))
                    .district(districtService.findDistrictById(1L).orElseThrow(NotFoundException::new))
                    .upzilla(upzillaService.findUpzillaById(1L).orElseThrow(NotFoundException::new))
                    .union(unionService.findUnionById(1L).orElseThrow(NotFoundException::new))
                    .build());
                    */                // end of office assign


            return new AuthenticatedUser(user.getId(), user.getUsername(), user.getFullName(), 1L, user.getRoles());
        }
        throw new AccessDeniedException("Authenticated User not found");
    }

    @Override public Long getCountryId() {
        return 1L;
    }
}
