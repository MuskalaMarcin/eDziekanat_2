package edziekanat.controller.student;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Servlet showing waiting applications for the student.
 */
@WebServlet("/studentwaitingapplications")
public class WaitingApplicationsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<ApplicationDTO> waitingApplications = new ApplicationDAO()
		.getWaitingApplications(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	if (!waitingApplications.isEmpty())
	{
	    List<String> adminLogins = new LinkedList<String>();
	    waitingApplications.forEach(pmnt -> {
		adminLogins.add(pmnt.getAdministrator().getUser().getLogin());
	    });
	    request.setAttribute("waitingApplications", waitingApplications);
	    request.setAttribute("adminLogins", adminLogins);
	}
	
	request.getRequestDispatcher("student/waiting_applications").forward(request, response);
    }
}
