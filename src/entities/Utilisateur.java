package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Utilisateur database table.
 * 
 */
@Entity
@Table(name="Utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	// bi-directional may-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idrole", referencedColumnName="id")
	private Role idrole;

	@Column(name="login")
	private String login;

	@Column(name="nom")
	private String nom;

	@Column(name="numeroTel")
	private String numeroTel;

	@Column(name="password")
	private String password;

	@Column(name="prenom")
	private String prenom;

	public Utilisateur() {
	}

	public int getId() { 
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  Role getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Role idrole) {
		this.idrole = idrole;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}