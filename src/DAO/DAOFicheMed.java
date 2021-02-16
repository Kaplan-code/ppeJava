package DAO;

import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Medecin;
import entities.RapportRdv;
import entities.Utilisateur;
import util.HibernateUtil;

public class DAOFicheMed extends DAOGeneric<Medecin> {

	public DAOFicheMed(Session session, Class<Medecin> entityClass) {
		super(session, Medecin.class);
		// TODO Auto-generated constructor stub
	}
	
	/*
	public RapportRdv addRdv(Date date, Integer utilisateurId, Integer medecinId ) {
		
		    
			String SQL = "INSERT INTO RapportRdv(date, utilisateurId, medecinId) VALUES (date=:date, utilisateurId=:utilisateurId, medecinId=:medecinId) ";
		    //String SQL = "INSERT INTO RapportRdv(date,utilisateurId,medecinId) VALUES (id ,date, utilisateurId, medecinId) ";
			
			SQLQuery query = session.createSQLQuery(SQL);
			//query.setInteger("id", id);
			query.setDate("date", date);
			query.setInteger("utilisateurId",utilisateurId);
			query.setInteger("medecinId",medecinId);
			query.addEntity(entityClass);
			RapportRdv conect = (RapportRdv) query.uniqueResult();
				
			return conect; 
			
	}
	*/
	/*
	 * Ajout d'un nouveau rendez-vous
	 */
	public void addRdv2(Date date, Utilisateur utilisateurId, Medecin medecinId ) { 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RapportRdv m = new RapportRdv();
		m.setDate(date);
		m.setMedecinId(medecinId);
		m.setUtilisateurId(utilisateurId);
		session.save(m);
		
		session.getTransaction().commit();
	     
		
	}
}
