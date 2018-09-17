package endpoints;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;

import model.Response;
import dao.PassagerDAO;
import dao.VolDAO;
import model.OffreDePrix;
import model.Passager;
import model.Vol;

@Path("/vols")
public class Vols {
	

	// GET -- Liste de tous les vols
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		Set<Vol> data = VolDAO.list().collect(Collectors.toSet());
		return new Response(200,data);
	}
	
	// GET -- Vol by ID
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response findByID(@PathParam("id") int id_vol) {
		Optional<Vol> data = VolDAO.list()
				.filter(v -> v.getId() == id_vol)
				.findFirst();
		if (data.isPresent()) {
			return new Response(200,data.get());
		}
		return new Response(200,"Empty");
		
	}
	
	// GET -- Vol by départ et arrivée
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/from/{codeIATA_depart}/to/{codeIATA_arrivee}")
	public Response findAller	(@PathParam("codeIATA_depart") String depart,
								 @PathParam("codeIATA_arrivee") String arrivee){
		Set<Vol> data = VolDAO.list().filter(v -> v.getCodeIATA_depart().equals(depart) && v.getCodeIATA_arrivee().equals(arrivee)).collect(Collectors.toSet());
		if(!data.isEmpty()) {
			return new Response(200,data);
		}
		return new Response(200,"Empty");
	}
	
	
	
	// GET --  Offre de prix pour un vol
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/offreDePrix")
	public Response findOffre(@PathParam("id") int id_vol) {
		Optional<Vol> data = VolDAO.list()
				.filter(v -> v.getId() == id_vol)
				.findFirst();
		if (data.isPresent()) {
			return new Response(200,data.get().getOffreDePrix());
		}
		return new Response(200,"Empty");		
	}
	
	// POST -- Ajout nouveau vol à la BdD
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vol create (Vol vol) {
		return VolDAO.create(vol);
	}
	
}


/*

}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Todo create (Todo t) {
		return TodoDAO.create(t);
	}

} */
