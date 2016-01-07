package edziekanat;

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
public class DatabaseTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO user = new UserDAO().getUser(request.getUserPrincipal().getName());
		System.out.println(user.getLogin());
		System.out.println(user.getPassword());
		System.out.println(user.geteMail());
		System.out.println(user.getUserRole());
		System.out.println(user.getAdministratorId());
		System.out.println(user.getLecturerId());
		System.out.println(user.getStudentId());
		UserDTO loginBean = (UserDTO)request.getSession().getAttribute("loginBean");
		System.out.println(loginBean.getLogin());
		System.out.println(loginBean.geteMail());
		AdministratorDTO admin = new AdministratorDAO().getAdministrator(0);
		System.out.println(admin.getName());
		System.out.println(admin.getPosition());
		System.out.println(admin.getAddress());
		System.out.println(admin.getSurname());
		System.out.println(admin.getId());
		System.out.println(admin.getUniversity_id());
		
	}

}
