package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.PasswordUtils;

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
		try {
			LecturerDTO lecturer = new LecturerDTO();
			lecturer.setName(request.getParameter("name"));
			lecturer.setSurname(request.getParameter("surname"));
			lecturer.setAddress(request.getParameter("address"));
			lecturer.setAcademicDegree(request.getParameter("academicdegree"));
			lecturer.setPosition(request.getParameter("position"));
			FacultyDAO facultyDAO = new FacultyDAO();
			FacultyDTO faculty = facultyDAO.getEntity(Integer.parseInt(request.getParameter("facultyid")));
			lecturer.setFaculty(Arrays.asList(faculty));

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


			new UserDAO().insert(user);

			new LecturerDAO().insert(lecturer);
			faculty.getLecturer().add(lecturer);
			facultyDAO.update(faculty);

			request.setAttribute("msgshort", "Wykładowca dodany");
			request.setAttribute("msglong", "Nowy wykładowca został dodany");
			request.getRequestDispatcher("common/info.jsp").forward(request, response);
		}
		catch (RollbackException ex)
		{
			request.setAttribute("msgshort", "Błąd");
			request.setAttribute("msglong", "Login lub email jest już używany");
			request.getRequestDispatcher("common/info.jsp").forward(request, response);
		}
    }

}
