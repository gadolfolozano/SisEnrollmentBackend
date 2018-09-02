package pe.com.gadolfolozano.app.rest.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginRequest {

	private String cpf;
	private String password;

	public LoginRequest() {
		// Required
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
