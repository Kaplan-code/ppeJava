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
			"Id Utilisateur",
			"Id Medecin"
	};
	
	public RdvModel(List<RapportRdv> rapports ) {
		this.rapports = rapports;
		
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
			type = String.class;
			break;
		case 2:
			type = String.class;
			break;	
		}
		return type;
	}
	
	

}
