package pe.com.gadolfolozano.app.database.entity;

public class SessionEntity {
	private String userId;
	private String token;

	public SessionEntity() {
		// Required
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
