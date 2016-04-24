package edziekanat.controller.student;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Servlet providing applications send by student.
 */
@WebServlet("/studentapplications")
public class ApplicationsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationsController()
    {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ApplicationDAO applicationDAO = new ApplicationDAO();
	List<ApplicationDTO> applications = applicationDAO
			.getApplications(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	Collections.sort(applications, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));

	if (!applications.isEmpty())
	{
	    List<String> adminLogins = applications.stream().map(a -> a.getAdministrator().getUser().getLogin())
			    .collect(Collectors.toList());

	    request.setAttribute("ownapplications", applications);
	    request.setAttribute("adminLogins", adminLogins);
	}

	request.getRequestDispatcher("student/applications").forward(request, response);

	applicationDAO.closeEntityManager();
    }

}
