package fr.eni.tpServlets.dal;

import java.util.List;

import fr.eni.tpServlets.bo.Notes;


public interface NotesDAO {

	public List<Notes> selectAll() throws DALException;
	public void update(Notes data) throws DALException; 
	public int insert(Notes data) throws DALException;
	public void delete(int id) throws DALException;

}
