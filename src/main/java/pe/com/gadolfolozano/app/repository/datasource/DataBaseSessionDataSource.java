package pe.com.gadolfolozano.app.repository.datasource;

import org.apache.ibatis.session.SqlSession;

import pe.com.gadolfolozano.app.UserSession;
import pe.com.gadolfolozano.app.UserSessionMapper;
import pe.com.gadolfolozano.app.repository.SessionRepository;
import pe.com.gadolfolozano.app.util.MyBatisUtil;

public class DataBaseSessionDataSource implements SessionRepository{

	@Override
	public UserSession getSession(String userId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		UserSessionMapper mapper = session.getMapper(UserSessionMapper.class);
		UserSession userSession = mapper.getUserSession(userId);
		session.close();
		return userSession;
	}

	@Override
	public int updateToken(String userId, String token) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		UserSessionMapper mapper = session.getMapper(UserSessionMapper.class);
		int result = mapper.updateToken(userId, token);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int createSession(String userId, String token) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		UserSessionMapper mapper = session.getMapper(UserSessionMapper.class);
		int result = mapper.createSession(userId, token);
		session.commit();
		session.close();
		return result;
	}

}
