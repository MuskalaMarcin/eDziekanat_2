package edziekanat.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class DatabaseTest
 */
@WebServlet("/test")
public class DatabaseTest extends HttpServlet
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
	System.out.println("LOGIN BEAN");
	UserDTO loginBean = (UserDTO) request.getSession().getAttribute("loginBean");
	System.out.println(loginBean.getLogin());
	System.out.println(loginBean.geteMail());

	System.out.println("ONE USER");
	UserDTO user = new UserDAO().getUser(request.getUserPrincipal().getName());
	System.out.println(user.getLogin());
	System.out.println(user.getPassword());
	System.out.println(user.geteMail());
	System.out.println(user.getUserRole());
	System.out.println(user.getAdministratorId());
	System.out.println(user.getLecturerId());
	System.out.println(user.getStudentId());

	System.out.println("MULTIPLE USERS");
	new UserDAO().getAllUsers().forEach(item -> {
	    System.out.println(item.getLogin());
	    System.out.println(item.getPassword());
	    System.out.println(item.geteMail());
	    System.out.println(item.getUserRole());
	    System.out.println(item.getAdministratorId());
	    System.out.println(item.getLecturerId());
	    System.out.println(item.getStudentId());
	});

	System.out.println("ONE ADMIN");
	AdministratorDTO admin = new AdministratorDAO().getAdministrator(1);
	System.out.println(admin.getName());
	System.out.println(admin.getPosition());
	System.out.println(admin.getAddress());
	System.out.println(admin.getSurname());
	System.out.println(admin.getId());
	System.out.println(admin.getUniversity_id());

	System.out.println("MULTIPLE ADMINS");
	new AdministratorDAO().getAllAdministrators().forEach(item -> {
	    System.out.println(admin.getName());
	    System.out.println(item.getPosition());
	    System.out.println(item.getAddress());
	    System.out.println(item.getSurname());
	    System.out.println(item.getId());
	    System.out.println(item.getUniversity_id());
	});

    }

}
