package ec.ups.est.pw.repaso.views;

import java.util.List;

import ec.ups.est.pw.repaso.bussines.GestionCiudad;
import ec.ups.est.pw.repaso.model.Ciudad;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("ciudades")
@RequestScoped
public class CiudadViews {
	@Inject
	private GestionCiudad gCiudades;
	
	private Ciudad ciudad = new Ciudad();
	
	private List<Ciudad> listado;

	public GestionCiudad getgCiudades() {
		return gCiudades;
	}

	public void setgCiudades(GestionCiudad gCiudades) {
		this.gCiudades = gCiudades;
	}

	public List<Ciudad> getListado() {
		return listado;
	}

	public void setListado(List<Ciudad> listado) {
		this.listado = listado;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	@PostConstruct
	public void init() {
		listado=gCiudades.getCiudades();
	}
	
	
	public String guardar() {
		System.out.println(this.ciudad);
		
		try {
			gCiudades.createCiudad(ciudad);
			return "listaCiudades?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

}
