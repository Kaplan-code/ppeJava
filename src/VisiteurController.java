import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import DAO.DAOLogin;
import entities.RapportRdv;
import entities.Utilisateur;
import model.RdvModel;
import model.UserModel;
import views.users;

public class VisiteurController implements ActionListener{
	users fenetre;
	DAOLogin daoUtilisateur;
	UserModel usermodel;
	public List<Utilisateur> listUser;

	
	public VisiteurController(users f ,DAOLogin daoUtilisateur) {
		this.fenetre = f;
		this.daoUtilisateur = daoUtilisateur;
		
		init();
	}
	
	public void init() {
		
		listUser = daoUtilisateur.findAllUser();
		usermodel = new UserModel(listUser); 
		fenetre.getTableVisiteurs().setModel(usermodel);
		fenetre.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
