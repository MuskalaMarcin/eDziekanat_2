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
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

/**
 * Servlet implementation class GetStatistics
 */
@WebServlet("/marksstatistics")
public class MarksStatistics extends HttpServlet
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
	List<TranscriptDTO> transcripts = new TranscriptDAO().getAllEntities();
	List<FacultyDTO> faculties = new FacultyDAO().getAllEntities();
	List<LinkedList<String>> results = new LinkedList<LinkedList<String>>();
	for (FacultyDTO faculty : faculties)
	{
	    LinkedList<String> partialResult = new LinkedList<String>();
	    Integer twoPartial = 0;
	    Integer threePartial = 0;
	    Integer fourPartial = 0;
	    Integer fivePartial = 0;
	    Integer twoEnrollment = 0;
	    Integer threeEnrollment = 0;
	    Integer fourEnrollment = 0;
	    Integer fiveEnrollment = 0;
	    for (CourseDTO course : faculty.getCourse())
	    {
		for (TranscriptDTO transcript : transcripts)
		{
		    if (transcript.getStudentsGroup().getCourse().getName().equals(course.getName()))
		    {
			for (PartialMarkDTO partialMark : transcript.getPartial_mark())
			{
			    Float mark = partialMark.getMark();
			    if (mark < 3)
				twoPartial++;
			    else if (mark < 4)
				threePartial++;
			    else if (mark < 5)
				fourPartial++;
			    else
				fivePartial++;
			}
			for (EnrollmentDTO enrollment : transcript.getEnrollment())
			{
			    Float mark = enrollment.getMark();
			    if (mark < 3)
				twoEnrollment++;
			    else if (mark < 4)
				threeEnrollment++;
			    else if (mark < 5)
				fourEnrollment++;
			    else
				fiveEnrollment++;
			}
		    }
		}
	    }

	    partialResult.add(faculty.getName());

	    partialResult.add(twoPartial.toString());
	    partialResult.add(threePartial.toString());
	    partialResult.add(fourPartial.toString());
	    partialResult.add(fivePartial.toString());
	    partialResult.add(String
		    .valueOf((float) ((twoPartial * 2) + (threePartial * 3) + (fourPartial * 4) + (fivePartial * 5))
			    / (twoPartial + threePartial + fourPartial + fivePartial)));

	    partialResult.add(twoEnrollment.toString());
	    partialResult.add(threeEnrollment.toString());
	    partialResult.add(fourEnrollment.toString());
	    partialResult.add(fiveEnrollment.toString());
	    partialResult.add(String
		    .valueOf((float) ((twoEnrollment * 2) + (threeEnrollment * 3) + (fourEnrollment * 4)
			    + (fiveEnrollment * 5))
			    / (twoEnrollment + threeEnrollment + fourEnrollment + fiveEnrollment)));

	    results.add(partialResult);
	}
	request.setAttribute("marksByFaculty", results);
	request.getRequestDispatcher("administrator/marksstatistics.jsp").forward(request, response);
    }

}
