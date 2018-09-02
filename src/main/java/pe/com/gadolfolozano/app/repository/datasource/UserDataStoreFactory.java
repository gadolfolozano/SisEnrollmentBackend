package pe.com.gadolfolozano.app.repository.datasource;

import pe.com.gadolfolozano.app.repository.UserRepository;

public class UserDataStoreFactory {
	public UserRepository create() {
		return new DataBaseUserDataStore();
	}
}
