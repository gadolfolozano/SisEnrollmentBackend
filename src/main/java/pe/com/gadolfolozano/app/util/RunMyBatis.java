package pe.com.gadolfolozano.app.util;

import pe.com.gadolfolozano.app.Aluno;
import pe.com.gadolfolozano.app.repository.UserDataRepository;
import pe.com.gadolfolozano.app.repository.UserRepository;

public class RunMyBatis {
	public static void main(String[] args) {
		UserRepository userRepository = new UserDataRepository();
		Aluno aluno = userRepository.getUser("70115020683");

		System.out.println("id:" + aluno.getCpf() + ", Name:" + aluno.getNome());
	}
}
