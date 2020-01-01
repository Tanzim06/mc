package com.bz.mc.repository;

import com.bz.mc.facade.data.StudentRegistrationData;
import com.bz.mc.model.studentRegistration.StudentRegistrationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:11 AM
 */

public interface StudentRegistrationRepository extends JpaRepository <StudentRegistrationInfo,Long>{

    @Query("SELECT new com.bz.mc.facade.data.StudentRegistrationData(a.id, a.studentName, a.fatherName, a.motherName, a.contactNo,a.doB,b.sessionName) " +
            "FROM StudentRegistrationInfo a inner join SessionInfo b on a.sessionId = b.id where a.sessionId = coalesce(:sessionId,a.sessionId) " +
            "and  a.id = coalesce(:id,a.id) and  a.studentName LIKE CONCAT('%',:studentName, '%') and a.fatherName LIKE CONCAT('%',:fatherName, '%') " +
            "and a.motherName LIKE CONCAT('%',:motherName, '%') and a.contactNo LIKE CONCAT('%',:contactNo, '%') and a.doB=coalesce (:doB, a.doB)" +
            "and a.registrationDate=coalesce (:registrationDate, a.registrationDate)" )
    List<StudentRegistrationData> findStudentRegistrationSearch(@Param("sessionId") Long sessionId, @Param("id") Long id, @Param("studentName") String studentName,
                                                                @Param("fatherName") String fatherName, @Param("motherName") String motherName,
                                                                @Param("contactNo") String contactNo,
                                                                @Param("doB") Date doB, @Param("registrationDate") Date registrationDate);

}
