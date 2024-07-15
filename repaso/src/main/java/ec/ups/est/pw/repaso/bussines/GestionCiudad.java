package ec.ups.est.pw.repaso.bussines;

import ec.ups.est.pw.repaso.DAO.CiudadDAO;
import ec.ups.est.pw.repaso.model.Ciudad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCiudad {
	@Inject
	private CiudadDAO daociudad;
	
	
	public Ciudad getCiudad(String codigo)throws Exception{
		Ciudad ciudad = daociudad.read(codigo);
		if(ciudad == null)
			throw new Exception("ciudad no existe");
		return ciudad;
	}
	
	public void createCiudad(Ciudad ciudad) throws Exception {			
		daociudad.insert(ciudad);
	}
	
	public void deleteCiudad(String codigo) throws Exception{
		Ciudad cliente = daociudad.read(codigo);
		if(cliente == null) {				
			throw new Exception("codigo no existe");
		}
		else {
			daociudad.delete(codigo);
		}
		
	}
	
	public void updateCiudad(Ciudad ciudad) throws Exception {
		Ciudad existingCiudad = daociudad.read(ciudad.getCi_id());
        if (existingCiudad == null) {
            throw new Exception("codigo no existe");
        } else {
        	daociudad.update(ciudad);
        }
    }
	
	
}
