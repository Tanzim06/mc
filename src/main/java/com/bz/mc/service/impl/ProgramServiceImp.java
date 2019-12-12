package com.bz.mc.service.impl;

import com.bz.mc.model.program.Program;
import com.bz.mc.repository.ProgramRepository;
import com.bz.mc.service.ProgramService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ProgramServiceImp implements ProgramService {

    @NonNull
    private final ProgramRepository programRepository;

    @Override
    public List<Program> findPrograms() {

        return programRepository.findProgramByActiveStatusOrderByProgramName(Constants.ACTIVE_STATUS);
       //return programRepository.findProgramByActiveStatusOrderByProgramName(1);
    }
}
