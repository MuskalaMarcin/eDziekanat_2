package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AdminAddCourseController
 */
@WebServlet("/adminaddcourse")
public class AdminAddCourseController extends HttpServlet
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	FacultyDAO facultyDAO = new FacultyDAO();
	CourseDAO courseDAO = new CourseDAO();

	try
	{
	    Integer facultyId = Integer.parseInt(request.getParameter("id"));
	    Integer isStationary = Integer.parseInt(request.getParameter("stationary"));
	    String courseName = request.getParameter("name");

	    List<CourseDTO> theSameNameCourses = courseDAO.getCourseByName(courseName);
	    FacultyDTO faculty = facultyDAO.getEntity(facultyId);

	    if (theSameNameCourses.stream().filter(course -> course.getFaculty().getId().equals(faculty.getId())
			    && course.getStationary().equals(isStationary)).findAny().isPresent())
	    {
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Przedmiot o tej samej nazwie jest ju¿ dodany na tym wydziale.");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else
	    {
		CourseDTO course = new CourseDTO();
		course.setName(courseName);
		course.setFaculty(faculty);
		course.setStationary(isStationary);
		courseDAO.insert(course);
		faculty.getCourse().add(course);
		facultyDAO.update(faculty);

		request.setAttribute("msgshort", "Kierunek dodany");
		request.setAttribute("msglong", "Nowy kierunek zosta³ dodany");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	}
	catch (NumberFormatException | NullPointerException e)
	{
	    request.setAttribute("errorshort", "B³±d");
	    request.setAttribute("errorlong", "Podczas przesy³ania danych wyst±pi³ b³±d.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	catch (HibernateException e2)
	{
	    e2.printStackTrace();
	    request.setAttribute("errorshort", "B³±d");
	    request.setAttribute("errorlong", "Podczas zapisu danych do bazy wyst±pi³ b³±d.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}

	courseDAO.closeEntityManager();
	facultyDAO.closeEntityManager();
    }

}
