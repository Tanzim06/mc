package com.bz.mc.service;

import com.bz.mc.facade.data.StudentEducationPastData;
import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;

import java.util.List;
import java.util.Optional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:29 AM
 */

public interface StudentEducationPastService {
	StudentEducationPastInfo saveStudentEducationPast(StudentEducationPastInfo studentEducationPastInfo);
	Optional<StudentEducationPastInfo> findStudentEducationPastById(Long id);
//    Optional <StudentRegistrationInfo> getStudentRegistrationInfo(Long id);
    StudentEducationPastInfo getStudentEducationPast(Long id);
    List<StudentEducationPastInfo> getStudentEducationList();
//    List<StudentEducationPastInfo>findStudentEducationPast(Long studentRegistrationId);
   List<StudentEducationPastData>findStudentEducationPast(Long studentRegistrationId);
}