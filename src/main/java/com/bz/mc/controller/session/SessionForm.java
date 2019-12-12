package com.bz.mc.controller.session;



import com.bz.mc.model.setup.SessionInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * user: ashraf
 * date: 10/12/19
 * time: 4:45 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class SessionForm {

    private Long sessionId;
    private String sessionName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    private String remarks;
    private String shortCode;


    public SessionForm(SessionInfo sessionInfo) {
        this.sessionId = sessionInfo.getSessionId();
        this.sessionName = sessionInfo.getSessionName();
        this.remarks = sessionInfo.getRemarks();
        this.shortCode = sessionInfo.getShortCode();
    }


    public boolean isPersisted() {
        return sessionId != null;
    }
}
