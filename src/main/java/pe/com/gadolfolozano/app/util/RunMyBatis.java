package pe.com.gadolfolozano.app.util;

import pe.com.gadolfolozano.app.model.UserModel;
import pe.com.gadolfolozano.app.repository.UserDataRepository;
import pe.com.gadolfolozano.app.repository.UserRepository;

public class RunMyBatis {
	public static void main(String[] args) {
		UserRepository userRepository = new UserDataRepository();
		UserModel user = userRepository.getUser("70115020683");

		System.out.println("id:" + user.getId() + ", Name:" + user.getName());
	}
}
