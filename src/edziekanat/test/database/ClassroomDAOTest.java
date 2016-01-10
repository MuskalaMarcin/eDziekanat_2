package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;

/**
 * Servlet implementation class ClassroomDAOTest
 */
@WebServlet("/ClassroomDAOTest")
public class ClassroomDAOTest extends HttpServlet
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

	out.println("ONE Classroom");
	ClassroomDTO classroom = new ClassroomDAO().getEntity(1);
	out.println("<br>" + classroom.getType());
	out.println("<br>" + classroom.getCapacity());
	out.println("<br>" + classroom.getFaculty().getName());
	out.println("<br>" + classroom.getId());

	out.println("<p>ALL Classrooms");
	new ClassroomDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getType());
	    out.println("<br>" + item.getCapacity());
	    out.println("<br>" + item.getFaculty().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});
    }
}
