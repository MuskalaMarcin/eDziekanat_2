package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Servlet implementation class ApplicationDAOTest
 */
@WebServlet("/ApplicationDAOTest")
public class ApplicationDAOTest extends HttpServlet
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

	out.println("ONE APPLICATION");
	ApplicationDTO app = new ApplicationDAO().getEntity(1);
	out.println("<br>" + app.getContent());
	out.println("<br>" + app.getTitle());
	out.println("<br>" + app.getAdministrator().getName());
	out.println("<br>" + app.getId());
	out.println("<br>" + app.getStudent().getName());
	out.println("<br>" + app.getDispatchDate());
	out.println("<br>" + app.getStatus());

	out.println("<p>ALL APPLICATIONS");
	new ApplicationDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getContent());
	    out.println("<br>" + item.getTitle());
	    out.println("<br>" + item.getAdministrator().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br>" + item.getDispatchDate());
	    out.println("<br>" + item.getStatus());
	    out.println("<br> nastepny");
	});
    }
}
