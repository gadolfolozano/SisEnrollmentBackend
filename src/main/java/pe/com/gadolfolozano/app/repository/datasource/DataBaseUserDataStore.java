package pe.com.gadolfolozano.app.repository.datasource;

import org.apache.ibatis.session.SqlSession;

import pe.com.gadolfolozano.app.database.entity.AlunoEntity;
import pe.com.gadolfolozano.app.database.MyBatisUtil;
import pe.com.gadolfolozano.app.database.mybatismapper.AlunoEntityMapper;
import pe.com.gadolfolozano.app.mapper.UserMapper;
import pe.com.gadolfolozano.app.model.UserModel;
import pe.com.gadolfolozano.app.repository.UserRepository;

public class DataBaseUserDataStore implements UserRepository{
	
	UserMapper userMapper;
	
	public DataBaseUserDataStore() {
		super();
		userMapper = new UserMapper();
	}

	@Override
	public UserModel getUser(String email, String password) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		AlunoEntityMapper mapper = session.getMapper(AlunoEntityMapper.class);
		AlunoEntity aluno = mapper.getAlunoByEmailAndPassword(email, password);
		session.close();
		return userMapper.toModel(aluno);
	}

}
