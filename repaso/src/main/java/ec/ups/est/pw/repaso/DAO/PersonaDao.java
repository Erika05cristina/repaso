package ec.ups.est.pw.repaso.DAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PersonaDao {

	@PersistenceContext
	private EntityManager em;
	
	
//	public void insert(Persona persona) {
//		em.persist(persona);
//	}
	
}
