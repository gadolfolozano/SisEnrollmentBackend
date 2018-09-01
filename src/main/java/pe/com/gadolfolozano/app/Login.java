package pe.com.gadolfolozano.app;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class Login {
	
	@POST
    @Produces({MediaType.APPLICATION_JSON})
    public LoginResponse doLogin(User user) {

		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.getAlunoByCpfAndPassword(user.getCpf(), user.getPassword());
		
		User userResponse = new User();
		userResponse.setName(aluno.getNome());
		userResponse.setCpf(aluno.getCpf());
		
		LoginResponse response = new LoginResponse();
		response.setToken("12331311");
		response.setUser(userResponse);
        return response;
    }
	
}
