package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
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
 * Servlet implementation class AddNewStudent
 */
@WebServlet("/adminaddstudent")
public class AddNewStudent extends HttpServlet
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
	    StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();
	    UserDAO userDAO = new UserDAO();
	    StudentDAO studentDAO = new StudentDAO();

	    StudentDTO student = new StudentDTO();
	    student.setName(request.getParameter("name"));
	    student.setSurname(request.getParameter("surname"));
	    student.setAddress(request.getParameter("address"));
	    student.setAcademicDegree(request.getParameter("academicdegree"));

	    StudentsGroupDTO studentsGroup = studentsGroupDAO
			    .getEntity(Integer.parseInt(request.getParameter("studentsgroupid")));
	    student.setStudentsGroup(Arrays.asList(studentsGroup));

	    studentDAO.insert(student);

	    UserDTO user = new UserDTO();
	    user.setActive(1);
	    user.seteMail(request.getParameter("email"));
	    user.setLogin(request.getParameter("login"));
	    String salt = PasswordUtils.generateSalt();
	    user.setSalt(salt);
	    user.setPassword(PasswordUtils.getSHA512PasswordHash(request.getParameter("password"), salt));
	    user.setUserRole("student");
	    user.setStudent(student);
	    userDAO.insert(user);

	    studentsGroup.getStudent().add(student);
	    studentsGroupDAO.update(studentsGroup);

	    request.setAttribute("msgshort", "Student dodany");
	    request.setAttribute("msglong", "Nowy student zosta³ dodany");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminstudents");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);

	    studentsGroupDAO.closeEntityManager();
	    userDAO.closeEntityManager();
	    studentDAO.closeEntityManager();
	}
	catch (RollbackException ex)
	{
	    if (ExceptionUtils.indexOfThrowable(ex, ConstraintViolationException.class) > 0)
	    {
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Login lub email jest ju¿ u¿ywany");
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminstudents");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else
	    {
		ex.printStackTrace();
	    }
	}
    }
}
