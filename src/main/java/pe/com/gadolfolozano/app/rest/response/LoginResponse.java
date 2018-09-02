package pe.com.gadolfolozano.app.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResponse {

	private String token;
	private UserResponse user;

	public LoginResponse() {
		// Required
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

}
