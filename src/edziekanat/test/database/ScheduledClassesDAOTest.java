package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

/**
 * Servlet implementation class ScheduledClassesDAOTest
 */
@WebServlet("/ScheduledClassesDAOTest")
public class ScheduledClassesDAOTest extends HttpServlet
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

	out.println("ONE ScheduledClasses");
	ScheduledClassesDTO scheduledClasses = new ScheduledClassesDAO().getEntity(1);
	out.println("<br>" + scheduledClasses.getClassroomId());
	out.println("<br>" + scheduledClasses.getDuration());
	out.println("<br>" + scheduledClasses.getId());
	out.println("<br>" + scheduledClasses.getSubjectId());
	out.println("<br>" + scheduledClasses.getDate());
	out.println("<br>" + scheduledClasses.getTime());

	out.println("<p>ALL ScheduledClassess");
	new ScheduledClassesDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getClassroomId());
	    out.println("<br>" + item.getDuration());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getSubjectId());
	    out.println("<br>" + item.getDate());
	    out.println("<br>" + item.getTime());
	    out.println("<br> nastepny");
	});
    }
}
