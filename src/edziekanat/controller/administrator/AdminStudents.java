package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class AdminStudents
 */
@WebServlet("/adminstudents")
public class AdminStudents extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<StudentDTO> students = new LinkedList<StudentDTO>();
	if (request.getParameter("students") == null && request.getParameter("studentsGroupId") == null)
	{
	    students = new StudentDAO().getAllEntities();

	}
	else if (request.getParameter("studentsGroupId") != null)
	{
	    StudentsGroupDTO studentsGroup = new StudentsGroupDAO().getEntity(Integer.parseInt(request.getParameter("studentsGroupId")));
	    students = studentsGroup.getStudent();
	    request.setAttribute("studentsgroup", studentsGroup);
	}
	else
	{
	    students = (List<StudentDTO>) request.getAttribute("students");
	}
	request.setAttribute("students", students);
	request.getRequestDispatcher("administrator/students.jsp").forward(request, response);
    }


}
