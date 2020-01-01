package com.bz.mc.service.impl;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import com.bz.mc.repository.EnrolStudentRepository;
import com.bz.mc.service.EnrolStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:39 AM
 */

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class EnrolStudentServiceImp implements EnrolStudentService {

	@Autowired
	private EnrolStudentRepository enrolStudentRepository;

	@Transactional
	@Override
	public EnrolStudentInfo saveEnrolStudent(EnrolStudentInfo enrolStudentInfo) {
		return enrolStudentRepository.save(enrolStudentInfo);
	}

	@Override
	public Optional<EnrolStudentInfo> findEnrolStudentById(Long id) {
		return enrolStudentRepository.findById(id);
	}

	@Override
	public Optional<EnrolStudentInfo> getEnrolStudentInfo(Long id) {
		return findEnrolStudentById(id);
	}

	@Override
	public EnrolStudentInfo getEnrolStudent(Long id) {
		return getEnrolStudentInfo(id).orElseThrow(NotFoundException::new);
	}

	@Override
	public List<EnrolStudentData> getEnrolStudentSearch(Long studentRegistrationId, String studentName, Long sessionId, Long programId) {
		return enrolStudentRepository.findEnrolStudentDataSearch(studentRegistrationId,studentName,sessionId,programId);
	}


}
