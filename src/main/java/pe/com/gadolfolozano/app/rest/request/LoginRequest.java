package pe.com.gadolfolozano.app.rest.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginRequest {

	private String email;
	private String password;

	public LoginRequest() {
		// Required
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
