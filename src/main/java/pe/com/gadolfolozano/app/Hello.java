package pe.com.gadolfolozano.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.getAluno("70115020683");
		return "Hello Jersey" + aluno.getNome();
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.getAluno("70115020683");

		return "<?xml version=\"1.0\"?>" + "<hello> Hello" + aluno.getNome() + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.getAluno("70115020683");

		return "<html> " + "<title>" + "Hello " + aluno.getNome() + "</title>" + "<body><h1>" + "Hello "
				+ aluno.getNome() + "</body></h1>" + "</html> ";
	}

}