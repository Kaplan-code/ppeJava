package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Role database table.
 * 
 */
@Entity
@Table(name="Role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="libelle")
	private String libelle;

	@Column(name="permission")
	private Integer permission;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPermission() {
		return this.permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

}