package fr.eni.tpServlets.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpServlets.util.JdbcTools;
import fr.eni.tpServlets.util.ServletsTools;

/**
 * Servlet implementation class PartieChifoumiServlet
 */
@WebServlet("/partie")
public class PartieChifoumiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PartieChifoumiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id") == null) {
			response.sendRedirect("/tpServlets/chifoumi");
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement("select * from cfm_partie where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();			
			rs.next();
			int idJoueur_1 = rs.getInt("IdJoueur_1");
			int idJoueur_2 = rs.getInt("IdJoueur_2");
			if (idJoueur_1 != 0 && idJoueur_2 != 0) {
				response.sendRedirect("/tpServlets/chifoumi?info=trop");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("/tpServlets/chifoumi?info=nop");

		} finally {
			try {
				JdbcTools.seDeconnecter(stmt, con);
				return;
			} catch (fr.eni.tpServlets.util.UtilException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
/*
		request.setAttribute("joueur1", "");
		request.setAttribute("joueur2", "");

		ServletsTools.Render(request, response, "partie");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement("UPDATE cfm_partie SET choixJoueur_1 = ? WHERE id = ?");
			stmt.setInt(1, data.getId());
			stmt.setInt(2, data.getId());
			try {
				stmt.execute();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new DALException("Probleme lors de la modification du : " + data.toString());
			} // Everything ok
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Probleme lors de la modification du : " + data.toString());
		} finally {
			try {
				JdbcTools.seDeconnecter(stmt, con);
			} catch (UtilException e) {
				// TODO Auto-generated catch block
				throw new DALException("Erreur lors de la d�connexion : " + e);
			}
		}
		ServletsTools.Render(request, response, "partie");
	}

}
