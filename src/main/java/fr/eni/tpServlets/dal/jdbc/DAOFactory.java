package fr.eni.tpServlets.dal.jdbc;

import fr.eni.tpServlets.dal.NotesDAO;

public class DAOFactory {
	
	public static NotesDAO getNotesDAO() {
		// TODO Auto-generated method stub
		return new NotesDAOJdbcImpl();
	}
}
