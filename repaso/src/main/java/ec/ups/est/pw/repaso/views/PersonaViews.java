package ec.ups.est.pw.repaso.views;

import java.util.List;

import ec.ups.est.pw.repaso.bussines.GestioPersona;
import ec.ups.est.pw.repaso.model.Ciudad;
import ec.ups.est.pw.repaso.model.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("personas")
@RequestScoped
public class PersonaViews {

	@Inject 
	private GestioPersona gPersonas;
	
	private Persona persona = new Persona();
	
	private String id; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private List<Persona> listado;

	public GestioPersona getgPersonas() {
		return gPersonas;
	}

	public void setgPersonas(GestioPersona gPersonas) {
		this.gPersonas = gPersonas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getListado() {
		return listado;
	}

	public void setListado(List<Persona> listado) {
		this.listado = listado;
	}
	
	public String guardar() {
		System.out.println(this.persona);
		
		try {
			this.gPersonas.createPersona(persona);
			return "listaPersonas?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	public String eliminar() {
		try {
			this.gPersonas.deletePersona(id);
			return "listaPersonas?faces-redirect=true";			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	public String actualizar() {
		try {
			Persona personaActualizada = gPersonas.getPersona(id);
        personaActualizada.setPer_cedula(persona.getPer_cedula());
        personaActualizada.setPer_nombre(persona.getPer_nombre());
        personaActualizada.setCiudad(persona.getCiudad());
        gPersonas.updatePersona(personaActualizada);
        return "listaPersonas?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
	}
	
	public String verListado() {
		return "listaPersonas?faces-redirect=true";
	}
	
	public String regresar() {
		return "personas?faces-redirect=true";
	}
	
	@PostConstruct
	public void init() {
		listado=gPersonas.getPersonas();
		persona.setCiudad(new Ciudad());
	}
	
	
}
	
	
