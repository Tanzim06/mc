package com.bz.mc.controller.schedule;

import com.bz.mc.model.shedule.StudentChargeGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StudentChargeGroupFrom {
    private Long id;
    private Long studentRegistrationId;
    private Long chargeGroupId;
    private int activeStatus;
    private String remarks;

    public StudentChargeGroupFrom(Long id, Long studentRegistrationId, Long chargeGroupId, int activeStatus, String remarks) {
        this.id = id;
        this.studentRegistrationId = studentRegistrationId;
        this.chargeGroupId = chargeGroupId;
        this.activeStatus = activeStatus;
        this.remarks = remarks;
    }

    public StudentChargeGroupFrom(StudentChargeGroup studentChargeGroup) {
    }

    public boolean isPersisted() {
        return id != null;
    }

}
