package ec.ups.est.pw.repaso.DAO;

import ec.ups.est.pw.repaso.model.Ciudad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CiudadDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Ciudad ciudad) {
		em.persist(ciudad);
	}
	            
}
