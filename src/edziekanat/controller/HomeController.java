package edziekanat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet redirecting users visiting homepage to login page if they're not
 * logged in or specified for their role homepage.
 */
@WebServlet("/home")
public class HomeController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Not used GET method redirecting to POST.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * POST method redirecting user to selected homepage
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	if (request.isUserInRole("admin")) response.sendRedirect("admin");
	else if (request.isUserInRole("student")) response.sendRedirect("student");
	else if (request.isUserInRole("lecturer")) response.sendRedirect("lecturer");
    }

}
