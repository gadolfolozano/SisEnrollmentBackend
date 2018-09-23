package pe.com.gadolfolozano.app.repository;

import pe.com.gadolfolozano.app.model.UserModel;

public interface UserRepository {
	UserModel getUser(String email, String password);
}
