package com.bz.mc.service;

import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:29 AM
 */

public interface StudentRegistrationService {
	StudentRegistrationInfo saveStudentRegistration(StudentRegistrationInfo studentRegistrationInfo);
	Optional<StudentRegistrationInfo> findStudentRegistrationById(Long id);
    Optional <StudentRegistrationInfo> getStudentRegistrationInfo(Long id);
    StudentRegistrationInfo getStudentRegistration(Long id);
//    List<StudentRegistrationInfo> getStudentRegistrationSearch( String studentName, String fatherName, String motherName, String contactNo, Long sessionId );
    List<StudentRegistrationData> getStudentRegistrationSearch(Long sessionId, Long id, String studentName, String fatherName, String motherName, String contactNo, Date doB, Date registrationDate);
    List<StudentRegistrationInfo> findStudentRegistrationList();
}