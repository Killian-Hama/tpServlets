package fr.eni.tpServlets.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tpServlets.bo.Repas;
import fr.eni.tpServlets.dal.DALException;
import fr.eni.tpServlets.dal.RepasDAO;
import fr.eni.tpServlets.util.JdbcTools;
import fr.eni.tpServlets.util.UtilException;

public class RepasDAOJdbcImpl implements RepasDAO{

	private final String SELECTALL = "SELECT * FROM m_repas";
	private final String INSERT = "INSERT INTO m_repas VALUES(null, ?, ?)";
	private final String DELETE = "DELETE FROM m_repas WHERE id = ?";
	
	public RepasDAOJdbcImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Repas> selectAll() throws DALException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL);
			List<Repas> liste = new ArrayList<>();
			while (rs.next()) {
				liste.add(new Repas(rs.getInt("id"), rs.getTimestamp("date").toLocalDateTime(), rs.getString("repas").split(", ")));
			}
			return liste;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion" + e);
		} finally {
			try {
				JdbcTools.seDeconnecter(stmt, con);
			} catch (UtilException e) {
				// TODO Auto-generated catch block
				throw new DALException("Erreur lors de la déconnexion : " + e);
			}
		}
	}
	@Override
	public void insert(Repas data) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(INSERT);
			stmt.setTimestamp(1, Timestamp.valueOf(data.getDate()));
			stmt.setString(2, data.getRepas());
			try {
				stmt.execute();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new DALException("Probleme lors de l'insertion du : " + data.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion" + e);
		}finally {
			try {
				JdbcTools.seDeconnecter(stmt, con);
			} catch (UtilException e) {
				// TODO Auto-generated catch block
				throw new DALException("Erreur lors de la déconnexion : " + e);
			}
		}
			
	}
	

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, id);
			try{
				// Everything is fine
				stmt.execute();
			} catch (Exception e) {
				throw new DALException("Probleme lors de la suppression du repas id = " + id);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion" + e);
		} finally {
			try {
				JdbcTools.seDeconnecter(stmt, con);
			} catch (UtilException e) {
				// TODO Auto-generated catch block
				throw new DALException("Erreur lors de la déconnexion : " + e);
			}
		}
		
	}

}
