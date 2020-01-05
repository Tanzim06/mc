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
    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData(a.id, a.studentRegistrationId, b.studentName, b.fatherName, c.sessionName, d.programName,a.enrolDate) " +
            "FROM EnrolStudentInfo a inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id inner join SessionInfo c on b.sessionId = c.id " +
            "inner join Program d on b.programId = d.id inner join ProgramSegment e on b.programSegmentId = e.id  " +
            " where a.studentRegistrationId = coalesce (:studentRegistrationId, a.studentRegistrationId) and b.studentName LIKE CONCAT('%',:studentName, '%')" +
            "and b.sessionId = coalesce (:sessionId, b.sessionId) and b.programId = coalesce (:programId, b.programId) and b.programSegmentId = coalesce " +
            "(:programSegmentId, b.programSegmentId) " )
    List<EnrolStudentData> findEnrolStudentDataSearch(@Param("studentRegistrationId") Long studentRegistrationId,
                                                      @Param("studentName") String studentName,
                                                      @Param("sessionId") Long sessionId,
                                                      @Param("programId") Long programId,
                                                      @Param("programSegmentId") Long programSegmentId);
//                                                      @Param("batchId") Long batchId);



    @Query("SELECT new com.bz.mc.facade.data.EnrolStudentData(a.id, a.studentRegistrationId, b.studentName, b.fatherName, " +
            "b.motherName,b.permanentAdd,b.permanentAddPostCode,b.presentAdd,b.presentAddPostcode,b.bloodGroup) " +
            "FROM EnrolStudentInfo a inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id " +
//            "inner join Program d on b.programId = d.id inner join ProgramSegment e on b.programSegmentId = e.id  " + b.doB,b.registrationDate
            "where a.studentRegistrationId = coalesce (:studentRegistrationId, a.studentRegistrationId) " )
    List<EnrolStudentData> findStudentRegisDataAll(@Param("studentRegistrationId") Long studentRegistrationId);
}
//    inner join SessionInfo c on b.sessionId = c.id
//c.sessionName, d.programName,e.programSegmentName,
//this.id = id;
//        this.studentRegistrationId = studentRegistrationId;
//        this.studentName = studentName;
//        this.fatherName = fatherName;
//        this.sessionName = sessionName;
//        this.programName = programName;
//        this.programSegmentName = programSegmentName;
//        this.motherName = motherName;
//        this.permanentAdd = permanentAdd;
//        this.permanentAddPostCode = permanentAddPostCode;
//        this.presentAdd = presentAdd;
//        this.presentAddPostcode = presentAddPostcode;
//        this.doB = doB;
//        this.registrationDate = registrationDate;
//        this.bloodGroup = bloodGroup;