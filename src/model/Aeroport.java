package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity (name = "Aeroports")
@Table (name = "Aeroports")
public class Aeroport {
	
	@Id
	@Column(name="codeIATA")
	private String codeIATA;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="pays")
	private String pays;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn (name = "codeIATA_depart")
	private Set<Vol> volsDepart;
	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn (name = "codeIATA_arrivee")
	private Set<Vol> volsArrivee;
	
	//CONSTRUCTEUR VIDE
	public Aeroport() {
		this.volsArrivee= new HashSet<>();
		this.volsDepart=new HashSet<>();
	}
	
	// ADD
	public void addVolArrivee(Vol vol) {
		volsArrivee.add(vol);
	}
	public void addVolDepart(Vol vol) {
		volsDepart.add(vol);
	}
	
	//LES ACCESSEURS

	public String getCodeIATA() {
		return codeIATA;
	}

	public void setCodeIATA(String codeIATA) {
		this.codeIATA = codeIATA;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	public Set<Vol> getVolsDepart() {
		return volsDepart;
	}

	public void setVolsDepart(Set<Vol> volsDepart) {
		this.volsDepart = volsDepart;
	}

	public Set<Vol> getVolsArrivee() {
		return volsArrivee;
	}

	public void setVolsArrivee(Set<Vol> volsArrivee) {
		this.volsArrivee = volsArrivee;
	}
	
}
