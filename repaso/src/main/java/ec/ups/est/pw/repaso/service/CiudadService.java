package ec.ups.est.pw.repaso.service;

import java.util.List;


import ec.ups.est.pw.repaso.bussines.GestionCiudad;
import ec.ups.est.pw.repaso.model.Ciudad;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ciudad")
public class CiudadService {
	
	@Inject
	private GestionCiudad gCiudad;
	
	@Inject
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create (Ciudad ciudad) {
		try {
			gCiudad.createCiudad(ciudad);
			return Response.ok(ciudad).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
			
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
	public Response delete(@QueryParam("id") String cedula) {
		try {
			gCiudad.deleteCiudad(cedula);
			return Response.ok(cedula).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Path("/{cedula}")
	public Ciudad get(String cedula) {
		Ciudad ciudad;
		try {
			ciudad = gCiudad.getCiudad(cedula);
			return ciudad;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Ciudad> list(){
		List<Ciudad> ciudades = gCiudad.getCiudad();
		return ciudades;S
	}

}
