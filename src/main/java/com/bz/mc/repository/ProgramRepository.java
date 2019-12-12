package com.bz.mc.repository;

import com.bz.mc.model.program.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program,Long> {

    List<Program> findProgramByActiveStatusOrderByProgramName(Integer activeStatus);

    //List<Program> findProgramByActiveStatusOrderByProgramName(int activeStatus);
}
