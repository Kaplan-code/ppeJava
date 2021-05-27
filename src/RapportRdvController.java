import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import DAO.DAORapportRdv;
import entities.RapportRdv;
import model.MyDefaultModel;
import model.RdvModel;
import views.rapportRdv;

public class RapportRdvController implements ActionListener {
	rapportRdv fenetre;
	DAORapportRdv daoRapportRdv;
	RdvModel rdvmodel;
	public List<RapportRdv> rapports;
	
	public RapportRdvController() {
	}
	
	public RapportRdvController(rapportRdv f,DAORapportRdv daoRapportRdv) {
		this.daoRapportRdv = daoRapportRdv;
		this.fenetre = f;
		
		fenetre.getBtnQuitter().addActionListener(this);
		
		fenetre.getBtnSupprimer().addActionListener(this);
		init();
		
	}
	
	public void init() {
		
		rapports = daoRapportRdv.findAll();
		
		rdvmodel = new RdvModel(rapports);
		fenetre.getTable().setModel(rdvmodel);
		
		fenetre.setVisible(true);
	}
	
	public void doQuit() {
		
		fenetre.dispose();
	}
	
	private void doSupprimer() {
	
	
        
        int row = fenetre.getTable().getSelectedRow();
		//int column = 0;
		
		//int id = ((int) fenetre.getTable().getValueAt(row, column));
		
		RapportRdv rapport = rapports.get(row);
		
		daoRapportRdv.delete(rapport);
		
        rapports = daoRapportRdv.findAll();
		
		rdvmodel = new RdvModel(rapports);
		fenetre.getTable().setModel(rdvmodel);
		
		

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
