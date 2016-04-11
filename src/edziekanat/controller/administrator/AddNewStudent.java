package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.PasswordUtils;

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
	StudentDTO student = new StudentDTO();
	student.setName(request.getParameter("name"));
	student.setSurname(request.getParameter("surname"));
	student.setAddress(request.getParameter("address"));
	student.setAcademicDegree(request.getParameter("academicdegree"));
	StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();
	StudentsGroupDTO studentsGroup = studentsGroupDAO
			.getEntity(Integer.parseInt(request.getParameter("studentsgroupid")));
	student.setStudentsGroup(Arrays.asList(studentsGroup));
	new StudentDAO().insert(student);
	studentsGroup.getStudent().add(student);
	studentsGroupDAO.update(studentsGroup);

	UserDTO user = new UserDTO();
	user.setActive(1);
	user.seteMail(request.getParameter("email"));
	user.setLogin(request.getParameter("login"));
	String salt = PasswordUtils.generateSalt();
	user.setSalt(salt);
	user.setPassword(PasswordUtils.getSHA512PasswordHash(request.getParameter("password"), salt));
	user.setUserRole("student");
	user.setStudent(student);
	new UserDAO().insert(user);

	request.setAttribute("msgshort", "Student dodany");
	request.setAttribute("msglong", "Nowy student został dodany");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);
    }

}
