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
import edziekanat.databasemodel.dto.CourseDTO;

/**
 * Servlet implementation class AdminCoursesController
 */
@WebServlet("/admincourses")
public class AdminCoursesController extends HttpServlet
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
	if (request.getAttribute("courses") == null)
	{
	    request.setAttribute("courses", new CourseDAO().getAllEntities());
	    request.setAttribute("faculties", new FacultyDAO().getAllEntities());
	}
	else
	{
	    @SuppressWarnings("unchecked")
	    List<CourseDTO> courses = (List<CourseDTO>) request.getAttribute("courses");
	    request.setAttribute("courses", courses);
	    request.setAttribute("faculties", courses.get(0).getFaculty());
	}
	request.getRequestDispatcher("admin/courses").forward(request, response);
    }

}
