package com.bz.mc.repository;

import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.model.enrol.EnrolStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:11 AM
 */

public interface EnrolStudentRepository extends JpaRepository <EnrolStudentInfo,Long>{



//    @Query("SELECT new com.bz.em.facade.data.SamityData(a.id,                         and a.batchId = coalesce (:batchId, a.batchId)   left outer join BatchInfo f on a.batchId=f.id                                       a.samityName, b.basicCenterName, e.districtName, c.upzillaName, d.unionName)    and a.batchId = coalesce (:batchId, a.batchId)  FROM Samity a inner join BasicCenter b on a.basicCenterId = b.id inner join Upzilla c on a.upzillaId=c.id left outer join Union d on a.unionId=d.id inner join District e on c.districtId=e.id where a.basicCenterId = coalesce(:basicCenterId,a.basicCenterId) and a.samityName LIKE CONCAT('%',:samityName, '%')")
    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData(a.id, a.studentRegistrationId, b.studentName, b.fatherName, c.sessionName, e.segmentName,a.enrolDate) " +
            "FROM EnrolStudentInfo a inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id inner join SessionInfo c on b.sessionId = c.id " +
            "inner join Program d on b.programId = d.id inner join ProgramSegment e on b.programSegmentId = e.id left outer join BatchInfo f on a.batchId=f.id  "  +
            " where a.studentRegistrationId = coalesce (:studentRegistrationId, a.studentRegistrationId) and b.studentName LIKE CONCAT('%',:studentName, '%')" +
            "and b.sessionId = coalesce (:sessionId, b.sessionId) and b.programId = coalesce (:programId, b.programId) and b.programSegmentId = coalesce " +
            "(:programSegmentId, b.programSegmentId) and a.batchId = coalesce (:batchId, a.batchId) " )
    List<EnrolStudentData> findEnrolStudentDataSearch(@Param("studentRegistrationId") Long studentRegistrationId,
                                                      @Param("studentName") String studentName,
                                                      @Param("sessionId") Long sessionId,
                                                      @Param("programId") Long programId,
                                                      @Param("programSegmentId") Long programSegmentId,
                                                      @Param("batchId") Long batchId);



//    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData(a.id, a.studentRegistrationId, b.studentName, b.fatherName, c.sessionName, e.segmentName) " +
//            "FROM EnrolStudentInfo a inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id inner join SessionInfo c on b.sessionId = c.id " +
//            "inner join Program d on b.programId = d.id inner join ProgramSegment e on b.programSegmentId = e.id left outer join BatchInfo f on a.batchId=f.id  "  +
//            " where a.studentRegistrationId = coalesce (:studentRegistrationId, a.studentRegistrationId) and b.studentName LIKE CONCAT('%',:studentName, '%')" +
//            "and b.sessionId = coalesce (:sessionId, b.sessionId) and b.programId = coalesce (:programId, b.programId) and b.programSegmentId = coalesce " +
//            "(:programSegmentId, b.programSegmentId) and a.batchId = coalesce (:batchId, a.batchId) " )
//    List<EnrolStudentData> findStudentRegistrationByActiveStatus(@Param("studentRegistrationId") Long studentRegistrationId,
//                                                                 @Param("studentName") String studentName,
//                                                                 @Param("sessionId") Long sessionId,
//                                                                 @Param("programId") Long programId,
//                                                                 @Param("programSegmentId") Long programSegmentId,
//                                                                 @Param("batchId") Long batchId);


    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData( b.id, b.studentName, b.fatherName, c.sessionName, e.segmentName) " +
            "  FROM  StudentRegistrationInfo b  inner join SessionInfo c on b.sessionId = c.id " +
            "inner join Program d on b.programId = d.id inner join ProgramSegment e on b.programSegmentId = e.id "  +
            " where b.id = coalesce (:studentRegistrationId, b.id) and b.studentName LIKE CONCAT('%',:studentName, '%')" +
            "and b.sessionId = coalesce (:sessionId, b.sessionId) and b.programId = coalesce (:programId, b.programId) and b.programSegmentId = coalesce " +
         "(:programSegmentId, b.programSegmentId) ") //  +
//            " and not exists (select 1 from enrolStudentInfo g where g.studentRegistrationId=b.id)")
    List<EnrolStudentData> findStudentListForNewEnrol(@Param("studentRegistrationId") Long studentRegistrationId,
                                                      @Param("studentName") String studentName,
                                                      @Param("sessionId") Long sessionId,
                                                      @Param("programId") Long programId,
                                                      @Param("programSegmentId") Long programSegmentId);

    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData(b.id, b.studentName, b.fatherName, c.sessionName, d.programName," +
            " e.segmentName,b.motherName,b.permanentAdd,b.permanentAddPostCode,b.presentAdd,b.presentAddPostcode,b.doB,b.registrationDate," +
            "b.bloodGroup,b.gender,b.contactNo,b.remarks) " +
            "  FROM  StudentRegistrationInfo b  inner join SessionInfo c on b.sessionId = c.id " +
            "inner join Program d on b.programId = d.id inner join ProgramSegment e on b.programSegmentId = e.id "  +
            " where b.id = coalesce (:studentRegistrationId, b.id) " )
//            "and b.studentName LIKE CONCAT('%',:studentName, '%')" +
//            "and b.sessionId = coalesce (:sessionId, b.sessionId) and b.programId = coalesce (:programId, b.programId) and b.programSegmentId = coalesce " +
//            "(:programSegmentId, b.programSegmentId) ") //  +
//            " and not exists (select 1 from enrolStudentInfo g where g.studentRegistrationId=b.id)")
    List<EnrolStudentData> findStudentRegistrationData(@Param("studentRegistrationId") Long studentRegistrationId);



    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData(a.id, a.studentRegistrationId, b.studentName, c.sessionName, b.doB) " +
            "  FROM  EnrolStudentInfo a inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id inner join SessionInfo c on a.sessionId = c.id " +
            " where a.sessionId = coalesce (:sessionId, a.sessionId)")
    List<EnrolStudentData> findStudentForEnrol(@Param("sessionId") Long sessionId);


    List<EnrolStudentInfo> findEnrolStudentInfoById(Long Id);

}
//@Query("SELECT a FROM SamityMember a WHERE NOT EXISTS (SELECT a FROM SamityMemberRoleAssignment b WHERE a.id=b.shamityMemberId) AND a.samityId=:samityId")
// "SELECT e FROM Employee e WHERE NOT EXISTS(SELECT j from JobInfo j WHERE j.jobName = e.job)"
//  this.id=id;
//          this.studentRegistrationId = studentRegistrationId;
//          this.studentName = studentName;
//          this.sessionName = sessionName;
//          this.doB = doB;
//          this.origin = origin;