package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity (name = "Billets")
@Table (name = "Billets")
public class Billet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_billet")
	private int id;
	
	@Column(name="prix")
	private float prix;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Vol_Billet", 
		joinColumns = { @JoinColumn(name = "id_billet") },
		inverseJoinColumns = { @JoinColumn(name = "id_vol") })
	private Set<Vol> vols;
	
	//ADD
	
	public void addVol(Vol vol) {
		this.vols.add(vol);
	}
	
	//CONSTRUCTEUR VIDE
	public Billet() {
		
	}
	
	//LES ACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Set<Vol> getVols() {
		return vols;
	}

	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}

}
