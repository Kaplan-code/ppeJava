import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DAO.DAOFicheMed;
import entities.Medecin;
import views.affichage;
import views.ficheMed;

public class FicheMedecinController implements ActionListener {
	ficheMed fenetre;
	DAOFicheMed daoficheMed;
	
	Medecin medecin;
	List<Medecin> medecins;
	
	public FicheMedecinController(ficheMed f, DAOFicheMed daoficheMed,Medecin m) {
		this.fenetre = f;
		this.daoficheMed = daoficheMed;
		this.medecin = m;
		
		init(m);
		
		fenetre.getBtnQuitter().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this);
		
	}
	
	
	
	
	
	public void init(Medecin m) {
		fenetre.setVisible(true);
		
		fenetre.getTextNom().setText(m.getNom());
		fenetre.getTextPrenom().setText(m.getPrenom());
		fenetre.getTextVille().setText(m.getVille());
		fenetre.getTextNuméro().setText(m.getNumeroTel());
		fenetre.getTextAdresse().setText(m.getAdresse());
		fenetre.getTextCodePostal().setText(m.getCodePostal());
	}

	public void doLeave() {
		fenetre.dispose();
		
	}
	
	public void doValide() {
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String src = evt.getActionCommand();
		if(src =="Quitter") {
		   	doLeave();
			}
		if(src =="Valider") {
			doValide();
		}
	}

}

