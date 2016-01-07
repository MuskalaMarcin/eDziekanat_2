package edziekanat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginaction")
public class LoginController extends HttpServlet
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
	request.getSession().setMaxInactiveInterval(3600);
	try
	{
	    request.login((String) request.getParameter("username"), (String) request.getParameter("password"));
	    request.getSession().setAttribute("loginBean", getLoginBean(request));
	}
	catch (ServletException e)
	{
	    request.getSession().setAttribute("loginError", "true");
	}
	response.sendRedirect((String) request.getSession().getAttribute("backURL"));
    }

    private LoginBean getLoginBean(HttpServletRequest request)
    {
	UserDTO user = new UserDAO().getUser(request.getUserPrincipal().getName());
	switch (user.getUserRole())
	{
	case "admin":
	    AdministratorDTO admin = new AdministratorDAO().getAdministrator(user.getAdministratorId());
	    return new LoginBean(user.getLogin(), user.geteMail(), user.isActive(), user.getUserRole(),
		    user.getAdministratorId(), admin.getName(), admin.getSurname(), admin.getAddress(),
		    admin.getAcademicDegree());
	case "student":
	    StudentDTO student = new StudentDAO().getStudent(user.getStudentId());
	    return new LoginBean(user.getLogin(), user.geteMail(), user.isActive(), user.getUserRole(),
		    user.getStudentId(), student.getName(), student.getSurname(), student.getAddress(),
		    student.getAcademicDegree());
	case "lecturer":
	    LecturerDTO lecturer = new LecturerDAO().getLecturer(user.getLecturerId());
	    return new LoginBean(user.getLogin(), user.geteMail(), user.isActive(), user.getUserRole(),
		    user.getLecturerId(), lecturer.getName(), lecturer.getSurname(), lecturer.getAddress(),
		    lecturer.getAcademicDegree());
	default:
	    return null;
	}
    }
}
