package pe.com.gadolfolozano.app.model;

public class SessionModel {

	private String userId;
	private String token;

	public SessionModel() {
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
