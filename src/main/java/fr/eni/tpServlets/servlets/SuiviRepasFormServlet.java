package fr.eni.tpServlets.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
 * Servlet implementation class SuiviRepasFormServlet
 */
@WebServlet("/ajoutRepas")
public class SuiviRepasFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuiviRepasFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletsTools.Render(request, response, "SuiviRepas/form");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getParameter("dateInput") + request.getParameter("heureInput")
		LocalDateTime datee = LocalDateTime.of(LocalDate.parse(request.getParameter("dateInput")), LocalTime.parse(request.getParameter("heureInput")));
		System.out.println(datee);
		String repas = request.getParameter("repasInput");
		try {
			RepasManager.getManager().ajouterRepas(new Repas(datee, repas));
			ServletsTools.Redirect(response, "/tpServlets/getRepas");
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
