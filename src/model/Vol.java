package model;


import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name="Vols")
@Table (name="Vols")
public class Vol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_vol")
	private int id;
	
	@Column(name="heureDepart")
	private Time heureDepart;
	
	@Column(name="heureArrivee")
	private Time heureArrivee;
	
	@Column(name="codeIATA_depart")
	private String codeIATA_depart;
	
	@Column(name="codeIATA_arrivee")
	private String codeIATA_arrivee;
	
	@ManyToOne
	@JoinColumn(name="id_avion")
	private Avion avion;
	
	@OneToOne
    @JoinColumn(name = "id_offredeprix")
    private OffreDePrix offreDePrix;
	
	//ConstructeurVide
	public Vol() {
		
	}

	
	//LESACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Time getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public String getCodeIATA_depart() {
		return codeIATA_depart;
	}

	public void setCodeIATA_depart(String codeIATA_depart) {
		this.codeIATA_depart = codeIATA_depart;
	}

	public String getCodeIATA_arrivee() {
		return codeIATA_arrivee;
	}

	public void setCodeIATA_arrivee(String codeIATA_arrivee) {
		this.codeIATA_arrivee = codeIATA_arrivee;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public OffreDePrix getOffreDePrix() {
		return offreDePrix;
	}

	public void setOffreDePrix(OffreDePrix offreDePrix) {
		this.offreDePrix = offreDePrix;
	}
	
	
	

}
