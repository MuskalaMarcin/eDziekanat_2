package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dto.CourseDTO;

@WebServlet("/CourseDAOTest")
public class CourseDAOTest extends HttpServlet
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

	out.println("ONE Course");
	CourseDTO course = new CourseDAO().getEntity(1);
	out.println("<br>" + course.getName());
	out.println("<br>" + course.getFaculty().getName());
	out.println("<br>" + course.getId());
	out.println("<br>" + course.getStationary());

	out.println("<p>ALL Courses");
	new CourseDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getFaculty().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStationary());
	    out.println("<br> nastepny");
	});
    }
}
