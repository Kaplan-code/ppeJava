import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.DAOAffichage;
import DAO.DAOFicheMed;
import DAO.DAOLogin;
import DAO.DAORapportRdv;
import entities.Medecin;
import entities.RapportRdv;
import entities.Role;
import entities.Utilisateur;
import model.MyDefaultModel;
import util.HibernateUtil;
import views.affichage;
import views.connexion;
import views.ficheMed;
import views.rapportRdv;

public class AffichageController implements ActionListener {
	affichage fenetre;
	ficheMed fenetre2;
	DAOAffichage daoaffichage;
    MyDefaultModel myDTM;
	Medecin medecin;
	List<Medecin> medecins;
	Utilisateur user;
    
	public AffichageController() {
	}
	
	public AffichageController(affichage f, DAOAffichage daoAffichage, Utilisateur user) {
		this.daoaffichage = daoAffichage;
		this.fenetre = f;
		this.user = user; 
	
		
		init();
		
		fenetre.getBtnRecherche().addActionListener(this);
      	fenetre.getBtnDeconnexion().addActionListener(this);
		fenetre.getBtnAfificherRdv().addActionListener(this);
		
		fenetre.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent evt) { 
				
				
				if (!evt.getValueIsAdjusting()) {  //This line prevents double events
					 if (fenetre.getTable().getSelectedRow() > -1) {
						int selectedRow = fenetre.getTable().getSelectedRow();
						Medecin m = medecins.get(selectedRow);
						
				        TroisiemeFenetre(m,user);
				        
					 }
				}
			}
		});
	}
	
	
    public void init() { 
    
    	
    	fenetre.getLblNom().setText(user.getNom());
    	fenetre.getLblRole().setText(user.getIdrole().getLibelle());
		
		medecins = daoaffichage.findAll(); 
		
	
		myDTM = new MyDefaultModel(medecins);
		fenetre.getTable().setModel(myDTM);
		
		fenetre.setVisible(true);
		
	}
    public void doSearch() {
    
    	
    	medecins = daoaffichage.findCountriesStartingWith(fenetre.getTextVilleMed().getText());
    	
    	myDTM = new MyDefaultModel(medecins);
		fenetre.getTable().setModel(myDTM);
    }
    
    public void doDeconect() {
    	
    	fenetre.dispose();
    	
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		try {
			new LoginController(new connexion(), new DAOLogin(session, Utilisateur.class));
		} catch (HibernateException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void doAffiche(Utilisateur user) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		try {
			new RapportRdvController(new rapportRdv(), new DAORapportRdv(session, RapportRdv.class),user);
		} catch (HibernateException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void TroisiemeFenetre(Medecin medecin, Utilisateur user) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		try {
			new FicheMedecinController(new ficheMed(), new DAOFicheMed(session, Medecin.class),medecin, user);
		} catch (HibernateException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String src = evt.getActionCommand();
		
		if(src =="Recherche") {
		   	doSearch();
			}
		if(src =="Déconnexion") {
			doDeconect();
		}
		if(src =="Afficher") {
			doAffiche(user);
		}

	}
}


