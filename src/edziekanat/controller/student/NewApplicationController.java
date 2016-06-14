package edziekanat.controller.student;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.Application_typeDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Servlet inserting new application into database.
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
	AdministratorDAO administratorDAO = new AdministratorDAO();
	Application_typeDAO application_typeDAO = new Application_typeDAO();
	StudentDAO studentDAO = new StudentDAO();

	List<AdministratorDTO> adminList = (List<AdministratorDTO>) request.getAttribute("adminList");
	ApplicationDTO newApplication = new ApplicationDTO();
	request.setAttribute("adminList", adminList);
	newApplication.setTitle(request.getParameter("title"));
	newApplication.setContent(request.getParameter("content"));
	newApplication.setDispatchDate(Calendar.getInstance().getTime());
	newApplication.setStatus("Nierozpatrzony");

	newApplication.setAdministrator(
			administratorDAO.getEntity(Integer.parseInt(request.getParameter("id"))));

	newApplication.setApplication_type(
			application_typeDAO.getEntity(Integer.parseInt(request.getParameter("type"))));

	newApplication.setStudent(studentDAO.getEntity(
					((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));

	applicationDAO.insert(newApplication);
	
	request.setAttribute("msgshort", "Wniosek z³o¿ony");
	request.setAttribute("msglong", "Twój wniosek zosta³ wys³any");
    	request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/studentapplications");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	studentDAO.closeEntityManager();
	application_typeDAO.closeEntityManager();
	administratorDAO.closeEntityManager();
	applicationDAO.closeEntityManager();
    }

}
