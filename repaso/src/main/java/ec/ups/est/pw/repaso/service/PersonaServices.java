package ec.ups.est.pw.repaso.service;

import java.util.List;

import ec.ups.est.pw.repaso.bussines.GestioPersona;
import ec.ups.est.pw.repaso.model.Persona;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class PersonaServices {

	@Inject
	private GestioPersona gPersona;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create (Persona persona) {
		try {
			gPersona.createPersona(persona);
			return Response.ok(persona).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR,"Error bd")).build();
		}
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Persona persona) {
	    try {
	    	gPersona.updatePersona(persona);
	        return Response.ok(persona).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
	    }
	}
	
	
	@DELETE
	public Response delete(@QueryParam("id") String cedula) {
		try {
			gPersona.deletePersona(cedula);
			return Response.ok(cedula).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Path("/{codigo}")
	public Persona get(String cedula) {
		Persona cliente;
		try {
			cliente = gPersona.getPersona(cedula);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Persona> list(){
		List<Persona> clientes = gPersona.getPersonas();
		return clientes;
	}
	
	
	
	
}
