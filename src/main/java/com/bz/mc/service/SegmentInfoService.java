package com.bz.mc.service;

import com.bz.mc.model.setup.ProgramSegment;
import com.bz.mc.model.setup.SessionInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface SegmentInfoService {
//	public void saveSegment(ModelProgramSegment modelProgramSegment);
////	public ArrayList<ModelProgramSegment> getAllActiveSegment();

	List<ProgramSegment> findSegmentList();

	ProgramSegment getSegment(Long id);
	Optional<ProgramSegment> getProgramSegment(Long id);
}
