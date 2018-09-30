package pe.com.gadolfolozano.app.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.com.gadolfolozano.app.model.SessionModel;
import pe.com.gadolfolozano.app.model.UserModel;
import pe.com.gadolfolozano.app.repository.SessionDataRepository;
import pe.com.gadolfolozano.app.repository.SessionRepository;
import pe.com.gadolfolozano.app.repository.UserDataRepository;
import pe.com.gadolfolozano.app.repository.UserRepository;
import pe.com.gadolfolozano.app.rest.request.LoginRequest;
import pe.com.gadolfolozano.app.rest.response.ErrorResponse;
import pe.com.gadolfolozano.app.rest.response.LoginResponse;
import pe.com.gadolfolozano.app.rest.response.UserResponse;
import pe.com.gadolfolozano.app.util.AuthUtil;
/**
 * Define o ws de login
 */
@Path("/login")
public class Login {

	/**
	 * Funcao login usa o metodo POST
	 * e recebe como body um objeto de tipo LoginRequest
	 */
	@POST
	public Response doLogin(LoginRequest loginRequest) {

		// UserRepository realiza o query na BD 
		// para obter o usuario com o email e password fornecidos
		UserRepository userRepository = new UserDataRepository();
		UserModel userModel = userRepository.getUser(loginRequest.getEmail(), loginRequest.getPassword());

		//Caso nao econtrar o usuario, retorna um erro
		if (userModel == null) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(ErrorResponse.getInvalidCredentialsError())
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		//Gera o token do usuario
		String token = AuthUtil.generateToken(userModel.getId());

		if (token == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(ErrorResponse.getGenericError())
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		//Salva o token do usuario na sessao
		SessionRepository sessionRepository = new SessionDataRepository();
		SessionModel sessionModel = sessionRepository.getSession(userModel.getId());

		int afectedRows;
		if (sessionModel != null) {
			afectedRows = sessionRepository.updateToken(userModel.getId(), token);
		} else {
			afectedRows = sessionRepository.createSession(userModel.getId(), token);
		}
		
		//Se ocorre um erro ao salvar a sessao, retorna um erro
		if (afectedRows == 0) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(ErrorResponse.getGenericError())
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		//Entrega o usuario logado com sucesso
		return Response.ok(getLoginSuccesResponse(userModel, token),
				MediaType.APPLICATION_JSON)
				.build();
	}

	private LoginResponse getLoginSuccesResponse(UserModel userModel, String token) {
		LoginResponse response = new LoginResponse();

		if (userModel != null) {
			UserResponse userResponse = new UserResponse();
			userResponse.setName(userModel.getName());
			userResponse.setCpf(userModel.getId());
			userResponse.setAddress(userModel.getAddress());
			userResponse.setState(userModel.getState());
			userResponse.setCity(userModel.getCity());
			userResponse.setPhone(userModel.getPhone());
			userResponse.setEmail(userModel.getEmail());

			response.setUser(userResponse);
		}

		response.setToken(token);

		return response;
	}

}
