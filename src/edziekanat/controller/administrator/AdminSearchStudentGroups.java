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
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class AdminSearchStudentGroups
 */
@WebServlet("/adminsearchstudentgroups")
public class AdminSearchStudentGroups extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchStudentGroups()
    {
	super();
    }

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
	String course = request.getParameter("searchedCourse").toString();
	if (!course.isEmpty())
	{
	    List<CourseDTO> courses = new CourseDAO().getCourseByName(course);
	    List<StudentsGroupDTO> studentsgroup = new LinkedList<StudentsGroupDTO>();
	    for (int i = 0; i < courses.size(); i++)
	    {
		studentsgroup.addAll(courses.get(i).getStudentsGroup());
	    }
	    request.setAttribute("studentsgroup", studentsgroup);
	}
	request.getRequestDispatcher("admin/studentgroups").forward(request, response);
    }

}
