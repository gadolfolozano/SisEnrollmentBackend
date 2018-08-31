package pe.com.gadolfolozano.app;

public class RunMyBatis {
	public static void main(String[] args) {
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.getAluno("70115020683");

		System.out.println("id:" + aluno.getCpf() + ", Name:" + aluno.getNome());
	}
}
