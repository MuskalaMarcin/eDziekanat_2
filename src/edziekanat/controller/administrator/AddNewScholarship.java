package edziekanat.controller.administrator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dao.ScholarshipTypeDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.ScholarshipDTO;

/**
 * Servlet implementation class AddNewScholarship
 */
@WebServlet("/adminaddscholarship")
public class AddNewScholarship extends HttpServlet
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
	ScholarshipDTO scholarship = new ScholarshipDTO();
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

	scholarship.setGrantDate(Calendar.getInstance().getTime());
	scholarship.setScholarshipType(
		new ScholarshipTypeDAO().getScholarshipByType(request.getParameter("type").toString()));
	scholarship.setStudentId(new StudentDAO().getEntity(Integer.parseInt(request.getParameter("studentid"))));
	scholarship.setAdministratorId(new AdministratorDAO().getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
	try
	{
	    scholarship.setEndDate(format.parse(request.getParameter("endDate")));
	}
	catch (ParseException e)
	{
	    request.setAttribute("msgshort", "B³±d");
	    request.setAttribute("msglong",
		    "Podano b³êdn± datê. Proszê spróbowaæ ponownie.");
	}
	new ScholarshipDAO().insert(scholarship);
	
	request.setAttribute("msgshort", "Stypendium przyznane");
	request.setAttribute("msglong", "Stypendium zosta³o przyznane");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
