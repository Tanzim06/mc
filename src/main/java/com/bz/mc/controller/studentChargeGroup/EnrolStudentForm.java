package com.bz.mc.controller.studentChargeGroup;

import com.bz.mc.controller.studentRegistration.StudentRegistrationForm;
import com.bz.mc.model.charge.Origin;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.model.studentRegistration.Gender;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrolStudentForm {

    private Long id;
    private Long studentRegistrationId;
    private String studentName;
    private Long sessionId;
    private String sessionName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate doB;
    private Origin origin;
    public boolean isPersisted() {
        return id != null;
    }



}

