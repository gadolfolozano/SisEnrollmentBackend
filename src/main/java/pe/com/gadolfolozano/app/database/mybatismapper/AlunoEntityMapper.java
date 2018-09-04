package pe.com.gadolfolozano.app.database.mybatismapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import pe.com.gadolfolozano.app.database.entity.AlunoEntity;

public interface AlunoEntityMapper {
	
	@Results({
		@Result(property = "cpf", column = "cpf"),
        @Result(property = "nome", column = "nome_aluno"),
        @Result(property = "endereco", column = "endereco"),
        @Result(property = "estado", column = "estado"),
        @Result(property = "municipio", column = "municipio"),
        @Result(property = "telefone", column = "telefone"),
        @Result(property = "email", column = "email")
      })
	@Select("SELECT cpf, nome_aluno, endereco, estado, municipio, telefone, email "
			+ "from Aluno WHERE cpf = #{cpf}")
	AlunoEntity getAluno(String cpf);

	@Results({
        @Result(property = "cpf", column = "cpf"),
        @Result(property = "nome", column = "nome_aluno"),
        @Result(property = "endereco", column = "endereco"),
        @Result(property = "estado", column = "estado"),
        @Result(property = "municipio", column = "municipio"),
        @Result(property = "telefone", column = "telefone"),
        @Result(property = "email", column = "email")
      })
	@Select("SELECT cpf, nome_aluno, endereco, estado, municipio, telefone, email "
			+ "from Aluno WHERE cpf = #{cpf} and senha = #{password}")
	AlunoEntity getAlunoByCpfAndPassword(@Param("cpf") String cpf, @Param("password") String password);
	
}
