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
	
	@PostConstruct
	public void init() {
		listado=gPersonas.getPersonas();
		persona.setCiudad(new Ciudad());
	}
	
	public String guardar() {
		System.out.println(this.persona);
		
		try {
			gPersonas.createPersona(persona);
			return "listaPersonas?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

}
	
	
