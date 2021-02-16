package DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Medecin;
import entities.RapportRdv;

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

}
