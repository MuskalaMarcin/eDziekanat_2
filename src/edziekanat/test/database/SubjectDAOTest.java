package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet implementation class SubjectDAOTest
 */
@WebServlet("/SubjectDAOTest")
public class SubjectDAOTest extends HttpServlet
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

	out.println("ONE Subject");
	SubjectDTO subject = new SubjectDAO().getEntity(1);
	out.println("<br>" + subject.getName());
	out.println("<br>" + subject.getECTS());
	out.println("<br>" + subject.getId());
	out.println("<br>" + subject.getLecturerId());
	out.println("<br>" + subject.getSemester());
	out.println("<br>" + subject.getStudentsGroupId());

	out.println("<p>ALL Subjects");
	new SubjectDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getECTS());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getLecturerId());
	    out.println("<br>" + item.getSemester());
	    out.println("<br>" + item.getStudentsGroupId());
	    out.println("<br> nastepny");
	});
    }
}
