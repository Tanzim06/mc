package com.bz.mc.controller;

import com.bz.mc.controller.session.SessionController;
import com.bz.mc.model.setup.SessionInfo;
import org.springframework.stereotype.Component;

import com.bz.mc.controller.batch.BatchInfoController;
import com.bz.mc.model.batch.BatchInfo;
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


    public String showBatchUrl(BatchInfo batchInfo) {
        return BatchInfoController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(batchInfo.getBatchId()));
    }


    public String updateBatchUrl(BatchInfo batchInfo) {
        return BatchInfoController.ROUTE_UPDATE.replace(PATH_VAR_ID, String.valueOf(batchInfo.getBatchId()));
    }

    public String showSessionUrl(SessionInfo sessionInfo) {
        return SessionController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(sessionInfo.getId()));
    }

}
