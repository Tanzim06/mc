package com.bz.mc.controller;

<<<<<<< HEAD
import com.bz.mc.controller.session.SessionController;
import com.bz.mc.model.setup.SessionInfo;
import org.springframework.stereotype.Component;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 12:22 PM
=======
import com.bz.mc.controller.batch.BatchInfoController;
import com.bz.mc.model.batch.BatchInfo;
import org.springframework.stereotype.Component;

/**
 * User: SHAHIDUL
 * Date: 11/12/19
 * Time: 10:00 PM
>>>>>>> origin/master
 */
@Component
public class WebLinkFactory {

    private static final String PATH_VAR_ID = "{id}";

<<<<<<< HEAD
//    public String editLoanApplicationUrl(Long loanApplicationId) {
//        return LoanApplicationController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(loanApplicationId));
//    }
//
//    public String editLoanApplicationUrl(Long loanApplicationId, int currentTab) {
//        return LoanApplicationController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(loanApplicationId)) + "?currentTab=" + currentTab;
//    }
//
//    public String showEmployeeUrl(Employee employee) {
//        return EmployeeController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(employee.getId()));
//    }
//
//    public String listEmployeeUrl() {
//        return EmployeeController.ROUTE_LIST;
//    }
//
//    public String editSamityUrl(Long samityId,int currentTab) {
//        return SamityController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(samityId)) + "?currentTab=" + currentTab;
//    }
//   /* public String editSamityMember(SamityMember samityMember) {
//        return SamityMemberController.ROUTE_EDIT.replace("{id}", String.valueOf(samityMember.getId()));
//    } */
//
//    public String editOldSamityUrl(Long samityId,int currentTab) {
//        return SamityOldController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(samityId)) + "?currentTab=" + currentTab;
//    }

    public String showSessionUrl(SessionInfo sessionInfo) {
       return SessionController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(sessionInfo.getSessionId()));
   }
=======
    public String showBatchUrl(BatchInfo batchInfo) {
        return BatchInfoController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(batchInfo.getBatchId()));
    }


>>>>>>> origin/master

}
