package fr.eni.cliniqueVeterinaire.dal.jdbc;

import fr.eni.cliniqueVeterinaire.dal.AgendaO;
import fr.eni.cliniqueVeterinaire.dal.AnimalDAO;
import fr.eni.cliniqueVeterinaire.dal.ClientDAO;
import fr.eni.cliniqueVeterinaire.dal.PersonnelDAO;

public class DAOFactory {
	
	public static PersonnelDAO getPersonnelDAO() {
		// TODO Auto-generated method stub
		return new PersonnelDAOJdbcImpl();
	}
	
	public static ClientDAO getClientDAO() {
		return new ClientDAOJdbcImpl();
	}
	
	public static AnimalDAO getAnimalDAO() {
		return new AnimalDAOJdbcImpl();
	}
	
	public static AgendaO getAgendaO() {
		return new AgendaOJdbcImpl();
	}
}
