package pe.com.gadolfolozano.app.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AuthUtilTest {
	@Test
	public void testGenerateToken() {
		assertNotNull("generateToken() should not return null", AuthUtil.generateToken("some_id"));
	}
}
