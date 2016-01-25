package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class AdminStudentGroupsController
 */
@WebServlet("/adminstudentgroups")
public class AdminStudentsGroupController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	if (((List<StudentsGroupDTO>)request.getAttribute("studentsgroup")).isEmpty())
	{
	    request.setAttribute("studentsgroup", new StudentsGroupDAO().getAllEntities());
	}
	else
	{
	    @SuppressWarnings("unchecked")
	    List<StudentsGroupDTO> studentsgroup = (List<StudentsGroupDTO>) request.getAttribute("studentsgroup");
	    request.setAttribute("studentsgroup", studentsgroup);
	}
	request.getRequestDispatcher("admin/studentgroups").forward(request, response);
    }

}
