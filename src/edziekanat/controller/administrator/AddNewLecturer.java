package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
	LecturerDTO lecturer = new LecturerDTO();
	lecturer.setName(request.getParameter("name").toString());
	lecturer.setSurname(request.getParameter("surname").toString());
	lecturer.setAddress(request.getParameter("address").toString());
	lecturer.setAcademicDegree(request.getParameter("academicdegree").toString());
	lecturer.setPosition(request.getParameter("position").toString());
	List<FacultyDTO> faculty = new LinkedList<FacultyDTO>();
	faculty.add(new FacultyDAO().getEntity(Integer.parseInt(request.getParameter("facultyid").toString())));
	lecturer.setFaculty(faculty);

	UserDTO user = new UserDTO();
	user.setActive(1);
	user.setLecturer(lecturer);
	user.seteMail(request.getParameter("email").toString());
	user.setLogin(request.getParameter("login").toString());
	user.setPassword(request.getParameter("password").toString());
	user.setUserRole("lecturer");
	lecturer.setUser(user);
	new UserDAO().insert(user);
	new LecturerDAO().insert(lecturer);

	request.setAttribute("msgshort", "Wyk³adowca dodany");
	request.setAttribute("msglong", "Nowy wyk³adowca zosta³ dodany");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
