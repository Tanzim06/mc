package com.bz.mc.util;


import com.bz.mc.facade.SessionManagementService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * User: rafiq
 * Date: 20/11/19
 * Time: 12:42 AM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class CodeGenerator {


    @NonNull private final SessionManagementService sessionManagementService;


}
