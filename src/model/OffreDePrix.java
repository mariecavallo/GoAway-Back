package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="OffresDePrix")
@Table (name="OffresDePrix")
public class OffreDePrix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_offredeprix")
	private int id;
	
	@Column(name="prixEco")
	private float prixEco;
	
	@Column(name="prixAffaire")
	private float prixAffaire;
	
	@Column(name="prixPremium")
	private float prixPremium;
	
	//CONSTRUCTEUR VIDE
	public OffreDePrix() {
		
	}

	//LES ACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrixEco() {
		return prixEco;
	}

	public void setPrixEco(float prixEco) {
		this.prixEco = prixEco;
	}

	public float getPrixAffaire() {
		return prixAffaire;
	}

	public void setPrixAffaire(float prixAffaire) {
		this.prixAffaire = prixAffaire;
	}



	public float getPrixPremium() {
		return prixPremium;
	}

	public void setPrixPremium(float prixPremium) {
		this.prixPremium = prixPremium;
	}
	
	
	

}
