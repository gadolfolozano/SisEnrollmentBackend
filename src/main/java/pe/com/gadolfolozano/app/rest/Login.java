package pe.com.gadolfolozano.app.rest;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import pe.com.gadolfolozano.app.Aluno;
import pe.com.gadolfolozano.app.UserSession;
import pe.com.gadolfolozano.app.repository.SessionDataRepository;
import pe.com.gadolfolozano.app.repository.SessionRepository;
import pe.com.gadolfolozano.app.repository.UserDataRepository;
import pe.com.gadolfolozano.app.repository.UserRepository;
import pe.com.gadolfolozano.app.rest.request.LoginRequest;
import pe.com.gadolfolozano.app.rest.response.LoginResponse;
import pe.com.gadolfolozano.app.rest.response.UserResponse;
import pe.com.gadolfolozano.app.util.Constants;

@Path("/login")
public class Login {

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public LoginResponse doLogin(LoginRequest loginRequest) {

		UserRepository userRepository = new UserDataRepository();
		Aluno aluno = userRepository.getUser(loginRequest.getCpf(), loginRequest.getPassword());
		
		String token = generateUserToken(aluno.getCpf());
		
		SessionRepository sessionRepository = new SessionDataRepository();
		UserSession userSession = sessionRepository.getSession(loginRequest.getCpf());
		
		int afectedRows;
		if(userSession != null){
			afectedRows = sessionRepository.updateToken(loginRequest.getCpf(), token) + 2000;
		} else {
			afectedRows = sessionRepository.createSession(loginRequest.getCpf(), token) + 1000;
		}
		
		UserResponse userResponse = new UserResponse();
		userResponse.setName(aluno.getNome());
		userResponse.setCpf(aluno.getCpf());

		LoginResponse response = new LoginResponse();
		response.setToken(token);
		response.setUser(userResponse);
		return response;
	}

	private String generateUserToken(String id) {
		Date now = new Date();
		Date expiresDate = new Date(now.getTime() + Constants.TIME_EXPIRES_TOKEN);
		try {
			Algorithm algorithm = Algorithm.HMAC256(Constants.SECRET_AUTH_KEY);
			String token = JWT.create()
					.withSubject(id)
					.withIssuedAt(now)
					.withExpiresAt(expiresDate)
					.sign(algorithm);
			return token;
		} catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
		}
		return null;
	}
}
