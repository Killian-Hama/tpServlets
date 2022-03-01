package fr.eni.tpServlets.bll;

import java.util.List;

import fr.eni.tpServlets.bo.Notes;
import fr.eni.tpServlets.dal.DALException;
import fr.eni.tpServlets.dal.NotesDao;
import fr.eni.tpServlets.dal.jdbc.DAOFactory;

public class NotesManager {
	private static NotesManager manager;
	private NotesDAO notesDao;

	private NotesManager() {
	};

	public static NotesManager getManager() throws BLLException {
		if (manager == null) {
			manager = new NotesManager();
			manager.notesDao = DAOFactory.getNotesDAO();
		}

		return manager;
	}

	public List<Notes> listeNotes() throws BLLException {
		try {
			return NotesDao.selectAll();
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("L'application n'a pas pu recuperer la liste des Notes.");
		}
	}

	public void ajouterNotes(Notes Notes) throws BLLException {
		try {
			NotesDao.insert(Notes);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue lors de l'ajout d'une nouvelle Note. \nVeuillez ressayer.");
		}
	}

	public void supprimerNotes(int id) throws BLLException {
		try {
			NotesDao.delete(id);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue lors de la supression d'une Note. \nVeuillez reessayer.");
		}
	}
}