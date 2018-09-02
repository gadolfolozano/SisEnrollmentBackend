package pe.com.gadolfolozano.app;

public class UserSession {
	private String userId;
	private String token;

	public UserSession() {
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
