package com.bz.mc.service.impl;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.model.program.Program;
import com.bz.mc.repository.ProgramRepository;
import com.bz.mc.service.ProgramService;
import com.bz.mc.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ProgramServiceImp implements ProgramService {

    @NonNull
    private final ProgramRepository programRepository;

    @Override
    public List<Program> findPrograms() {

        return programRepository.findAll();
       //return programRepository.findProgramByActiveStatusOrderByProgramName(1);
    }
    @Override
    public Optional<Program> getProgramById(Long id) {
        return programRepository.findById(id);
    }

    @Override
    public Program getProgram(Long id) {
        return getProgramById(id).orElseThrow(NotFoundException::new);
    }
}
