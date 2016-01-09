package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dto.LecturerDTO;

@WebServlet("/LecturerDAOTest")
public class LecturerDAOTest extends HttpServlet
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

	out.println("ONE Lecturer");
	LecturerDTO lecturer = new LecturerDAO().getEntity(1);
	out.println("<br>" + lecturer.getAcademicDegree());
	out.println("<br>" + lecturer.getAddress());
	out.println("<br>" + lecturer.getName());
	out.println("<br>" + lecturer.getPosition());
	out.println("<br>" + lecturer.getSurname());
	out.println("<br>" + lecturer.getId());

	out.println("<p>ALL Lecturers");
	new LecturerDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAcademicDegree());
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getPosition());
	    out.println("<br>" + item.getSurname());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});
    }
}
