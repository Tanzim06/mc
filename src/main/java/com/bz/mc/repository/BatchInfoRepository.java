package com.bz.mc.repository;

import com.bz.mc.model.batch.BatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * User: SHAHIDUL
 * Date: 11/12/19
 * Time: 10:00 PM
 */
public interface BatchInfoRepository extends JpaRepository<BatchInfo,Long> {


    //@Query("select a from BATCH_INFO a  where  a.batchName LIKE CONCAT('%',:batchName,'%') and a.remarks LIKE CONCAT('%',:remarks,'%') and a.activeStatus=:activeStatus ")
    //@Query("select a from BATCH_INFO a  where  a.batchName LIKE CONCAT('%',:batchName,'%') and a.remarks LIKE CONCAT('%',:remarks,'%')")
     //List<BatchInfo> findBatch(@Param("programId") Long  programId, @Param("batchName") String batchName);

}
