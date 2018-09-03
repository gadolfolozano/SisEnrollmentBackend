package pe.com.gadolfolozano.app.repository.datasource;

import org.apache.ibatis.session.SqlSession;

import pe.com.gadolfolozano.app.database.MyBatisUtil;
import pe.com.gadolfolozano.app.database.entity.SessionEntity;
import pe.com.gadolfolozano.app.database.mybatismapper.SessionEntityMapper;
import pe.com.gadolfolozano.app.mapper.SessionMapper;
import pe.com.gadolfolozano.app.model.SessionModel;
import pe.com.gadolfolozano.app.repository.SessionRepository;

public class DataBaseSessionDataSource implements SessionRepository{
	
	private SessionMapper mapper;
	
	public DataBaseSessionDataSource() {
		mapper = new SessionMapper();
	}

	@Override
	public SessionModel getSession(String userId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		SessionEntityMapper entityMapper = session.getMapper(SessionEntityMapper.class);
		SessionEntity userSession = entityMapper.getUserSession(userId);
		session.close();
		return mapper.toModel(userSession);
	}

	@Override
	public int updateToken(String userId, String token) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		SessionEntityMapper mapper = session.getMapper(SessionEntityMapper.class);
		int result = mapper.updateToken(userId, token);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int createSession(String userId, String token) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		SessionEntityMapper mapper = session.getMapper(SessionEntityMapper.class);
		int result = mapper.createSession(userId, token);
		session.commit();
		session.close();
		return result;
	}

}
