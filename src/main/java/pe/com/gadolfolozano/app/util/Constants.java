package pe.com.gadolfolozano.app.util;

public class Constants {
	
	private Constants() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String SECRET_AUTH_KEY = "verySecretAuthKey";
	public static final long TIME_EXPIRES_TOKEN = 2 * 60 * 1000; // 2 minutes

}
