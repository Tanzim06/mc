package com.bz.mc.facade;


import com.bz.mc.facade.data.AuthenticatedUser;
import com.bz.mc.model.hr.Organization;


/**
 * User: rafiq
 * Date: 9/11/19
 * Time: 9:47 AM
 */
public interface SessionManagementService {
   // Office getCurrentOffice();

   Organization getCurrentOrganization();

    AuthenticatedUser getAuthenticatedUser();

    Long getCountryId();
}
