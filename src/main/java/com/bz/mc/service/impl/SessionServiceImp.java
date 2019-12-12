package com.bz.mc.service.impl;

import java.util.List;
import java.util.Optional;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.model.setup.SessionInfo;
import com.bz.mc.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

//	 @Override
//	public List<SessionInfo> getModelSessionList() {
//		return sessionRepository.findAll();
//	}
//
//	public int save(SessionInfo sessionInfo) {
//		try {
//		sessionRepository.save(sessionInfo);
//		return 1;
//	}
//		catch(Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//    }
//
//    @Override
//	public List<SessionInfo> getAllSessionByActiveStatus() {
//              return sessionRepository.findAllSessionByActiveStatus(1);
//	}

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
	public SessionInfo getSessionInfo(Long id) {
		return findSessionById(id).orElseThrow(NotFoundException::new);
	}

}
