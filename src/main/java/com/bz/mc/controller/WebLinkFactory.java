package com.bz.mc.controller;

import com.bz.mc.controller.batch.BatchInfoController;
import com.bz.mc.model.batch.BatchInfo;
import org.springframework.stereotype.Component;

/**
 * User: SHAHIDUL
 * Date: 11/12/19
 * Time: 10:00 PM
 */
@Component
public class WebLinkFactory {

    private static final String PATH_VAR_ID = "{id}";

    public String showBatchUrl(BatchInfo batchInfo) {
        return BatchInfoController.ROUTE_SHOW.replace(PATH_VAR_ID, String.valueOf(batchInfo.getBatchId()));
    }



}
