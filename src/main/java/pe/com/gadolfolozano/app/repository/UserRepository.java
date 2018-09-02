package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.Aluno;

public interface UserRepository {
	Aluno getUser(String id);

	Aluno getUser(String cpf, String password);
}
