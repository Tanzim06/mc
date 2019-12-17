package com.bz.mc.controller.batch;

import com.bz.mc.controller.WebLinkFactory;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.service.BatchInfoService;
import com.bz.mc.service.ProgramService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public static final String ROUTE_SEARCH = BASE_ROUTE + "/search";
    private static final String ROUTE_SEARCH_RESULT = BASE_ROUTE + "/list";
    public static final String ROUTE_SHOW = BASE_ROUTE + "/show/{id}";
    public static final String ROUTE_UPDATE = BASE_ROUTE + "/create/{id}";
    public static final String ROUTE_EDIT = BASE_ROUTE + "/edit/{id}";
    private static final String REDIRECT = "redirect:";

    private Long id;

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
           // System.out.println("testee");
            populateModel(model, batchInfoForm);
            return "/web/pages/batch/create";
        }
        System.out.println("test");
        BatchInfo batchInfo =getBatchInfo(batchInfoForm);
        System.out.println("testyyy");
        System.out.println("id " + batchInfo.getId());
        batchInfo = batchInfoService.saveBatchInfo(batchInfo);

        System.out.println("test1");
        //return "/web/pages/batch/create";
        return REDIRECT+ webLinkFactory.updateBatchUrl(batchInfo);
    }

    @GetMapping(ROUTE_UPDATE)
    public String updateBatch(Model model, @PathVariable("id") Long id) {

        model.addAttribute("programs", programService.findPrograms());
        BatchInfo batchInfo = batchInfoService.getBatchInfo(id).get();

        populateShowPageModel(model, batchInfo);

        return "/web/pages/batch/create";
    }

    @GetMapping(ROUTE_SHOW)
    public String showBatch(Model model, @PathVariable Long id) {

        BatchInfo batchInfo = batchInfoService.getBatchInfo(id).get();

        populateShowPageModel(model, batchInfo);

        return "/web/pages/batch/show";
    }

    @GetMapping(ROUTE_SEARCH)
    public String batchList(Model model) {
        //populateModel(model, new BatchInfoForm());
        model.addAttribute("programs", programService.findPrograms());

        return "/web/pages/batch/search";
    }

    @PostMapping(value = ROUTE_SEARCH_RESULT)
    public String getBatchList(Model model, @RequestParam("remarks") String remarks, @RequestParam("batchName") String batchName,@RequestParam(name="activeStatus",required = false) String activeStatus) {

        int status;
        if(activeStatus==null){
            status=0;
        }
        else{
            status=1;
        }
        System.out.println("ddd" + activeStatus);


        List<BatchInfo> batchlist = batchInfoService.getAllBatch(batchName,remarks,status);
        //ArrayList<BatchInfo> batchlist =  batchInfoService.getAllActiveBatch();
        model.addAttribute("batchlist", batchlist);
        model.addAttribute("programs", programService.findPrograms());
        if (batchlist.size() != 0) {
//            model.addAttribute("bCList", officeServiceFacade.findBasicCenters(sessionManagementService.getCurrentOrganization().getId()));
//            model.addAttribute("samityName", samityName);
//            model.addAttribute("basicCenterId", basicCenterId);
            return "/web/pages/batch/search";
        }
        return REDIRECT + ROUTE_SEARCH;
    }


    @GetMapping(ROUTE_EDIT)
    public String editBatch(Model model, @PathVariable Long id,BatchInfoForm batchInfoForm) {
        this.id = id;
        BatchInfo batchInfo = batchInfoService.getBatch(id);
        //System.out.print("okk");

        populateModel(model, new BatchInfoForm(batchInfo));
        //System.out.print("okk1");

       // model.addAttribute("programs", programService.findPrograms());
        //BatchInfo batchInfo = batchInfoService.getBatchInfo(id).get();

        //populateShowPageModel(model, batchInfo);

        return "/web/pages/batch/create";
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

          //batchInfo = batchInfoService.getBatchInfo(batchInfoForm.getId()).get();
           batchInfo = batchInfoService.getBatchInfo(batchInfoForm.getId()).get();
           System.out.println("000");
      }
       else {
           System.out.println("1");
          batchInfo = BatchInfo.builder().activeStatus(Constants.ACTIVE_STATUS).build();
           System.out.println("2");
                  //.orgId(sessionManagementService.getCurrentOrganization().getId())


//                  .createdBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .updatedBy(sessionManagementService.getAuthenticatedUser().getId())
//                   .build();
       }
        System.out.println("3");
      // batchInfo.setBatchId(batchInfo.getBatchId());
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
