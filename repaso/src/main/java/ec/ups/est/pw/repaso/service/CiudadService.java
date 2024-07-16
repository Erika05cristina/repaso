package ec.ups.est.pw.repaso.service;


import java.util.List;

import ec.ups.est.pw.repaso.bussines.GestionCiudad;
import ec.ups.est.pw.repaso.model.Ciudad;
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

@Path("/ciudades")
public class CiudadService {
	/***
	    * Solicitudes ejemplo
		* POST repaso/rs/ciudades/
		* PUT repaso/rs/ciudades/
		* DELETE repaso/rs/ciudades/?02120
		* GET repaso/rs/ciudades/
		* GET repaso/rs/ciudades/0103870
		*/
	
	@Inject
	private GestionCiudad gCiudad;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create (Ciudad ciudad) {
		try {
			gCiudad.createCiudad(ciudad);
			return Response.ok(ciudad).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR,"Error bd")).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Ciudad ciudad) {
	    try {
	    	gCiudad.updateCiudad(ciudad);
	        return Response.ok(ciudad).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
	    }
	}
	
	
	@DELETE
	public Response delete(@QueryParam("id") String codigo) {
		try {
			gCiudad.deleteCiudad(codigo);
			return Response.ok(codigo).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Path("/{codigo}")
	public Ciudad get(String codigo) {
		Ciudad cliente;
		try {
			cliente = gCiudad.getCiudad(codigo);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Ciudad> list(){
		List<Ciudad> clientes = gCiudad.getCiudades();
		return clientes;
	}
	
	
	
}
