package pe.com.gadolfolozano.app.repository.datasource;

import org.apache.ibatis.session.SqlSession;

import pe.com.gadolfolozano.app.Aluno;
import pe.com.gadolfolozano.app.AlunoMapper;
import pe.com.gadolfolozano.app.repository.UserRepository;
import pe.com.gadolfolozano.app.util.MyBatisUtil;

public class DataBaseUserDataStore implements UserRepository{

	@Override
	public Aluno getUser(String id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		AlunoMapper mapper = session.getMapper(AlunoMapper.class);
		Aluno user = mapper.getAluno(id);
		session.close();
		return user;
	}

	@Override
	public Aluno getUser(String cpf, String password) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		AlunoMapper mapper = session.getMapper(AlunoMapper.class);
		Aluno aluno = mapper.getAlunoByCpfAndPassword(cpf, password);
		session.close();
		return aluno;
	}

}
