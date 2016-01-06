package edziekanat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.UserDAO;

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
	    request.getSession().setAttribute("loginBean", new UserDAO().getUser(request.getUserPrincipal().getName()));
	}
	catch (ServletException e)
	{
	    request.getSession().setAttribute("loginError", "true");
	}
	response.sendRedirect((String) request.getSession().getAttribute("backURL"));
    }

}
