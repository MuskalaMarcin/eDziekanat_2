package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

@WebServlet("/StudentsGroupDAOTest")
public class StudentsGroupDAOTest extends HttpServlet
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

	out.println("ONE StudentsGroup");
	StudentsGroupDTO studentsGroup = new StudentsGroupDAO().getEntity(1);
	out.println("<br>" + studentsGroup.getCourse().getName());
	out.println("<br>" + studentsGroup.getId());
	out.println("<br>" + studentsGroup.getYear());

	out.println("<p>ALL StudentsGroups");
	new StudentsGroupDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getCourse().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getYear());
	    out.println("<br> nastepny");
	});
    }
}
