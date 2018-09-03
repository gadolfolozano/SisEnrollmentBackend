package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.model.UserModel;
import pe.com.gadolfolozano.app.repository.datasource.UserDataStoreFactory;

public class UserDataRepository implements UserRepository {

	private UserDataStoreFactory userDataStoreFactory;
	
	public UserDataRepository() {
		userDataStoreFactory = new UserDataStoreFactory();
	}
	
	@Override
	public UserModel getUser(String id) {
		UserRepository userRepository = userDataStoreFactory.create();
		return userRepository.getUser(id);
	}

	@Override
	public UserModel getUser(String id, String password) {
		UserRepository userRepository = userDataStoreFactory.create();
		return userRepository.getUser(id, password);
	}

}
