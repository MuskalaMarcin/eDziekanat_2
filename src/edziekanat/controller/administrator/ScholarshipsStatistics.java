package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class ScholarshipsStatistics
 */
@WebServlet("/scholarshipstatistics")
public class ScholarshipsStatistics extends HttpServlet
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
	ScholarshipDAO scholarshipDAO = new ScholarshipDAO();
	FacultyDAO facultyDAO = new FacultyDAO();

	List<ScholarshipDTO> scholarships = scholarshipDAO.getAllEntities();
	List<FacultyDTO> faculties = facultyDAO.getAllEntities();
	List<LinkedList<String>> results = new LinkedList<LinkedList<String>>();
	for (FacultyDTO faculty : faculties)
	{
	    LinkedList<String> partialResult = new LinkedList<String>();
	    Integer schlNumber = 0;
	    Float schlAmount = 0F;
	    for (ScholarshipDTO scholarship : scholarships)
	    {
		for (StudentsGroupDTO sg : scholarship.getStudent().getStudentsGroup())
		{
		    if (sg.getCourse().getFaculty().getId().equals(faculty.getId()))
		    {
			schlAmount += scholarship.getScholarshipType().getAmount();
			schlNumber++;
		    }
		}
	    }
	    partialResult.add(faculty.getName());
	    partialResult.add(schlNumber.toString());
	    partialResult.add(String.valueOf(Math.round(schlAmount / schlNumber)));
	    results.add(partialResult);
	}

	scholarshipDAO.closeEntityManager();
	facultyDAO.closeEntityManager();

	request.setAttribute("schlByFaculty", results);
	request.getRequestDispatcher("administrator/scholarshipstatistics.jsp").forward(request, response);
    }

}
