package entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;


/**
 * The persistent class for the Medecin database table.
 * 
 */
@Entity
@Table(name="Medecin")
@NamedQuery(name="Medecin.findAll", query="SELECT m FROM Medecin m")
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;

	private String adresse;

	private String codePostal;

	//private byte disponibilite;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
	private Integer id;

	private String nom;

	private String numeroTel;

	private String prenom; 

	private String ville;

	public Medecin() {
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/*
	public byte getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(byte disponibilite) {
		this.disponibilite = disponibilite;
	}
	*/

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroTel() {
		return this.numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}