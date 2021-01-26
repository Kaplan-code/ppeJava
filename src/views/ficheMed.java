package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;

public class ficheMed extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textVille;
	private JTextField textNuméro;
	private JTextField textAdresse;
	private JButton btnQuitter;
	private JButton btnValider;
	private JLabel lblFicheMedecin;
	private JTextField textCodePostal;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ficheMed frame = new ficheMed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ficheMed() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); //center
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(64, 152, 70, 15);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(64, 186, 70, 15);
		contentPane.add(lblPrenom);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(64, 220, 70, 15);
		contentPane.add(lblVille);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setBounds(169, 150, 140, 19);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.setEditable(false);
		textPrenom.setBounds(169, 184, 140, 19);
		contentPane.add(textPrenom);
		textPrenom.setColumns(10);
		
		textVille = new JTextField();
		textVille.setEditable(false);
		textVille.setBounds(169, 284, 140, 19);
		contentPane.add(textVille);
		textVille.setColumns(10);
		
		JLabel lblNumro = new JLabel("Numéro :");
		lblNumro.setBounds(64, 286, 70, 15);
		contentPane.add(lblNumro);
		
		textNuméro = new JTextField();
		textNuméro.setEditable(false);
		textNuméro.setBounds(169, 218, 140, 19);
		contentPane.add(textNuméro);
		textNuméro.setColumns(10);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setName("Quitter");
		btnQuitter.setBounds(114, 407, 117, 25);
		contentPane.add(btnQuitter);
		
		btnValider = new JButton("Valider");
		btnValider.setName("Valider");
		btnValider.setBounds(310, 407, 117, 25);
		contentPane.add(btnValider);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(64, 323, 70, 15);
		contentPane.add(lblAdresse);
		
		textAdresse = new JTextField();
		textAdresse.setEditable(false);
		textAdresse.setBounds(169, 321, 140, 19);
		contentPane.add(textAdresse);
		textAdresse.setColumns(10);
		
		lblFicheMedecin = new JLabel("Fiche Medecin :");
		lblFicheMedecin.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		lblFicheMedecin.setBounds(194, 45, 190, 29);
		contentPane.add(lblFicheMedecin);
		
		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setBounds(64, 255, 97, 15);
		contentPane.add(lblCodePostal);
		
		textCodePostal = new JTextField();
		textCodePostal.setEditable(false);
		textCodePostal.setBounds(169, 253, 140, 19);
		contentPane.add(textCodePostal);
		textCodePostal.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(421, 186, 100, 19);
		contentPane.add(dateChooser);
		
		Label label = new Label("Date :");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(421, 152, 68, 21);
		contentPane.add(label);
	}
	public JTextField getTextNom() {
		return textNom;
	}
	public JTextField getTextPrenom() {
		return textPrenom;
	}
	public JTextField getTextVille() {
		return textVille;
	}
	public JTextField getTextNuméro() {
		return textNuméro;
	}
	public JTextField getTextAdresse() {
		return textAdresse;
	}
	public JButton getBtnQuitter() {
		return btnQuitter;
	}
	public JButton getBtnValider() {
		return btnValider;
	}
	public JTextField getTextCodePostal() {
		return textCodePostal;
	}
	public JDateChooser getDateChooser() {
		return dateChooser;
	}
}
