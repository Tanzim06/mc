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
import org.springframework.web.bind.annotation.*;

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
        System.out.println("out");
        //employeeFormValidator.validate(employeeForm, result);
        if (result.hasErrors()) {
            System.out.println("testee");
            populateModel(model, batchInfoForm);
            return "/web/pages/batch/create";
        }
        System.out.println("test");
        BatchInfo batchInfo =getBatchInfo(batchInfoForm);
        System.out.println("testyyy");
        System.out.println("batch_id " + batchInfo.getBatchId());
        batchInfo = batchInfoService.saveBatchInfo(batchInfo);

        System.out.println("test1");
        //return "/web/pages/batch/create";
        return REDIRECT+ webLinkFactory.showBatchUrl(batchInfo);
    }



    @GetMapping(ROUTE_SHOW)
    public String showEmployee(Model model, @PathVariable Long batchId) {

        BatchInfo batchInfo = batchInfoService.getBatchInfo(batchId).get();

        populateShowPageModel(model, batchInfo);

        return "/web/pages/batch/show";
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
           System.out.println("0");

          batchInfo = batchInfoService.getBatchInfo(batchInfoForm.getBatchId()).get();
           System.out.println("000");
      }
       else {
           System.out.println("1");
          batchInfo = BatchInfo.builder().build();
           System.out.println("2");
                  //.orgId(sessionManagementService.getCurrentOrganization().getId())
        //          .activeStatus(Constants.ACTIVE_STATUS)
//                  .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .build();
       }
        System.out.println("3");
        batchInfo.setBatchId(100L);
        System.out.println("4");
        batchInfo.setBatchName(batchInfoForm.getBatchName());
        System.out.println("5");
        batchInfo.setVisualId(batchInfoForm.getVisualId());
        System.out.println("6");
        batchInfo.setShortCode(batchInfoForm.getShortCode());
        System.out.println("7");
        batchInfo.setSessionId(batchInfoForm.getSessionId());
        System.out.println("8");
        batchInfo.setProgramId(batchInfoForm.getProgramId());
        System.out.println("9");
        batchInfo.setRemarks(batchInfoForm.getRemarks());
        System.out.println("10");


     return batchInfo;

    }

    private void populateShowPageModel(Model model, BatchInfo batchInfo) {
        model.addAttribute("batchInfoForm", batchInfo);

    }



}
