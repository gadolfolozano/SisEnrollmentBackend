package pe.com.gadolfolozano.app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String cpf;
	private String name;
	
	public User() {
		//Required
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
