package edziekanat.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.servlet.database.DatabaseConnection;
import edziekanat.servlet.users.AbstractUser;
import edziekanat.servlet.users.UserLogin;

/**
 * Servlet implementation class main
 */
@WebServlet("/ServletMain")
public class ServletMain extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private DatabaseConnection dbConnection;
    @SuppressWarnings("unused")
    private AbstractUser user;
    private UserLogin userLogin;

    /**
     * Servlet class constructor.
     */
    public ServletMain()
    {
	super();
	this.dbConnection = new DatabaseConnection("root", "");
	dbConnection.establishConnection();
	userLogin = new UserLogin(dbConnection.getConnection());
    }

    /**
     * Method handling GET communication.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    /**
     * Method handling POST communication.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	if (userLogin.getLoginStatus())
	{

	}
	else
	{
	    if (request.getParameter("operation").equals("logmein"))
	    {
		try
		{
		    userLogin.setLogin(request.getParameter("login"));
		    userLogin.setPassword(request.getParameter("password"));
		    if (userLogin.login())
		    {
			user = userLogin.getUser();
			response.getOutputStream().print("login"+userLogin.getUserType());
		    }
		    else
		    {
			response.getOutputStream().print("loginerror");
		    }
		}
		catch (SQLException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    else
	    {
		response.getWriter().println("notloggedin");
	    }

	}
    }
}
