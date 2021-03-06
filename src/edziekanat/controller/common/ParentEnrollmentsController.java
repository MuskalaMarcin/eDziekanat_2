package edziekanat.controller.common;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marcin Muska�a on 06.06.2016.
 */
public abstract class ParentEnrollmentsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    public void getStudentsEnrollments(StudentDAO studentDAO, Integer studentId, SubjectDAO subjectDAO, HttpServletRequest request)
    {
	StudentDTO studentDTO = studentDAO.getEntity(studentId);
	List<TranscriptDTO> transcriptDTOs = new LinkedList<>();
	HashMap<Integer, Integer> semesterToECTS = new HashMap<>();
	HashMap<TranscriptDTO, List<Integer>> transcriptToSemesterList = new HashMap<>();
	for (TranscriptDTO transcriptDTO : studentDTO.getTranscript())
	{
	    if (!transcriptDTO.getEnrollment().isEmpty())
	    {
		transcriptDTOs.add(transcriptDTO);
	    }
	    List<Integer> semesterList = new LinkedList<>();

	    for (int i = 1; i <= transcriptDTO.getStudentsGroup().getSemester(); i++)
	    {
		int sumEcts = 0;
		List<SubjectDTO> subjectDTOs = subjectDAO.getStudentsSubjectsFromSemester(studentId, i);
		if (!subjectDTOs.isEmpty())
		{
		    for (SubjectDTO subject : subjectDTOs)
		    {
			sumEcts += subject.getECTS();
		    }
		    semesterToECTS.put(i, sumEcts);
		    semesterList.add(i);
		}
	    }

	    if (!transcriptDTO.getEnrollment().isEmpty())
	    {
		transcriptToSemesterList.put(transcriptDTO, semesterList);
	    }
	}

	request.setAttribute("transcripts", transcriptDTOs);
	request.setAttribute("student", studentDTO);
	request.setAttribute("semesterToSumECTS", semesterToECTS);
	request.setAttribute("transcriptToSemesterList", transcriptToSemesterList);
    }
}
