package fr.eni.tpServlets.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpServlets.bll.BLLException;
import fr.eni.tpServlets.bll.RepasManager;
import fr.eni.tpServlets.bo.Repas;
import fr.eni.tpServlets.util.ServletsTools;

/**
 * Servlet implementation class SuiviRepasServlet
 */
@WebServlet("/getRepas")
public class SuiviRepasHistoriqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuiviRepasHistoriqueServlet() {
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
		if (request.getParameter("id") != null) {
			try {
				RepasManager.getManager().supprimerRepas(Integer.parseInt(request.getParameter("id")));
				ServletsTools.Redirect(response, "getRepas");
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				List<Repas> lr = RepasManager.getManager().listeRepas();

				request.setAttribute("repas", lr);
				ServletsTools.Render(request, response, "SuiviRepas/historique");
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
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
