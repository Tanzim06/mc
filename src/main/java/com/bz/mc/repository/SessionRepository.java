package com.bz.mc.repository;

import java.util.List;
import com.bz.mc.model.setup.SessionInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:11 AM
 */

public interface SessionRepository extends JpaRepository <SessionInfo,Long>{

//	public List<SessionInfo> findAllSessionByActiveStatus(int activeStatus);
}
