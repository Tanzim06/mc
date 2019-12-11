package com.bz.mc.controller.batch;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.service.BatchInfoService;
import com.bz.mc.service.ProgramService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: SHAHIDUL
 * Date: 10/12/19
 * Time: 10:27 PM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class BatchInfoController {

    @NonNull
    private final BatchInfoService batchInfoService;
    private final ProgramService programService;

    @NonNull private final WebLinkFactory webLinkFactory;

    private static final String BASE_ROUTE = "/batch";
    private static final String ROUTE_CREATE = BASE_ROUTE + "/create";
    private static final String ROUTE_SAVE = BASE_ROUTE + "/save";
    public static final String ROUTE_LIST = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    private static final String REDIRECT = "redirect:";

    @GetMapping(ROUTE_CREATE )
    public String batchInfo(Model model) {
        populateModel(model, new BatchInfoForm());
        return "/web/pages/batch/create";
    }

    @PostMapping(ROUTE_SAVE)
    public String saveOrUpdateBatch(Model model, @ModelAttribute BatchInfoForm batchInfoForm, BindingResult result) {
        //employeeFormValidator.validate(employeeForm, result);
        if (result.hasErrors()) {
            populateModel(model, batchInfoForm);
            return "/web/pages/batch/create";
        }

        BatchInfo batchInfo =getBatchInfo(batchInfoForm);

        batchInfo = batchInfoService.saveBatchInfo(batchInfo);


        //return "/web/pages/batch/create";
        return REDIRECT+ webLinkFactory.showBatchUrl(batchInfo);
    }



    @GetMapping(ROUTE_LIST)
    public String batchList(Model model) {
        populateModel(model, new BatchInfoForm());

        return "/web/pages/batch/list";
    }




    private void populateModel(Model model, BatchInfoForm batchInfoForm) {
       // model.addAttribute("sessions", designationService.findDesignations());
        model.addAttribute("programs", programService.findPrograms());
        model.addAttribute("batchInfoForm", batchInfoForm);


    }



    private BatchInfo getBatchInfo(BatchInfoForm batchInfoForm ) {

          BatchInfo batchInfo ;
       if (batchInfoForm.isPersisted()) {
          batchInfo = batchInfoService.getBatchInfo(batchInfoForm.getBatchId());
      }        else {
          batchInfo = BatchInfo.builder().build();
                  //.orgId(sessionManagementService.getCurrentOrganization().getId())
        //          .activeStatus(Constants.ACTIVE_STATUS)
//                  .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .build();
       }

        batchInfo.setBatchId(batchInfoForm.getBatchId());
        batchInfo.setBatchName(batchInfoForm.getBatchName());
        batchInfo.setVisualId(batchInfoForm.getVisualId());
        batchInfo.setShortCode(batchInfoForm.getShortCode());
        batchInfo.setSessionId(batchInfoForm.getSessionId());
        batchInfo.setProgramId(batchInfoForm.getProgramId());
        batchInfo.setRemarks(batchInfoForm.getRemarks());


     return batchInfo;

    }



}
