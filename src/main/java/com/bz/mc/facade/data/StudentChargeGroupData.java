package com.bz.mc.facade.data;

/*
name: moly
date: 21/12/19
time: 10:18 am
 */
import com.bz.mc.model.charge.Origin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class StudentChargeGroupData {
    private String sessionName;
    private String studentName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate doB;
    private Origin origin;

}
