import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.DAOAffichage;
import DAO.DAOLogin;
import entities.Medecin;
import entities.Utilisateur;
import util.HibernateUtil;
import util.TestConnection;
import views.affichage;
import views.connexion;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		try {
			new UserController(new connexion(), new DAOLogin(session, Utilisateur.class));
		} catch (HibernateException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
