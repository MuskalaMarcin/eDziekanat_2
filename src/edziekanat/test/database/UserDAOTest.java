package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.UserDTO;

@WebServlet("/UserDAOTest")
public class UserDAOTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	out.println("ONE USER");
	UserDTO user = new UserDAO().getEntity("admin");
	out.println("<br>" + user.getLogin());
	out.println("<br>" + user.getPassword());
	out.println("<br>" + user.geteMail());
	out.println("<br>" + user.getUserRole());
	out.println("<br>" + user.getAdministratorId());
	out.println("<br>" + user.getLecturerId());
	out.println("<br>" + user.getStudentId());

	out.println("<p>ALL USERS");
	new UserDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getLogin());
	    out.println("<br>" + item.getPassword());
	    out.println("<br>" + item.geteMail());
	    out.println("<br>" + item.getUserRole());
	    out.println("<br>" + item.getAdministratorId());
	    out.println("<br>" + item.getLecturerId());
	    out.println("<br>" + item.getStudentId());
	    out.println("<br> nastepny");
	});
    }
}
