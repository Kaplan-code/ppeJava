import java.util.HashSet;
import java.util.List;

import javax.swing.table.DefaultTableModel;


import entities.Medecin;

public class MyDefaultModel extends DefaultTableModel {
	private Medecin medecin;
	public List<Medecin> medecins;
	private String[] ColumnNames = {
			"Prenom",
			"Nom",
			"Ville"
	};
	
	
	
	
	public MyDefaultModel(List<Medecin> medecins) {
		this.medecins = medecins; 
	}
	
	
	
	@Override
	public Object getValueAt(int row, int column) {
		
		switch(column) {
		
		case 0:
			return medecins.get(row).getPrenom();
		case 1:
			return medecins.get(row).getNom();
		case 2:
			return medecins.get(row).getVille();
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
		return medecins == null ? 0 : medecins.size();
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
			type = String.class;
			break;
		case 1:
			type = String.class;
			break;
		case 2:
			type = String.class;
			break;	
		}
		return type;
	}
	
	
}


