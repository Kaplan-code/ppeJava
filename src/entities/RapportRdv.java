package entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;

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
	@Column(name="date")
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	// bi-directional may-to-one association to Role
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="medecinId", referencedColumnName="id")
	private Medecin medecinId;
	
	// bi-directional may-to-one association to Role
	@ManyToOne ( cascade = CascadeType.ALL )
	@JoinColumn(name="utilisateurId", referencedColumnName="id")
	private Utilisateur utilisateurId;

	public RapportRdv() { 
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medecin getMedecinId() {
		return this.medecinId;
	}

	public void setMedecinId(Medecin medecinId) {
		this.medecinId = medecinId;
	}

	public Utilisateur getUtilisateurId() {
		return this.utilisateurId;
	}

	public void setUtilisateurId(Utilisateur utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

}