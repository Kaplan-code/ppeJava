package model;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import entities.Medecin;
import entities.RapportRdv;
import entities.Utilisateur;

public class RdvModel extends DefaultTableModel  {
	
	private Medecin medecin;
	private Utilisateur user;
	private RapportRdv rapport;
	public List<Medecin> medecins;
	public List<Utilisateur> users;
	public List<RapportRdv> rapports;
	private String[] ColumnNames = {
			"Date",
			"Id_Utilisateur",
			"Id_Medecin"
	};
	
	public RdvModel(List<RapportRdv> rapports ) {
		this.rapports = rapports;
		
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		
		switch(column) {
		
		case 0:
			return rapports.get(row).getDate();
		case 1:
			return rapports.get(row).getUtilisateurId().getNom();
		case 2:
			return rapports.get(row).getMedecinId().getNom();
		default:
			return "";
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rapports == null ? 0 : rapports.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		
		return ColumnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		
			return false;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		Class<?> type=null;
		switch (columnIndex) {
		case 0:
			type = Date.class;
			break;
		case 1:
			type = Integer.class;
			break;
		case 2:
			type = Integer.class;
			break;	
		}
		return type;
	}
	
	

}
