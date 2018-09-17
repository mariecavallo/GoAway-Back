package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity (name = "Passagers")
@Table (name = "Passagers")
public class Passager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_passager")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="age")
	private int age;
	
	@OneToMany
	@JoinColumn (name = "id_passager")
	private Set<Billet> billets;
	
	
	
	// CONSTRUCTEUR VIDE
	
	public Passager() {
		
	}
	
	// ADD
	
	public void addBillet (Billet billet) {
		this.billets.add(billet);
	}
	
	// GETTERS ET SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Billet> getBillets() {
		return billets;
	}

	public void setBillets(Set<Billet> billets) {
		this.billets = billets;
	}
	
	
	
}
