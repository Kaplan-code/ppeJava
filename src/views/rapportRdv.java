package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class rapportRdv extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnQuitter;
	private JButton btnSupprimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rapportRdv frame = new rapportRdv();
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
	public rapportRdv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 604);
		contentPane = new JPanel();
		contentPane.setName("Quitter");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); //center
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 202, 493, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setName("table");
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Rapport des Rendez-vous :");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(314, 127, 245, 15);
		contentPane.add(label);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(704, 516, 117, 25);
		contentPane.add(btnQuitter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setName("Supprimer");
		btnSupprimer.setBounds(538, 516, 124, 25);
		contentPane.add(btnSupprimer);
	}
	public JButton getBtnQuitter() {
		return btnQuitter;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
}
