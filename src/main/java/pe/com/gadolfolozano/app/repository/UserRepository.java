package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.model.UserModel;

public interface UserRepository {
	UserModel getUser(String id);

	UserModel getUser(String id, String password);
}
