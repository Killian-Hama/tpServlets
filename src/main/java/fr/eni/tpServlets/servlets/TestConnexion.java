package fr.eni.tpServlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.tpServlets.util.JdbcTools;
import fr.eni.tpServlets.util.UtilException;

/**
 * Servlet implementation class TestConnexion
 */
@WebServlet("/TestConnexion")
public class TestConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestConnexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// Création d'un objet de type Context permettant la recherche d'une ressource
		// nommée dans l'arbre JNDI
		try {
			Connection cnx = JdbcTools.getConnection();

			out.print("La connexion est " + (cnx.isClosed() ? "fermée" : "ouverte") + ".");

			JdbcTools.seDeconnecter(cnx);
		} catch (UtilException | SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
