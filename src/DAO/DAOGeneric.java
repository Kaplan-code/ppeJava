package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import entities.City;
import util.HibernateUtil;

public abstract class DAOGeneric<T > {
	
	protected Session session;
	protected Class<T> entityClass;
	
	public DAOGeneric(Session session, Class<T> entityClass) {
		super();
		this.session = session;
		this.entityClass = entityClass;
	}
	
	public T find(int id) {
		T entity = (T) session.get(entityClass, id);
		return entity;
	}
	
	public void saveOrUpdate(T entity) {
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
	}
	
    public void delete(T entity) {
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}
    
   public List<T> findAll(){
		
		List<T> value = session.createQuery("From "+ entityClass.getName()).list();
  
		return value;
	}
    
   public int count() {
		List<T> value = session.createQuery("From " +entityClass.getName()).list();
		  
		return value.size();
	}

}
