package com.bz.mc.service.impl;


import com.bz.mc.exception.NotFoundException;
import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import com.bz.mc.repository.StudentRegistrationRepository;
import com.bz.mc.service.StudentRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:39 AM
 */

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class StudentRegistrationServiceImp implements StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;

	@Transactional
	@Override
	public StudentRegistrationInfo saveStudentRegistration(StudentRegistrationInfo studentRegistrationInfo) {
		return studentRegistrationRepository.save(studentRegistrationInfo);
	}

	@Override
	public Optional<StudentRegistrationInfo> findStudentRegistrationById(Long id) {
		return studentRegistrationRepository.findById(id);
	}

	@Override
	public Optional<StudentRegistrationInfo> getStudentRegistrationInfo(Long id) {
		return findStudentRegistrationById(id);
	}

	@Override
	public StudentRegistrationInfo getStudentRegistration(Long id) {
		return getStudentRegistrationInfo(id).orElseThrow(NotFoundException::new);
	}

	@Override
	public List<StudentRegistrationData> getStudentRegistrationSearch(Long sessionId, Long id, String studentName, String fatherName, String motherName, String contactNo , Date doB, Date registrationDate) {
		return studentRegistrationRepository.findStudentRegistrationSearch(sessionId,id, studentName, fatherName, motherName, contactNo,doB,registrationDate);
	}

	@Override
	public List<StudentRegistrationInfo> findStudentRegistrationList() {
		return studentRegistrationRepository.findAll();
	}

//	@Override
//	public List<StudentRegistrationInfo> findStudentRegistrationList() {
//		return studentRegistrationRepository.findAll();
//	}

//	@Override
//	public List<StudentRegistrationData> getStudentRegistrationSearch(Long sessionId, String studentName, String fatherName, String motherName, String contactNo) {
//		return studentRegistrationRepository.findStudentRegistrationSearch(sessionId, studentName, fatherName, motherName, contactNo,do);
//	}
//	, LocalDate doB, LocalDate registrationDate
//	, doB, registrationDate
//	@Override
//	public List<StudentRegistrationInfo> getStudentRegistrationSearch( String studentName, String fatherName, String motherName, String contactNo,Long sessionId) {
//		return studentRegistrationRepository.findStudentRegistrationSearch( studentName,fatherName, motherName,contactNo,sessionId);
//	}
//	@Override
//	public List<StudentRegistrationData> getStudentRegistrationSearch(Long sessionId, String studentName) {
//		return studentRegistrationRepository.findStudentRegistrationSearch(sessionId, studentName);
//	}
//	@Override
//	public List<StudentRegistrationInfo> getStudentRegistrationSearch(String studentName, String fatherName, String motherName, String contactNo) {
//		return studentRegistrationRepository.findStudentRegistrationSearch(studentName,fatherName,motherName,contactNo);
//	}


}
