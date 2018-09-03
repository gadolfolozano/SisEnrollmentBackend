package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.model.SessionModel;

public interface SessionRepository {
	SessionModel getSession(String userId);

	int updateToken(String userId, String token);

	int createSession(String userId, String token);
}
