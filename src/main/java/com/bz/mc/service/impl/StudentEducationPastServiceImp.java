package com.bz.mc.service.impl;


import com.bz.mc.exception.NotFoundException;
import com.bz.mc.facade.data.StudentEducationPastData;
import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;
import com.bz.mc.repository.StudentEducationPastRepository;
import com.bz.mc.service.StudentEducationPastService;
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
public class StudentEducationPastServiceImp implements StudentEducationPastService {

	@Autowired
	private StudentEducationPastRepository studentEducationPastRepository;

	@Transactional
	@Override
	public StudentEducationPastInfo saveStudentEducationPast(StudentEducationPastInfo studentEducationPastInfo) {
		return studentEducationPastRepository.save(studentEducationPastInfo);
	}

	@Override
	public Optional<StudentEducationPastInfo> findStudentEducationPastById(Long id) {
		return studentEducationPastRepository.findById(id);
	}

	@Override
	public StudentEducationPastInfo getStudentEducationPast(Long id) {
		return findStudentEducationPastById(id).orElseThrow(NotFoundException::new);
	}

    @Override
    public List<StudentEducationPastInfo> getStudentEducationList() {
        return studentEducationPastRepository.findAll();
    }

	@Override
	public List<StudentEducationPastData> findStudentEducationPast(Long studentRegistrationId) {
		return studentEducationPastRepository.findStudentEducationPast(studentRegistrationId);
	}

}
