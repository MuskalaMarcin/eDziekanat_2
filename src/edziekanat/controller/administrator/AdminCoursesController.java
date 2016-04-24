package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
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
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	CourseDAO courseDAO = new CourseDAO();
	FacultyDAO facultyDAO = new FacultyDAO();
	List<CourseDTO> courses;

	if (request.getAttribute("courses") == null)
	{
	    courses = courseDAO.getAllEntities();
	    request.setAttribute("faculties", facultyDAO.getAllEntities());
	}
	else
	{
	    courses = (List<CourseDTO>) request.getAttribute("courses");
	    request.setAttribute("faculties", courses.get(0).getFaculty());
	}
	Collections.sort(courses, (x, y) -> x.getName().compareTo(y.getName()));
	request.setAttribute("courses", courses);
	request.getRequestDispatcher("admin/courses").forward(request, response);

	facultyDAO.closeEntityManager();
	courseDAO.closeEntityManager();
    }
}
