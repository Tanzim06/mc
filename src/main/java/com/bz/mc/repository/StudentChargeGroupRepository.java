package com.bz.mc.repository;

import com.bz.mc.facade.data.EnrolStudentData;
import com.bz.mc.facade.data.StudentChargeGroupData;
import com.bz.mc.model.shedule.StudentChargeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentChargeGroupRepository extends JpaRepository<StudentChargeGroup,Long> {

    @Query("SELECT new com.bz.mc.facade.data.StudentChargeGroupData(b.studentName, c.sessionName, b.doB, d.origin)" +
            "FROM StudentChargeGroup a inner join StudentRegistrationInfo b on a.studentRegistrationId = b.id " +
            "inner join SessionInfo c on b.sessionId = c.id " +
            "inner join ChargeGroup d on a.chargeGroupId = d.id"  +
            " where c.id = coalesce (:sessionId, c.id) " )
    List<StudentChargeGroupData> findStudentChargeGroupData(@Param("sessionId") Long sessionId);
}
//c.sessionName,d.origin