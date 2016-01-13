package edziekanat.controller.student;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.MessageDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class ScholarshipController
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
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");

	List<ScholarshipDTO> scholarships = new ScholarshipDAO()
		.getMultipleEntities("student_id = '" + loginBean.getPersonId() + "'");
	Collections.sort(scholarships, (x, y) -> y.getEndDate().compareTo(x.getEndDate()));

	if (!scholarships.isEmpty())
	{
	    List<String> adminNames = getAdminNames(scholarships);
	    request.setAttribute("adminNames", adminNames);
	    request.setAttribute("ownscholarships", scholarships);
	}
	request.getRequestDispatcher("student/scholarships").forward(request, response);
    }

    private List<String> getAdminNames(List<ScholarshipDTO> allScholarships)
    {
	List<String> userNames = new LinkedList<String>();
	allScholarships.forEach(scholarship -> {
	AdministratorDTO admin = null;
	admin = scholarship.getAdministratorId();
	userNames.add(admin.getName() + " " + admin.getSurname());
	});
	return userNames;
}}
