package edziekanat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet maintaing logging out from application.
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Not used GET method redirecting to POST.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	if (request.getUserPrincipal() == null || request.getUserPrincipal().getName().isEmpty())
	{
	    request.setAttribute("errorshort", "Niezalogowano");
	    request.setAttribute("errorlong", "Najpierw zaloguj siê do systemu.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	else
	{
	    try
	    {
		request.getSession().invalidate();
		request.logout();
		request.setAttribute("msgshort", "Wylogowano");
		request.setAttribute("msglong", "Zosta³e¶ wylogowany z systemu.");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	    catch (ServletException e)
	    {
		e.printStackTrace();
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Podczas wylogowywania z systemu wyst±pi³ nieznany problem.");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	}
    }
}
