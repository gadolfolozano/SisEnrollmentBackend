package pe.com.gadolfolozano.app.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Response;

import org.junit.Test;

import pe.com.gadolfolozano.app.rest.request.LoginRequest;

public class LoginTest {
	@Test
	public void testDoLoginNotFound() {
		Login loginWs = new Login();
		Response response = loginWs.doLogin(new LoginRequest());
		assertEquals("doLogin() empty request should return 404",
				Response.Status.NOT_FOUND.getStatusCode(),
				response.getStatus());
	}
	
	@Test
	public void testDoLoginSuccess() {
		Login loginWs = new Login();
		LoginRequest request = new LoginRequest();
		request.setCpf("70115020683");
		request.setPassword("7c4a8d09ca3762af61e59520943dc26494f8941b");
		Response response = loginWs.doLogin(request);
		assertEquals("doLogin() valid request should return 200",
				Response.Status.OK.getStatusCode(),
				response.getStatus());
	}
}
