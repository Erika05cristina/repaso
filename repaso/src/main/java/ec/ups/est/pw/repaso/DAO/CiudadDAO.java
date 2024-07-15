package ec.ups.est.pw.repaso.DAO;

import java.util.List;

import ec.ups.est.pw.repaso.model.Ciudad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CiudadDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Ciudad ciudad) {
		em.persist(ciudad);
	}
	public Ciudad read(String cedula) {
		Ciudad cliente = em.find(Ciudad.class, cedula);
		return cliente;
	}
	
	public void update(Ciudad Ciudad) {
		em.merge(Ciudad);
	}
	
	public void delete(String codigo) {
		Ciudad cliente = this.read(codigo);
		em.remove(cliente);
	}
	
	public List<Ciudad> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query query = em.createQuery(jpql, Ciudad.class);		
		return query.getResultList();
	}
	            
}
