package DAO;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Medecin;
import entities.RapportRdv;
import entities.Utilisateur;

public class DAOLogin extends DAOGeneric<Utilisateur> {

	public DAOLogin(Session session, Class<Utilisateur> entityClass) {
		super(session, Utilisateur.class);
		// TODO Auto-generated constructor stub
	}
	/// sha2 512
	public String getUserlog(String log, String mdp) {
		String conect = null;
		String SQL = "SELECT password FROM Utilisateur WHERE login=:log and password=:mdp";
		
		
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("log", log);
		query.setString("mdp",mdp);
		conect =  (String) query.uniqueResult();
		
		return conect;
	}
	/**
	 * 
	 * @param log
	 * @param mdp
	 * @return
	 */
	public Utilisateur getUser(String log, String mdp) {
		
		String SQL = "SELECT* FROM Utilisateur WHERE login=:log and password=:mdp";
		
		
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("log", log);
		query.setString("mdp",mdp);
		query.addEntity(entityClass);
		Utilisateur conect = (Utilisateur) query.uniqueResult();
		
		return conect;
		
	}
	
	public List<Utilisateur> findAllUser(){
		String SQL ="Select * FROM Utilisateur";
		SQLQuery query = session.createSQLQuery(SQL);
		query.addEntity(entityClass);
		
		List<Utilisateur> users = query.list();
		
		return users; 
	}
	
	public Integer countMedecin(Integer utilisateurId) {
		String SQL = "SELECT COUNT(medecinId) FROM RapportRdv WHERE utilisateurId =: utilisateurId";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setInteger("utilisateurId", utilisateurId);
		
		Integer count = (Integer)query.uniqueResult();
		
		return count;
	
		
	}
	

}
