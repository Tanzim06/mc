package com.bz.mc.controller;

import com.bz.mc.controller.admission.AdmissionController;
import com.bz.mc.controller.charge.ChargeGroupController;
import com.bz.mc.controller.enrolStudent.EnrolStudentController;
import com.bz.mc.controller.item.ItemController;
import com.bz.mc.controller.session.SessionController;
import com.bz.mc.controller.studentRegistration.StudentRegistrationController;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.setup.SessionInfo;
import org.springframework.stereotype.Component;

import com.bz.mc.controller.batch.BatchInfoController;
import com.bz.mc.model.batch.BatchInfo;

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


    public String showBatchUrl(BatchInfo batchInfo) {
        return BatchInfoController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(batchInfo.getId()));
    }


    public String updateBatchUrl(BatchInfo batchInfo) {
        return BatchInfoController.ROUTE_UPDATE.replace(PATH_VAR_ID, String.valueOf(batchInfo.getId()));
    }

    public String updatePriceUrl(Long itemId) {
        return ItemController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(itemId));
    }

    public String updateChargeUrl(Long chargeGroupId) {
        return ChargeGroupController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(chargeGroupId));
    }
//    public String updateChargeItemUrl(Long id) {
//        return ChargeGroupController.ROUTE_EDIT_ITEM.replace(PATH_VAR_ID, String.valueOf(id));
//    }


    public String updateAdmissionUrl(Long id) {
        return AdmissionController.ROUTE_UPDATE.replace(PATH_VAR_ID,String.valueOf(id));
    }

    public String updateSessionUrl(SessionInfo sessionInfo) {
        return SessionController.ROUTE_UPDATE.replace(PATH_VAR_ID, String.valueOf(sessionInfo.getId()));
    }

    public String updateStudentRegistrationUrl(Long studentRegistrationId,int currentTab) {
        return StudentRegistrationController.ROUTE_EDIT.replace(PATH_VAR_ID, String.valueOf(studentRegistrationId)) + "?currentTab=" + currentTab;
    }


    public String updateEnrolStudentUrl(EnrolStudentInfo enrolStudentInfo) {
        return EnrolStudentController.ROUTE_UPDATE.replace(PATH_VAR_ID, String.valueOf(enrolStudentInfo.getId()));
    }
//    public String updateEnrolStudentUrl(EnrolStudentInfo enrolStudentInfo) {
//        return EnrolStudentController.ROUTE_UPDATE.replace(PATH_VAR_ID, String.valueOf(enrolStudentInfo.getId()));
//    }
}
