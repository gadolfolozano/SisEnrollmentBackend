package pe.com.gadolfolozano.app;

import org.apache.ibatis.session.SqlSession;

public class AlunoDao {

	public Aluno getAluno(String cpf) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		AlunoMapper mapper = session.getMapper(AlunoMapper.class);
		Aluno village = mapper.getAluno(cpf);
		session.close();
		return village;
	}
}
