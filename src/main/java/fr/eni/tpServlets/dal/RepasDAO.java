package fr.eni.tpServlets.dal;

import java.util.List;

import fr.eni.tpServlets.bo.Repas;

public interface RepasDAO {

	public List<Repas> selectAll() throws DALException;

	public void insert(Repas data) throws DALException;

	public void delete(int id) throws DALException;

}
