package ec.ups.est.pw.repaso.model;

import jakarta.inject.Named;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_persona")
public class Persona {
	
	@Id
	private String per_id;
	@Column(name="per_cedula")
	private String per_cedula;
	@Column(name="per_nombre")
	private String per_nombre;
	
	@ManyToOne
	@JoinColumn(name="fk_Ciudad")
	private Ciudad ciudad;
	
	public String getPer_id() {
		return per_id;
	}
	public void setPer_id(String per_id) {
		this.per_id = per_id;
	}
	public String getPer_cedula() {
		return per_cedula;
	}
	public void setPer_cedula(String per_cedula) {
		this.per_cedula = per_cedula;
	}
	public String getPer_nombre() {
		return per_nombre;
	}
	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
}
