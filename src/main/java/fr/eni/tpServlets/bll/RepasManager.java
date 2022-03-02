package fr.eni.tpServlets.bll;

import java.util.List;

import fr.eni.tpServlets.bo.Repas;
import fr.eni.tpServlets.dal.DALException;
import fr.eni.tpServlets.dal.RepasDAO;
import fr.eni.tpServlets.dal.jdbc.DAOFactory;

public class RepasManager {
	private static RepasManager manager;
	private RepasDAO repasDao;

	private RepasManager() {
	};

	public static RepasManager getManager() throws BLLException {
		if (manager == null) {
			manager = new RepasManager();
			manager.repasDao = DAOFactory.getRepasDAO();
		}

		return manager;
	}

	public List<Repas> listeRepas() throws BLLException {
		try {
			return repasDao.selectAll();
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("L'application n'a pas pu recuperer la liste des repas.");
		}
	}

	public int ajouterRepas(Repas repas) throws BLLException {
		try {
			return repasDao.insert(repas);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue l'ors de l'ajout d'un nouvau repas. \nVeuillez ressayer.");
		}
	}

	public void supprimerRepas(int id) throws BLLException {
		try {
			repasDao.delete(id);
		} catch (DALException e) {
			System.out.println(e);
			throw new BLLException("Un probleme est survenue l'ors de la supression du repas. \nVeuillez reessayer.");
		}
	}
}
