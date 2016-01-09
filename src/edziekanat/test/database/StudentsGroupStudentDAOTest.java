package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentsGroupStudentDAO;
import edziekanat.databasemodel.dto.StudentsGroupStudentDTO;

/**
 * Servlet implementation class StudentsGroupStudentDAOTest
 */
@WebServlet("/StudentsGroupStudentDAOTest")
public class StudentsGroupStudentDAOTest extends HttpServlet
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

	out.println("ONE StudentsGroupStudent");
	StudentsGroupStudentDTO studentsGroupStudent = new StudentsGroupStudentDAO().getEntity(1);
	out.println("<br>" + studentsGroupStudent.getStudentId());
	out.println("<br>" + studentsGroupStudent.getStudentsGroupId());

	out.println("<p>ALL StudentsGroupStudents");
	new StudentsGroupStudentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getStudentId());
	    out.println("<br>" + item.getStudentsGroupId());
	    out.println("<br> nastepny");
	});
    }
}
