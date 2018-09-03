package pe.com.gadolfolozano.app.mapper;

import pe.com.gadolfolozano.app.database.entity.SessionEntity;
import pe.com.gadolfolozano.app.model.SessionModel;

public class SessionMapper {
	public SessionMapper() {
		// Requiered
	}
	
	public SessionModel toModel(SessionEntity entity) {
		SessionModel model = null;
		if(entity!=null) {
			model = new SessionModel();
			
			model.setUserId(entity.getUserId());
			model.setToken(entity.getToken());
		}
		return model;
	}
}
