package pe.com.gadolfolozano.app;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AlunoMapper {
	@Results({
        @Result(property = "cpf", column = "cpf"),
        @Result(property = "nome", column = "nome_aluno")
      })
	@Select("SELECT cpf, nome_aluno from Aluno WHERE cpf = #{cpf}")
	Aluno getAluno(String cpf);
}
