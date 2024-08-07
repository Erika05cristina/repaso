package ec.ups.est.pw.repaso.DAO;

import java.util.List;

import ec.ups.est.pw.repaso.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public Persona read(String codigo) {
		Persona persona = em.find(Persona.class, codigo);
		return persona;
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public void delete(String codigo) {
		Persona cliente = this.read(codigo);
		em.remove(cliente);
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);		
		return query.getResultList();
	}
	 
}
