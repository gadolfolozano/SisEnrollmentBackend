package pe.com.gadolfolozano.app.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class AuthUtil {
	private AuthUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String generateToken(String id) {
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
