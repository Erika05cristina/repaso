package ec.ups.est.pw.repaso.bussines;

import java.util.List;

import ec.ups.est.pw.repaso.DAO.PersonaDao;
import ec.ups.est.pw.repaso.model.Ciudad;
import ec.ups.est.pw.repaso.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestioPersona {
	@Inject
	private PersonaDao daoPersona;
	
	
	public Persona getPersona(String codigo)throws Exception{
		Persona persona = daoPersona.read(codigo);
		if(persona == null)
			throw new Exception("Persona no existe");
		return persona;
	}
	
	public List<Persona> getPersonas(){
		return daoPersona.getAll();
	}
	
	public void createPersona(Persona persona) throws Exception {			
		daoPersona.insert(persona);
	}
	
	public void deleteCiudad(String codigo) throws Exception{
		Persona persona = daoPersona.read(codigo);
		if(persona == null) {				
			throw new Exception("Persona no existe");
		}
		else {
			daoPersona.delete(codigo);
		}
		
	}
	
	public void updateCiudad(Persona persona) throws Exception {
		Persona existingCiudad = daoPersona.read(persona.getPer_id());
        if (existingCiudad == null) {
            throw new Exception("Persona no existe");
        } else {
        	daoPersona.update(persona);
        }
    }
	

}
