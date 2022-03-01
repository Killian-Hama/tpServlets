package fr.eni.tpServlets.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.tpServlets.bo.Notes;
import fr.eni.tpServlets.dal.DALException;
import fr.eni.tpServlets.dal.NotesDAO;
import fr.eni.tpServlets.dal.jdbc.DAOFactory;
import fr.eni.tpServlets.util.JdbcTools;
import fr.eni.tpServlets.util.UtilException;

public class NotesManager {
	private static NotesManager manager;
	private NotesDAO notesDAO;

	private NotesManager() {
	};

	public static NotesManager getManager() throws BLLException {
		if (manager == null) {
			manager = new NotesManager();
			manager.notesDAO = DAOFactory.getNotesDAO();
		}

		return manager;
	}

	public List<Notes> listeNotes() throws BLLException {
		try {
			return notesDAO.selectAll();
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("L'application n'a pas pu recuperer la liste des Notes.");
		}
	}

	public int ajouterNotes(Notes notes) throws BLLException {
		try {
			return notesDAO.insert(notes);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue lors de l'ajout d'une nouvelle Note. \nVeuillez ressayer.");
		}
	}

	public void modifierNotes(Notes notes) throws BLLException {
		try {
			notesDAO.update(notes);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue lors de l'ajout d'une nouvelle Note. \nVeuillez ressayer.");
		}
	}
	
	public void supprimerNotes(int id) throws BLLException {
		try {
			notesDAO.delete(id);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue lors de la supression d'une Note. \nVeuillez reessayer.");
		}
	}
}