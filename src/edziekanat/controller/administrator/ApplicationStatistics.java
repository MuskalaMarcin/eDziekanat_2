package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class ApplicationStatistics
 */
@WebServlet("/applicationsstatistics")
public class ApplicationStatistics extends HttpServlet
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
	ApplicationDAO applicationDAO = new ApplicationDAO();
	FacultyDAO facultyDAO = new FacultyDAO();

	List<ApplicationDTO> applications = applicationDAO.getAllEntities();
	List<FacultyDTO> faculties = facultyDAO.getAllEntities();
	List<LinkedList<String>> results = new LinkedList<LinkedList<String>>();
	for (FacultyDTO faculty : faculties)
	{
	    LinkedList<String> partialResult = new LinkedList<String>();
	    Integer appNumber = 0;
	    Integer accepted = 0;
	    Integer waiting = 0;
	    Integer rejected = 0;
	    for (ApplicationDTO application : applications)
	    {
		for (StudentsGroupDTO sg : application.getStudent().getStudentsGroup())
		{
		    if (sg.getCourse().getFaculty().getId().equals(faculty.getId()))
		    {
			switch (application.getStatus())
			{
			case "Odrzucony":
			    rejected++;
			    break;
			case "Przyjety":
			    accepted++;
			    break;
			case "Nierozpatrzony":
			    waiting++;
			    break;
			}
			appNumber++;
		    }
		}
	    }
	    partialResult.add(faculty.getName());
	    partialResult.add(appNumber.toString());
	    partialResult.add(accepted.toString());
	    partialResult.add(waiting.toString());
	    partialResult.add(rejected.toString());
	    results.add(partialResult);
	}

	request.setAttribute("appsByFaculty", results);
	request.getRequestDispatcher("administrator/aplicationsstatistics.jsp").forward(request, response);

	facultyDAO.closeEntityManager();
	applicationDAO.closeEntityManager();
    }

}
