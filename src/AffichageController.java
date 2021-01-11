import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import DAO.DAOAffichage;

import entities.Medecin;
import views.affichage;

public class AffichageController implements ActionListener {
	affichage fenetre;
	DAOAffichage daoaffichage;
    MyDefaultModel myDTM;
	int indexMedecin;
	Medecin medecin;
	List<Medecin> medecins;
    
	public AffichageController() {
	}
	
	public AffichageController(affichage f, DAOAffichage daoAffichage) {
		this.daoaffichage = daoAffichage;
		this.fenetre = f;
		
		init();
		
		
		fenetre.getBtnRecherche().addActionListener(this);
	}
	
	
	
    public void init() { 
		//indexMedecin = 0;
		
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

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String src = evt.getActionCommand();
		
		if(src =="Recherche") {
		   	doSearch();
			}
			
		}
	}


