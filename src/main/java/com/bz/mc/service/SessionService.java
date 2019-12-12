package com.bz.mc.service;

import java.util.List;
import java.util.Optional;

import com.bz.mc.model.setup.SessionInfo;
/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:29 AM
 */

public interface SessionService {
      
	
	/* this metehod used for get all active basic center list */
	
//	public List<SessionInfo> getModelSessionList();
//	public int save(SessionInfo sessionInfo);
//	public List<SessionInfo> getAllSessionByActiveStatus();


	SessionInfo saveSession(SessionInfo sessionInfo);
	Optional<SessionInfo> findSessionById(Long id);
	SessionInfo getSessionInfo(Long id);

}