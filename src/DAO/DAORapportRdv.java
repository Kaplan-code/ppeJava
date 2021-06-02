package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;


import entities.Medecin;
import entities.RapportRdv;
import entities.Utilisateur;

public class DAORapportRdv extends DAOGeneric<RapportRdv> {

	public DAORapportRdv(Session session, Class<RapportRdv> entityClass) {
		super(session, RapportRdv.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<RapportRdv> findAll(){
		String SQL ="Select * FROM RapportRdv";
		SQLQuery query = session.createSQLQuery(SQL);
		query.addEntity(entityClass);
		
		List<RapportRdv> rapports = query.list();
		
		return rapports; 
	}
	
	public List<RapportRdv> findUser(Utilisateur id){
		String SQL ="Select * FROM RapportRdv WHERE utilisateurId=:id ";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setInteger("id", id.getId());
		query.addEntity(entityClass);
		
		List<RapportRdv> rapports = query.list();
		
		return rapports; 
	}
	
    public void delete(RapportRdv id){ 
		
		String SQL = "DELETE FROM RapportRdv WHERE id=:id";
		SQLQuery query = session.createSQLQuery(SQL);
		//query.addEntity(entityClass);
		query.setInteger("id", id.getId());
		
		
        session.beginTransaction();
        
		query.executeUpdate();
		
		session.getTransaction().commit();
	    
		

	}

}
