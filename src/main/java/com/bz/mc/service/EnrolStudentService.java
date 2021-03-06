package com.bz.mc.service;

import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.model.enrol.EnrolStudentInfo;

import java.util.List;
import java.util.Optional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:29 AM
 */

public interface EnrolStudentService {
	EnrolStudentInfo saveEnrolStudent(EnrolStudentInfo enrolStudentInfo);
	Optional<EnrolStudentInfo> findEnrolStudentById(Long id);
    Optional <EnrolStudentInfo> getEnrolStudentInfo(Long id);
    EnrolStudentInfo getEnrolStudent(Long id);
   // EnrolStudentInfo getEnrolStudentNew(Long registratrionId);
////    List<StudentRegistrationInfo> getStudentRegistrationSearch( String studentName, String fatherName, String motherName, String contactNo, Long sessionId );
    List<EnrolStudentData> getEnrolStudentSearch(Long studentRegistrationId, String studentName, Long sessionId, Long programId, Long programSegmentId, Long batchId);
//    List<EnrolStudentData> getStudentRegistrationByActiveStatus(Long studentRegistrationId, String studentName, Long sessionId, Long programId, Long programSegmentId, Long batchId);
    List<EnrolStudentData> getStudentListForNewEnrol(Long studentRegistrationId, String studentName, Long sessionId, Long programId, Long programSegmentId, Long batchId);
    List<EnrolStudentData> getStudentForEnrol(Long sessionId);
    List<EnrolStudentInfo> enrollList(Long Id);
    List<EnrolStudentInfo> saveEnroll(List<EnrolStudentInfo> enrolStudentInfoList);


}