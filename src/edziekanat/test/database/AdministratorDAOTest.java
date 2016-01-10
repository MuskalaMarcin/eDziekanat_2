package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;

/**
 * Servlet implementation class AdministratorDAOTEST
 */
@WebServlet("/AdministratorDAOTest")
public class AdministratorDAOTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	out.println("<p>ONE ADMIN");
	AdministratorDTO admin = new AdministratorDAO().getEntity(1);
	out.println("<br>" + admin.getName());
	out.println("<br>" + admin.getPosition());
	out.println("<br>" + admin.getAddress());
	out.println("<br>" + admin.getSurname());
	out.println("<br>" + admin.getId());
	out.println("<br>" + admin.getUniversity().getName());

	out.println("<p>ALL ADMINS");
	new AdministratorDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getPosition());
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getSurname());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getUniversity().getName());
	    out.println("<br> nastepny");
	});
    }

}
