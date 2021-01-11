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
		setBounds(100, 100, 617, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); //center
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 153, 493, 286);
		contentPane.add(scrollPane); 
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
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
		lblRservezUneConsultation.setBounds(96, 12, 354, 15);
		contentPane.add(lblRservezUneConsultation);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(41, 39, 493, 102);
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
}
