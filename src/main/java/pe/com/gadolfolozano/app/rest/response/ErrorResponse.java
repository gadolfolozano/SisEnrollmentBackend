package pe.com.gadolfolozano.app.rest.response;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse {
	private int errorCode;
	private String message;

	public ErrorResponse() {
		// Required
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	private static final String ERROR_MESSAGE_GENERIC = "An error occurred";
	private static final String ERROR_MESSAGE_INVALID_CREDENTIALS = "cpf or password were incorrect";
	
	
	public static ErrorResponse getInvalidCredentialsError() {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(Response.Status.NOT_FOUND.getStatusCode());
		error.setMessage(ERROR_MESSAGE_INVALID_CREDENTIALS);
		return error;
	}
	
	public static ErrorResponse getGenericError() {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		error.setMessage(ERROR_MESSAGE_GENERIC);
		return error;
	}

}
