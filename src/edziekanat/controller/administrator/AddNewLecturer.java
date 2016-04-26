package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.PasswordUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Servlet implementation class AddNewLecturer
 */
@WebServlet("/adminaddlecturer")
public class AddNewLecturer extends HttpServlet
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
	try
	{
	    FacultyDAO facultyDAO = new FacultyDAO();
	    UserDAO userDAO = new UserDAO();
	    LecturerDAO lecturerDAO = new LecturerDAO();

	    LecturerDTO lecturer = new LecturerDTO();
	    lecturer.setName(request.getParameter("name"));
	    lecturer.setSurname(request.getParameter("surname"));
	    lecturer.setAddress(request.getParameter("address"));
	    lecturer.setAcademicDegree(request.getParameter("academicdegree"));
	    lecturer.setPosition(request.getParameter("position"));

	    FacultyDTO faculty = facultyDAO.getEntity(Integer.parseInt(request.getParameter("facultyid")));
	    lecturer.setFaculty(Arrays.asList(faculty));

	    lecturerDAO.insert(lecturer);

	    UserDTO user = new UserDTO();
	    user.setActive(1);
	    user.setLecturer(lecturer);
	    user.seteMail(request.getParameter("email"));
	    user.setLogin(request.getParameter("login"));
	    String salt = PasswordUtils.generateSalt();
	    user.setSalt(salt);
	    user.setPassword(PasswordUtils.getSHA512PasswordHash(request.getParameter("password"), salt));
	    user.setUserRole("lecturer");
	    user.setLecturer(lecturer);

	    userDAO.insert(user);

	    faculty.getLecturer().add(lecturer);
	    facultyDAO.update(faculty);

	    request.setAttribute("msgshort", "Wyk³adowca dodany");
	    request.setAttribute("msglong", "Nowy wyk³adowca zosta³ dodany");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);

	    lecturerDAO.closeEntityManager();
	    userDAO.closeEntityManager();
	    facultyDAO.closeEntityManager();
	}
	catch (RollbackException ex)
	{
	    if (ExceptionUtils.indexOfThrowable(ex, ConstraintViolationException.class) > 0)
	    {
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Login lub email jest ju¿ u¿ywany");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else
	    {
		ex.printStackTrace();
	    }
	}
    }
}
