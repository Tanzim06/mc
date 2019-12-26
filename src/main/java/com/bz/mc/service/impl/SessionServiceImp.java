package com.bz.mc.service.impl;

import java.util.List;
import java.util.Optional;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.model.setup.SessionInfo;
import com.bz.mc.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.bz.mc.repository.SessionRepository;

import javax.transaction.Transactional;

/**
 * User: moly
 * Date: 11/12/19
 * Time: 10:39 AM
 */

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class SessionServiceImp implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;

	@Transactional
	@Override
	public SessionInfo saveSession(SessionInfo sessionInfo) {
		return sessionRepository.save(sessionInfo);
	}

	@Override
	public Optional<SessionInfo> findSessionById(Long id) {
		return sessionRepository.findById(id);
	}

	@Override
	public Optional<SessionInfo> getSessionInfo(Long id) {
		return findSessionById(id);
	}

	@Override
	public SessionInfo getSession(Long id) {
		return getSessionInfo(id).orElseThrow(NotFoundException::new);
	}

//	@Override
//	public Pagee<SessionInfo> findSession(Long sessionId, Pageablee pageable) {
//		return sessionRepository.findSesseionBysessionIdAndActiveStatus(sessionId, Constants.ACTIVE_STATUS,pageable);
//	}

	@Override
	public List<SessionInfo> findSessionList() {
		return sessionRepository.findAll();
	}

}
