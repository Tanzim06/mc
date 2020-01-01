package com.bz.mc.repository;

import com.bz.mc.facade.data.StudentEducationPastData;
import com.bz.mc.model.studentRegistration.StudentEducationPastInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:11 AM
 */

public interface StudentEducationPastRepository extends JpaRepository <StudentEducationPastInfo,Long>{

//    //@Query("select a from BATCH_INFO a  where  a.batchName LIKE CONCAT('%',:batchName,'%') and a.remarks LIKE CONCAT('%',:remarks,'%') and a.activeStatus=:activeStatus ")
//    @Query("select a from StudentRegistrationInfo a  where  a.studentName LIKE CONCAT('%',:studentName,'%') and a.fatherName LIKE CONCAT('%',:fatherName,'%') and a.motherName LIKE CONCAT('%',:motherName,'%')  and a.contactNo LIKE CONCAT('%',:contactNo,'%')")
//    List<StudentRegistrationInfo> findStudentRegistrationSearch(@Param("studentName") String studentName, @Param("fatherName") String fatherName, @Param("motherName") String motherName, @Param("contactNo") String contactNo);

    @Query("SELECT new com.bz.mc.facade.data.StudentEducationPastData(a.id, a.studentRegistrationId, a.examName, a.groupName,a.yearPassed, a.rollNo," +
            " a.regNo, a.boardName,a.gpa, a.marksBiology, a.remarks,a.activeStatus) FROM StudentEducationPastInfo a " +
            "inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id " +
            " where a.studentRegistrationId = coalesce(:studentRegistrationId,a.studentRegistrationId)")
    List<StudentEducationPastData> findStudentEducationPast(@Param("studentRegistrationId") Long studentRegistrationId);

//    @Query("select a from StudentEducationPastInfo  a where   a.studentRegistrationId=:studentRegistrationId ")
//    List<StudentEducationPastInfo> findStudentEducationPast(@Param("studentRegistrationId") Long studentRegistrationId);
}
