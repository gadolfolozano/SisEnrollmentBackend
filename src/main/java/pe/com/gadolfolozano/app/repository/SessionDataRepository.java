package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.UserSession;
import pe.com.gadolfolozano.app.repository.datasource.SessionDataStoreFactory;

public class SessionDataRepository implements SessionRepository {

	private SessionDataStoreFactory sessionDataStoreFactory;

	public SessionDataRepository() {
		sessionDataStoreFactory = new SessionDataStoreFactory();
	}

	@Override
	public UserSession getSession(String userId) {
		SessionRepository sessionRepository = sessionDataStoreFactory.create();
		return sessionRepository.getSession(userId);
	}

	@Override
	public int updateToken(String userId, String token) {
		SessionRepository sessionRepository = sessionDataStoreFactory.create();
		return sessionRepository.updateToken(userId, token);
	}

	@Override
	public int createSession(String userId, String token) {
		SessionRepository sessionRepository = sessionDataStoreFactory.create();
		return sessionRepository.createSession(userId, token);
	}

}
