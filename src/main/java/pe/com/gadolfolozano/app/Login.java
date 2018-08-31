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
    public User getJSON() {
		User user = new User();
		user.setCpf("12331311");
		user.setName("Gustavo Adolfo Lozano Mendez");
        return user;
    }
	
}
