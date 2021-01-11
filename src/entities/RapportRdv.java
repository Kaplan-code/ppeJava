package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the RapportRdv database table.
 * 
 */
@Entity
@Table(name="RapportRdv")
@NamedQuery(name="RapportRdv.findAll", query="SELECT r FROM RapportRdv r")
public class RapportRdv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private int medecinId;

	private int utilisateurId;

	public RapportRdv() {
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMedecinId() {
		return this.medecinId;
	}

	public void setMedecinId(int medecinId) {
		this.medecinId = medecinId;
	}

	public int getUtilisateurId() {
		return this.utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

}