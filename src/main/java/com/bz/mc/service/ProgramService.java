package com.bz.mc.service;

import com.bz.mc.model.program.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {

    List<Program> findPrograms();
    Optional<Program> getProgramById(Long id);
    Program getProgram(Long id);
}
