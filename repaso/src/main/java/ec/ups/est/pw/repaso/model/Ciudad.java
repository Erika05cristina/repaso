package ec.ups.est.pw.repaso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_ciudad")
public class Ciudad {
	
	@Id
	private int ci_id;
	@Column(name="ci_nombre")
	private String ci_nombre;
	
	public int getCi_id() {
		return ci_id;
	}
	public void setCi_id(int ci_id) {
		this.ci_id = ci_id;
	}
	public String getCi_nombre() {
		return ci_nombre;
	}
	public void setCi_nombre(String ci_nombre) {
		this.ci_nombre = ci_nombre;
	}

}
