package edziekanat.controller.administrator;

import java.io.IOException;
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
	student.setName(request.getParameter("name").toString());
	student.setSurname(request.getParameter("surname").toString());
	student.setAddress(request.getParameter("address").toString());
	student.setAcademicDegree(request.getParameter("academicdegree").toString());
	List<StudentsGroupDTO> studentsgroup = new LinkedList<StudentsGroupDTO>();
	studentsgroup.add(new StudentsGroupDAO().getEntity(Integer.parseInt(request.getParameter("studentsgroupid").toString())));
	student.setStudentsGroup(studentsgroup);
	
	UserDTO user = new UserDTO();
	user.setActive(1);
	user.seteMail(request.getParameter("email").toString());
	user.setLogin(request.getParameter("login").toString());
	user.setPassword(request.getParameter("password").toString());
	user.setUserRole("lecturer");
	student.setUser(user);
	new UserDAO().insert(user);
	new StudentDAO().insert(student);

	request.setAttribute("msgshort", "Student dodany");
	request.setAttribute("msglong", "Nowy student został dodany");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
