package edziekanat.controller.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMessageController
 */
@WebServlet("/sendmessage")
public class SendMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("msgreceiver"));
		System.out.println(request.getParameter("msgtitle"));
		System.out.println(request.getParameter("content"));
		
		//request.setAttribute("msgshort", "Wylogowano");
		//request.setAttribute("msglong", "Zosta³eœ wylogowany z systemu.");
		//request.getRequestDispatcher("/info.jsp").forward(request, response);
	}

}
