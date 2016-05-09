package edziekanat.controller.student;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet providing applications send by student.
 */
@WebServlet("/studentmydata")
public class MyDataController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public MyDataController()
    {
	super();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	/*
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
	*/
	request.getRequestDispatcher("student/my_data").forward(request, response);

	//applicationDAO.closeEntityManager();
    }

}
