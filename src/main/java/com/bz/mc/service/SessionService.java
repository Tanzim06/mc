package com.bz.mc.service;

import com.bz.mc.model.setup.SessionInfo;

import java.util.List;
import java.util.Optional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:29 AM
 */

public interface SessionService {
	SessionInfo saveSession(SessionInfo sessionInfo);
	Optional<SessionInfo> findSessionById(Long id);
    Optional <SessionInfo> getSessionInfo(Long id);
    SessionInfo getSession(Long id);
	List<SessionInfo> findSessionList();

}