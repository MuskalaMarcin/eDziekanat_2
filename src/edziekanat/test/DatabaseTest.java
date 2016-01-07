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
	System.out.println("ONE USER");
	UserDTO user = new UserDAO().getUser(request.getUserPrincipal().getName());
	System.out.println("\t" + user.getLogin());
	System.out.println("\t" + user.getPassword());
	System.out.println("\t" + user.geteMail());
	System.out.println("\t" + user.getUserRole());
	System.out.println("\t" + user.getAdministratorId());
	System.out.println("\t" + user.getLecturerId());
	System.out.println("\t" + user.getStudentId());

	System.out.println("ALL USERS");
	new UserDAO().getAllUsers().forEach(item -> {
	    System.out.println("\t" + item.getLogin());
	    System.out.println("\t" + item.getPassword());
	    System.out.println("\t" + item.geteMail());
	    System.out.println("\t" + item.getUserRole());
	    System.out.println("\t" + item.getAdministratorId());
	    System.out.println("\t" + item.getLecturerId());
	    System.out.println("\t" + item.getStudentId());
	});

	System.out.println("ONE ADMIN");
	AdministratorDTO admin = new AdministratorDAO().getAdministrator(1);
	System.out.println("\t" + admin.getName());
	System.out.println("\t" + admin.getPosition());
	System.out.println("\t" + admin.getAddress());
	System.out.println("\t" + admin.getSurname());
	System.out.println("\t" + admin.getId());
	System.out.println("\t" + admin.getUniversity_id());

	System.out.println("ALL ADMINS");
	new AdministratorDAO().getAllAdministrators().forEach(item -> {
	    System.out.println("\t" + item.getName());
	    System.out.println("\t" + item.getPosition());
	    System.out.println("\t" + item.getAddress());
	    System.out.println("\t" + item.getSurname());
	    System.out.println("\t" + item.getId());
	    System.out.println("\t" + item.getUniversity_id());
	});

    }

}
