package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "Avions")
@Table (name = "Avions")
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avion")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="nombreSiege")
	private int nombreSiege;
	
	//CONSTRUCTEUR VIDE
	public Avion() {
		
	}

	//LES ACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNombreSiege() {
		return nombreSiege;
	}

	public void setNombreSiege(int nombreSiege) {
		this.nombreSiege = nombreSiege;
	}
	
	
	

}
