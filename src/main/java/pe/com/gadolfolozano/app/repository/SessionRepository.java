package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.UserSession;

public interface SessionRepository {
	UserSession getSession(String userId);

	int updateToken(String userId, String token);

	int createSession(String userId, String token);
}
