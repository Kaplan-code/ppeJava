package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.Font;

public class affichage extends JFrame {

	private JPanel contentPane;
	private JTextField textVilleMed;
	private JTable table;
	private JPanel panel;
	private JButton btnRecherche;
	private JLabel lblNom;
	private JLabel lblRole;
	private JButton btnDeconnexion;
	private JButton btnAfificherToutLes;
	private JLabel lblAfificherToutLes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					affichage frame = new affichage();
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
	public affichage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); //center
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 246, 608, 344);
		contentPane.add(scrollPane); 
		
		table = new JTable();
		table.setName("table");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Prenom", "Nom", "Ville"
			}
		));
		
		scrollPane.setViewportView(table);
		
		JLabel lblRservezUneConsultation = new JLabel("Réservez une consultation avec un médecin :");
		lblRservezUneConsultation.setFont(new Font("Source Code Pro Semibold", Font.BOLD | Font.ITALIC, 14));
		lblRservezUneConsultation.setBounds(210, 105, 354, 15);
		contentPane.add(lblRservezUneConsultation);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(159, 132, 493, 102);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Recherche par ville :");
		lblNewLabel.setBounds(12, 12, 148, 15);
		panel.add(lblNewLabel);
		
		textVilleMed = new JTextField();
		textVilleMed.setBounds(178, 12, 141, 26);
		panel.add(textVilleMed);
		textVilleMed.setColumns(10);
		
		btnRecherche = new JButton("Recherche");
		btnRecherche.setName("Recherche");
		btnRecherche.setBounds(178, 54, 141, 36);
		panel.add(btnRecherche);
		
		lblNom = new JLabel("nom");
		lblNom.setBounds(631, 0, 70, 15);
		contentPane.add(lblNom);
		
		lblRole = new JLabel("role du user");
		lblRole.setBounds(754, 0, 118, 15);
		contentPane.add(lblRole);
		
		btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.setName("Déconnexion");
		btnDeconnexion.setBounds(735, 565, 125, 25);
		contentPane.add(btnDeconnexion);
		
		btnAfificherToutLes = new JButton("Afficher");
		btnAfificherToutLes.setName("Afficher");
		btnAfificherToutLes.setBounds(241, 7, 118, 25);
		contentPane.add(btnAfificherToutLes);
		
		lblAfificherToutLes = new JLabel("Afificher tout les rendez-vous :");
		lblAfificherToutLes.setBounds(12, 12, 225, 15);
		contentPane.add(lblAfificherToutLes);
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnRecherche() {
		return btnRecherche;
	}
	public JTextField getTextVilleMed() {
		return textVilleMed;
	}
	public JLabel getLblNom() {
		return lblNom;
	}
	public JLabel getLblRole() {
		return lblRole;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JButton getBtnAfificherRdv() {
		return btnAfificherToutLes;
	}
	public JLabel getLblAfificher() {
		return lblAfificherToutLes;
	}
}
