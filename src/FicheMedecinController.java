import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.DAOFicheMed;
import entities.Medecin;
import entities.RapportRdv;
import entities.Utilisateur;
import views.affichage;
import views.ficheMed;

public class FicheMedecinController implements ActionListener {
	ficheMed fenetre;
	DAOFicheMed daoficheMed;
	Utilisateur user;
	Medecin medecin;
	List<Medecin> medecins;
	RapportRdv rapport;
	
	public FicheMedecinController(ficheMed f, DAOFicheMed daoficheMed,Medecin medecin, Utilisateur user) {
		this.fenetre = f;
		this.daoficheMed = daoficheMed;
		this.medecin = medecin;
		this.user = user;
		
		
		
		init(medecin);
		
		fenetre.getBtnQuitter().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this); 
		
		
	}
	
	
	
	
	
	public void init(Medecin medecin) {
		fenetre.setVisible(true);
		
		fenetre.getTextNom().setText(medecin.getNom());
		fenetre.getTextPrenom().setText(medecin.getPrenom());
		fenetre.getTextVille().setText(medecin.getVille());
		fenetre.getTextNuméro().setText(medecin.getNumeroTel());
		fenetre.getTextAdresse().setText(medecin.getAdresse());
		fenetre.getTextCodePostal().setText(medecin.getCodePostal());
	}

	public void doLeave() {
		
		fenetre.dispose();
		
		
	}
	
	public void doValide() {
		Date champDate = fenetre.getDateChooser().getDate();
		if(champDate==null) {
			JFrame frame = new JFrame("showMessageDialog");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JOptionPane.showMessageDialog(frame,
		            "Date vide",
		            "Ressayez",
		            JOptionPane.ERROR_MESSAGE);
		    
		}
		else {
			/*
		System.out.println("choser : " + fenetre.getDateChooser().getDate());
		System.out.println("user : " + user);
		System.out.println("medecin : " + medecin);
        //System.out.println("dao : " + daoficheMed.addRdv(fenetre.getDateChooser().getDate(), user.getId(), medecin.getId()));
		//daoficheMed.addRdv(fenetre.getDateChooser().getDate(), user.getId(), medecin.getId());
		*/
		daoficheMed.addRdv2(fenetre.getDateChooser().getDate(), user, medecin);
		fenetre.dispose();
	}}

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

