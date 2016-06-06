package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

@WebServlet("/adminstudentmarks")
public class AdminStudentsMarks extends HttpServlet
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<PartialMarkDTO> partialMarkDTOs = new LinkedList<>();
	List<Integer> semesterList = new LinkedList<>();
	List<SubjectDTO> subjectDTOs = new LinkedList<>();
	StudentDAO studentDAO = new StudentDAO();
	StudentDTO studentDTO = studentDAO.getEntity(Integer.parseInt(request.getParameter("studentId")));
	List<TranscriptDTO> transcriptDTOs = studentDTO.getTranscript();
	for(TranscriptDTO transcriptDTO : transcriptDTOs)
	{
	    partialMarkDTOs.addAll(transcriptDTO.getPartial_mark());
	}
	for (PartialMarkDTO partialMarkDTO : partialMarkDTOs)
	{
	    if (!semesterList.contains(partialMarkDTO.getSubject().getSemester()))
	    {
		semesterList.add(partialMarkDTO.getSubject().getSemester());
	    }

	    if (!subjectDTOs.contains(partialMarkDTO.getSubject()))
	    {
		subjectDTOs.add(partialMarkDTO.getSubject());
	    }
	}
	Collections.sort(semesterList);
	request.setAttribute("semesterList", semesterList);
	request.setAttribute("partialMarks", partialMarkDTOs);
	request.setAttribute("subjects", subjectDTOs);
	request.setAttribute("student", studentDTO);
	request.getRequestDispatcher("administrator/studentsmarks.jsp").forward(request, response);
	studentDAO.closeEntityManager();
    }
}
