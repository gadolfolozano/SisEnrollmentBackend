package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.Aluno;
import pe.com.gadolfolozano.app.repository.datasource.UserDataStoreFactory;

public class UserDataRepository implements UserRepository {

	private UserDataStoreFactory userDataStoreFactory;
	
	public UserDataRepository() {
		userDataStoreFactory = new UserDataStoreFactory();
	}
	
	@Override
	public Aluno getUser(String id) {
		UserRepository userRepository = userDataStoreFactory.create();
		return userRepository.getUser(id);
	}

	@Override
	public Aluno getUser(String cpf, String password) {
		UserRepository userRepository = userDataStoreFactory.create();
		return userRepository.getUser(cpf, password);
	}

}
