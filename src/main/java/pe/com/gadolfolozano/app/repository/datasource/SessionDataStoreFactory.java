package pe.com.gadolfolozano.app.repository.datasource;

import pe.com.gadolfolozano.app.repository.SessionRepository;

public class SessionDataStoreFactory {
	public SessionRepository create() {
		return new DataBaseSessionDataSource();
	}
}
