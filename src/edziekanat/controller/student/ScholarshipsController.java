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
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;

/**
 * Servlet showing active sholarships for student.
 */
@WebServlet("/studentscholarships")
public class ScholarshipsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScholarshipsController()
    {
	super();
    }

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
	ScholarshipDAO scholarshipDAO = new ScholarshipDAO();
	List<ScholarshipDTO> scholarships = scholarshipDAO.getActiveStudentScholarships(
			((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());

	if (!scholarships.isEmpty())
	{
	    List<String> adminNames = getAdminNames(scholarships);
	    request.setAttribute("adminNames", adminNames);
	    request.setAttribute("ownscholarships", scholarships);
	}

	scholarshipDAO.closeEntityManager();
	request.getRequestDispatcher("student/scholarships").forward(request, response);
    }

    private List<String> getAdminNames(List<ScholarshipDTO> allScholarships)
    {
	List<String> userNames = new LinkedList<String>();
	allScholarships.forEach(scholarship -> {
	    AdministratorDTO admin = null;
	    admin = scholarship.getAdministrator();
	    userNames.add(admin.getName() + " " + admin.getSurname());
	});
	return userNames;
    }
}
