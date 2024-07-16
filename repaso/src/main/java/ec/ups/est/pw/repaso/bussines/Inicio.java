package ec.ups.est.pw.repaso.bussines;

import java.util.List;

import ec.ups.est.pw.repaso.DAO.CiudadDAO;
import ec.ups.est.pw.repaso.DAO.PersonaDao;
import ec.ups.est.pw.repaso.model.Ciudad;
import ec.ups.est.pw.repaso.model.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private CiudadDAO daoCiudad;
	
	@Inject
	private PersonaDao daoPersona;
	
	@PostConstruct
	
	public void init() {
		
		Ciudad ciudad = new Ciudad();
		ciudad.setCi_id("0123456");
		ciudad.setCi_nombre("Cuenca");
		
		daoCiudad.insert(ciudad);
		
		List<Ciudad> listadoCiu =daoCiudad.getAll();
		for(Ciudad ciu: listadoCiu) {
			System.out.println(ciu.getCi_id()+ " "+ ciu.getCi_nombre());
			}
		
	
		//Personas
		Persona persona = new Persona();
		persona.setPer_id("0123456");
		persona.setPer_cedula("123456");
		persona.setPer_nombre("Erika");
		persona.setCiudad(ciudad);
		daoPersona.insert(persona);
		
		List<Persona> listadoP =daoPersona.getAll();
		for(Persona per: listadoP) {
			System.out.println(per.getPer_cedula()+ " "+ per.getPer_nombre() + " "+per.getCiudad());
			}
	}
	
	
	

}
