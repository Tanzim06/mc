package com.bz.mc.controller.session;



import com.bz.mc.model.setup.SessionInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

/**
 * user: ashraf
 * date: 10/12/19
 * time: 4:45 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class SessionForm {

    private Long id;
    private String sessionName;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String startDate;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String endDate;
    private String remarks;
    private String shortCode;


//    public SessionForm(LocalDate startDate, LocalDate endDate) {
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }

    public SessionForm(SessionInfo sessionInfo) {
        this.id = sessionInfo.getId();
        this.sessionName = sessionInfo.getSessionName();
        this.remarks = sessionInfo.getRemarks();
        this.shortCode = sessionInfo.getShortCode();
//        this.startDate = sessionInfo.getStartDate();
//        this.endDate = sessionInfo.getEndDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startDate = formatter.format(sessionInfo.getStartDate());

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.endDate = formatter.format(sessionInfo.getEndDate());
    }


    public boolean isPersisted() {
        return id != null;
    }
}
