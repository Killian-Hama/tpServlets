package fr.eni.tpServlets.dal.jdbc;

import fr.eni.tpServlets.dal.NotesDAO;
import fr.eni.tpServlets.dal.RepasDAO;

public class DAOFactory {
	
	public static NotesDAO getNotesDAO() {
		// TODO Auto-generated method stub
		return new NotesDAOJdbcImpl();
	}
	public static RepasDAO getRepasDAO() {
		// TODO Auto-generated method stub
		return new RepasDAOJdbcImpl();
	}
}
