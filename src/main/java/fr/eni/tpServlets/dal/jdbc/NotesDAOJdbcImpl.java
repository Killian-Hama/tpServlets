package fr.eni.tpServlets.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tpServlets.bo.Notes;
import fr.eni.tpServlets.dal.DALException;
import fr.eni.tpServlets.dal.NotesDAO;
import fr.eni.tpServlets.util.JdbcTools;
import fr.eni.tpServlets.util.UtilException;

public class NotesDAOJdbcImpl implements NotesDAO {
	
	private final String SELECTALL = "SELECT * FROM pn_notes";
	private final String INSERT = "INSERT INTO pn_notes VALUES(null, ?)";
	private final String UPDATE = "UPDATE pn_notes SET content = ? WHERE id = ?";
	private final String DELETE = "DELETE FROM pn_notes WHERE id = ?";

	@Override
	public List<Notes> selectAll() throws DALException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL);
			List<Notes> liste = new ArrayList<>();
			while (rs.next()) {
				liste.add(new Notes(rs.getInt("id"), rs.getString("content")));
			}
			return liste;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion " + e);
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
	public void update(Notes data) throws DALException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, data.getContent());
			stmt.setInt(2, data.getId());
			try {
				// Everything is fine
				stmt.execute();
			} catch (Exception e) {
				throw new DALException("Probleme lors de la modification du notes id = " + data.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion " + e);
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
	public int insert(Notes data) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, data.getContent());
			stmt.execute();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new DALException("Generated keys ");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion " + e);
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
	public void delete(int id) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, id);
			try {
				// Everything is fine
				stmt.execute();
			} catch (Exception e) {
				throw new DALException("Probleme lors de la suppression du notes id = " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de l'essai de connexion " + e);
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
