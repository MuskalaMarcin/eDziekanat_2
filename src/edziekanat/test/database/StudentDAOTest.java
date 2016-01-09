package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.StudentDTO;

@WebServlet("/StudentDAOTest")
public class StudentDAOTest extends HttpServlet
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

	out.println("ONE Student");
	StudentDTO student = new StudentDAO().getEntity(1);
	out.println("<br>" + student.getAcademicDegree());
	out.println("<br>" + student.getAddress());
	out.println("<br>" + student.getName());
	out.println("<br>" + student.getSurname());
	out.println("<br>" + student.getId());

	out.println("<p>ALL Students");
	new StudentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAcademicDegree());
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getSurname());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});
    }
}
