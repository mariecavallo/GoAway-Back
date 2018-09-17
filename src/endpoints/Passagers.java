package endpoints;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PassagerDAO;
import model.Passager;



@Path("/passagers")
public class Passagers {
	
	// POST créé passager
	// UPDATE mise à jour passager
	// GET données passager
	
	//Post Passager
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Passager create (Passager passager) {
		return PassagerDAO.create(passager);
	}
	
	//GET Données Passager
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Passager> list (){
		return PassagerDAO.list().collect(Collectors.toSet());
	}
	
	//UPDATE Passager
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Passager update(Passager passager) {
		return PassagerDAO.modify(passager);
		
	}

}
