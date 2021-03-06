package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet implementation class AddNewSubject
 */
@WebServlet("/adminaddsubject")
public class AddNewSubject extends HttpServlet
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
	LecturerDAO lecturerDAO = new LecturerDAO();
	StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();
	SubjectDAO subjectDAO = new SubjectDAO();

	SubjectDTO subject = new SubjectDTO();
	subject.setName(request.getParameter("name"));
	subject.setSemester(Integer.parseInt(request.getParameter("semester")));
	subject.setECTS(Integer.parseInt(request.getParameter("ECTS")));
	subject.setLecturer(lecturerDAO.getEntity(Integer.parseInt(request.getParameter("lecturerid"))));
	List<StudentsGroupDTO> studentsgroup = new LinkedList<>();
	studentsgroup.add(studentsGroupDAO.getEntity(Integer.parseInt(request.getParameter("studentsgroupid"))));
	subject.setStudents_group(studentsgroup);
	subjectDAO.insert(subject);
	studentsgroup.forEach(sg -> {
	    sg.getSubject().add(subject);
	    studentsGroupDAO.update(sg);
	});

	request.setAttribute("msgshort", "Przedmiot dodany");
	request.setAttribute("msglong", "Nowa przedmiot zosta� dodany");
	request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminsubjects");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	subjectDAO.closeEntityManager();
	lecturerDAO.closeEntityManager();
	studentsGroupDAO.closeEntityManager();
    }

}
