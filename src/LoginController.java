import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.portable.ValueOutputStream;

import DAO.DAOAffichage;
import DAO.DAOLogin;
import entities.Medecin;
import entities.Utilisateur;
import util.HibernateUtil;
import views.affichage;
import views.connexion;

public class LoginController implements ActionListener {
	connexion fenetre;
	DAOLogin daoutilisateur;
	affichage affichage;
	
	public LoginController()  {
	}
	
	public LoginController(connexion f,DAOLogin daoUtilisateur) {
		this.daoutilisateur = daoUtilisateur;
		this.fenetre = f;
		
	
		init();
		

		fenetre.getBtnConnexion().addActionListener(this);
		
		
	}
	
	public void init() {
		
		fenetre.setVisible(true);
	}
	
	public void doConnect() throws NoSuchAlgorithmException {
		
		String mdp = fenetre.getTxtMdp().getText();
		String mdpSha = sha256(mdp).toString();
		String pssw = daoutilisateur.getUserlog(fenetre.getTextIdentif().getText(),mdpSha);
		if(pssw==null) {
			JFrame frame = new JFrame("showMessageDialog");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JOptionPane.showMessageDialog(frame,
		            "Mot de passe incorrect",
		            "Ressayez",
		            JOptionPane.ERROR_MESSAGE);
		    
		}
		else {
		
		System.out.println(mdpSha);
		System.out.println(pssw);
		if (pssw.equals(mdpSha)) {
			System.out.println("bon");
			
			Utilisateur user = daoutilisateur.getUser(fenetre.getTextIdentif().getText(), mdpSha); //recupere l'utilisateur
			
			DeuxiemmeFenetre(user); //Ouvre la 2eme vue
			
			fenetre.setVisible(false);
		 }	
		}
		
		
	}
	
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	} 
	
	public void DeuxiemmeFenetre(Utilisateur user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			new AffichageController(new affichage(), new DAOAffichage(session, Medecin.class),user);
		} catch (HibernateException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String src = evt.getActionCommand();
		
		if (src== "Connexion") {
			try {
				doConnect();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
