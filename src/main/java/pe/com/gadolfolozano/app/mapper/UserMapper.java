package pe.com.gadolfolozano.app.mapper;

import pe.com.gadolfolozano.app.database.entity.AlunoEntity;
import pe.com.gadolfolozano.app.model.UserModel;

public class UserMapper {
	public UserMapper() {
		// Requiered
	}
	
	public UserModel toModel(AlunoEntity entity){
		UserModel model = null;
		
		if(entity != null) {
			model = new UserModel();
			
			model.setId(entity.getCpf());
			model.setName(entity.getNome());
		}
		
		return model;
	}
}
