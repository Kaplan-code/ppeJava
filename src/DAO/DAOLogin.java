package DAO;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

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

}
