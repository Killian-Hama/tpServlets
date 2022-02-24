package fr.eni.tpServlets.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletsTools {

	public static void Render(HttpServletRequest request, HttpServletResponse response, String view) {
		request.setAttribute("view", "./../view/" + view + ".jsp");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/layout/default.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Redirect(HttpServletResponse response, String servlet) throws IOException {
		response.sendRedirect(servlet);
	}
}
