package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javassist.compiler.ast.Variable;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class connexion extends JFrame {

	private JPanel contentPane;
	private JTextField textIdentif;
	private JButton btnConnexion;
	private JPasswordField txtMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion frame = new connexion();
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
	public connexion() {
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); //center
		
		textIdentif = new JTextField();
		textIdentif.setForeground(new Color(255, 255, 255));
		textIdentif.setBackground(new Color(169, 169, 169));
		textIdentif.setBounds(270, 178, 130, 19);
		contentPane.add(textIdentif);
		textIdentif.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setName("Connexion");
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setBackground(new Color(119, 136, 153));
		btnConnexion.setBounds(283, 281, 109, 47);
		contentPane.add(btnConnexion);
		
		JLabel lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(120, 180, 89, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(120, 233, 113, 15);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 676, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblIdentification = new JLabel("Identification :");
		lblIdentification.setBounds(260, 33, 152, 34);
		panel.add(lblIdentification);
		lblIdentification.setForeground(Color.WHITE);
		lblIdentification.setFont(new Font("Khmer OS", Font.BOLD, 20));
		
		txtMdp = new JPasswordField();
		txtMdp.setBackground(new Color(169, 169, 169));
		txtMdp.setBounds(270, 231, 130, 19);
		contentPane.add(txtMdp);
		
		
		
		
	}
	public JButton getBtnConnexion() {
		return btnConnexion;
	}
	public JTextField getTextIdentif() {
		return textIdentif;
	}
	
	public JPasswordField getTxtMdp() {
		return txtMdp;
	}
}
