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
import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

@WebServlet("/adminstudentenrollments")
public class AdminStudentEnrollments extends HttpServlet
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
	List<EnrollmentDTO> enrollmentDTOs = new LinkedList<>();
	List<Integer> semesterList = new LinkedList<>();
	List<SubjectDTO> subjectDTOs = new LinkedList<>();
	StudentDAO studentDAO = new StudentDAO();
	StudentDTO studentDTO = studentDAO.getEntity(Integer.parseInt(request.getParameter("studentId")));
	List<TranscriptDTO> transcriptDTOs = studentDTO.getTranscript();
	for(TranscriptDTO transcriptDTO : transcriptDTOs)
	{
	    enrollmentDTOs.addAll(transcriptDTO.getEnrollment());
	}
	for (EnrollmentDTO enrollmentDTO : enrollmentDTOs)
	{
	    if (!semesterList.contains(enrollmentDTO.getSubject().getSemester()))
	    {
		semesterList.add(enrollmentDTO.getSubject().getSemester());
	    }

	    if (!subjectDTOs.contains(enrollmentDTO.getSubject()))
	    {
		subjectDTOs.add(enrollmentDTO.getSubject());
	    }
	}
	Collections.sort(semesterList);
	request.setAttribute("semesterList", semesterList);
	request.setAttribute("enrollments", enrollmentDTOs);
	request.setAttribute("subjects", subjectDTOs);
	request.setAttribute("student", studentDTO);
	request.getRequestDispatcher("administrator/studentsenrollments.jsp").forward(request, response);
	studentDAO.closeEntityManager();
    }
}
