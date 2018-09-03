package pe.com.gadolfolozano.app.database.mybatismapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import pe.com.gadolfolozano.app.database.entity.AlunoEntity;

public interface AlunoEntityMapper {
	
	@Results({
        @Result(property = "cpf", column = "cpf"),
        @Result(property = "nome", column = "nome_aluno")
      })
	@Select("SELECT cpf, nome_aluno from Aluno WHERE cpf = #{cpf}")
	AlunoEntity getAluno(String cpf);

	@Results({
        @Result(property = "cpf", column = "cpf"),
        @Result(property = "nome", column = "nome_aluno")
      })
	@Select("SELECT cpf, nome_aluno from Aluno WHERE cpf = #{cpf} and senha = #{password}")
	AlunoEntity getAlunoByCpfAndPassword(@Param("cpf") String cpf, @Param("password") String password);
	
}
