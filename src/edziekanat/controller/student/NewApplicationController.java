package edziekanat.controller.student;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Servlet implementation class NewApplicationController
 */
@WebServlet("/studentnewapplication")
public class NewApplicationController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewApplicationController()
    {
	super();
    }
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
	StudentDAO studentDAO = new StudentDAO();
	@SuppressWarnings("unchecked")
	List<AdministratorDTO> adminList = (List<AdministratorDTO>) request.getAttribute("adminList");
	ApplicationDTO newApplication = new ApplicationDTO();
	request.setAttribute("adminList", adminList);
	newApplication.setTitle(request.getParameter("title"));
	newApplication.setContent(request.getParameter("content"));
	newApplication.setDispatchDate(Calendar.getInstance().getTime());
	newApplication.setStatus("Nierozpatrzony");
	newApplication.setAdministrator(new AdministratorDAO().getEntity(Integer.parseInt(request.getParameter("id").toString())));
	newApplication.setStudent(
		studentDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
	new ApplicationDAO().insert(newApplication);
	
	request.setAttribute("msgshort", "Wniosek z³o¿ony");
	request.setAttribute("msglong", "Twój wniosek zosta³ wys³any");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
	
    }
    
}
