package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
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
	if (request.getAttribute("courseid") == null)
	{
	    if (request.getAttribute("courses") == null || ((List<CourseDTO>) request.getAttribute("courses")).isEmpty())
	    {
		request.setAttribute("studentsgroup", new StudentsGroupDAO().getAllEntities());
	    }
	    else
	    {
		@SuppressWarnings("unchecked")
		List<CourseDTO> courses = (List<CourseDTO>) request.getAttribute("courses");
		List<StudentsGroupDTO> studentsgroup = new LinkedList<StudentsGroupDTO>();
		for (int i = 0; i < courses.size(); i++)
		{
		    studentsgroup.addAll(courses.get(i).getStudentsGroup());
		}
		request.setAttribute("studentsgroup", studentsgroup);
	    }
	}
	else
	{
	    CourseDTO course = new CourseDAO().getEntity(Integer.parseInt(request.getParameter("courseid")));
	    request.setAttribute("studentsgroup", course.getStudentsGroup());
	}
	request.getRequestDispatcher("admin/studentgroups").forward(request, response);
    }

}
