package com.bz.mc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bz.mc.model.setup.ProgramSegment;
import com.bz.mc.service.SegmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bz.mc.repository.SegmentInfoRepository;

@Service
public class SegmentInfoServiceImp implements SegmentInfoService {
	@Autowired
	private SegmentInfoRepository segmentInfoRepository;

	@Override
	public List<ProgramSegment> findSegmentList() {
		return segmentInfoRepository.findAll();
	}


//
//	@Override
//	public void saveSegment(ModelProgramSegment modelProgramSegment) {
//		segmentInfoRepository.save(modelProgramSegment);
//
//	}
//
//	@Override
//	public ArrayList<ModelProgramSegment> getAllActiveSegment() {
//
//		return (ArrayList<ModelProgramSegment>)segmentInfoRepository.findAll();
//	}
//

}
