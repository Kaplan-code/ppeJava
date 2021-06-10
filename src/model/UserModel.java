package model;

import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DAO.DAOLogin;
import entities.RapportRdv;
import entities.Utilisateur;

public class UserModel extends DefaultTableModel {
	
	
	public List<Utilisateur> users;
	
	private String[] ColumnNames = {
			"id",
			"Utilisateur",
			"Nombre_Medecins"
	};
	DAOLogin daouser;
	
	public UserModel(List<Utilisateur> users ) {
		this.users = users;
		
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		
		switch(column) {
		
		case 0:
			return users.get(row).getId();
		case 1:
			return users.get(row).getNom();
		case 2:
			return users.get(row).getId();
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
		return users == null ? 0 : users.size();
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
			type = Integer.class;
			break;
		case 1:
			type = String.class;
			break;
		case 2:
			type = Integer.class;
			break;	
		}
		return type;
	}

}
