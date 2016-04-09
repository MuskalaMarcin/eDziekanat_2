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
	SubjectDTO subject = new SubjectDTO();
	subject.setName(request.getParameter("name").toString());
	subject.setSemester(Integer.parseInt(request.getParameter("semester").toString()));
	subject.setECTS(Integer.parseInt(request.getParameter("ECTS").toString()));
	subject.setLecturer(new LecturerDAO().getEntity(Integer.parseInt(request.getParameter("lecturerid").toString())));
	List<StudentsGroupDTO> studentsgroup = new LinkedList<StudentsGroupDTO>();
	studentsgroup.add(new StudentsGroupDAO().getEntity(Integer.parseInt(request.getParameter("studentsgroupid").toString())));
	subject.setStudents_group(studentsgroup);
	new SubjectDAO().insert(subject);
	
	request.setAttribute("msgshort", "Przedmiot dodany");
	request.setAttribute("msglong", "Nowa przedmiot został dodany");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
