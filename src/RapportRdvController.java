import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.transaction.SystemException;

import DAO.DAORapportRdv;
import entities.RapportRdv;
import entities.Utilisateur;
import model.MyDefaultModel;
import model.RdvModel;
import views.rapportRdv;

public class RapportRdvController implements ActionListener {
	rapportRdv fenetre;
	DAORapportRdv daoRapportRdv;
	RdvModel rdvmodel;
	public List<RapportRdv> rapports;
	Utilisateur user;
	
	public RapportRdvController() {
	}
	
	public RapportRdvController(rapportRdv f,DAORapportRdv daoRapportRdv, Utilisateur user) {
		this.daoRapportRdv = daoRapportRdv;
		this.fenetre = f;
		this.user = user;
		
		fenetre.getBtnQuitter().addActionListener(this);
		
		fenetre.getBtnSupprimer().addActionListener(this);
		init(user);
		
	}
	
	public void init(Utilisateur user) {
		
		if (user.getIdrole().getId()==1) {
			rapports = daoRapportRdv.findUser(user);
			rdvmodel = new RdvModel(rapports); 
			fenetre.getTable().setModel(rdvmodel);
			//System.out.println(user);
			fenetre.setVisible(true);
			fenetre.getBtnSupprimer().setVisible(false);
		} else {
			
		
			rapports = daoRapportRdv.findAll();
			
			rdvmodel = new RdvModel(rapports); 
			fenetre.getTable().setModel(rdvmodel);
			
			fenetre.setVisible(true);
	   }
		
	}
	
	public void doQuit() {
		
		fenetre.dispose();
	}
	
	private void doSupprimer() {
	
	
        
        int row = fenetre.getTable().getSelectedRow();
		//int column = 0;
		
		//int id = ((int) fenetre.getTable().getValueAt(row, column));
        
        if(fenetre.getTable().getSelectionModel().isSelectionEmpty()) {
			JFrame frame = new JFrame("showMessageDialog");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JOptionPane.showMessageDialog(frame,
		            "Aucune selection",
		            "Ressayez",
		            JOptionPane.ERROR_MESSAGE);
		    
		}
		else {
		
			RapportRdv rapport = rapports.get(row);
			
			daoRapportRdv.delete(rapport);
			
	        rapports = daoRapportRdv.findAll();
			
			rdvmodel = new RdvModel(rapports);
			fenetre.getTable().setModel(rdvmodel);
			
		

	  }
	}
	

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
        String src = evt.getActionCommand();
		
		if(src =="Quitter") {
		   	doQuit();
			}
		if(src =="Supprimer") {
			doSupprimer();
		}
	}
}
