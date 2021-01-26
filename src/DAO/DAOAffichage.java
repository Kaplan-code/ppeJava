package DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Medecin;
import entities.Role;

public class DAOAffichage extends DAOGeneric<Medecin> {

	public DAOAffichage(Session session, Class<Medecin> entityClass) {
		super(session, Medecin.class);
		// TODO Auto-generated constructor stub
		
	}
	
	public List<Medecin> findAll(){
		String SQL ="Select * FROM Medecin";
		SQLQuery query = session.createSQLQuery(SQL);
		query.addEntity(entityClass);
		
		List<Medecin> medecins = query.list();
		
		return medecins; 
	}
	
    public List<Medecin> findCountriesStartingWith(String c) {

		String SQL = "SELECT * FROM Medecin WHERE ville LIKE :name";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("name", c+"%");
		query.addEntity(entityClass);
		List<Medecin> medecins = query.list();
		
		return medecins;
	}

    /*
   public Role getUserRole(String id) {
		//Integer conect = null;
		String SQL = "SELECT * FROM Role WHERE id=:id ";
		
		
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("id", id);
		query.addEntity(entityClass);
		Role conect =  (Role) query.uniqueResult();
		
		return conect;
}
*/

}


