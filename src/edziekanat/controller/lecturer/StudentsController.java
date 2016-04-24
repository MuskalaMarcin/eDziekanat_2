package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet used in getting all students taught by the lecturer.
 */
@WebServlet("/lecturerseestudents")
public class StudentsController extends HttpServlet
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
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<StudentDTO> students = (List<StudentDTO>) request.getAttribute("students");
	if (students == null)
	{
	    if (request.getParameter("subjectId") == null)
	    {
		LecturerDAO lecturerDAO = new LecturerDAO();

		students = lecturerDAO
				.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId())
				.getSubject().stream()
				.map(SubjectDTO::getStudents_group).flatMap(s -> s.stream())
				.map(StudentsGroupDTO::getStudent).flatMap(s -> s.stream())
				.collect(Collectors.toList());
		request.setAttribute("students", removeDuplicates(students));
		request.getRequestDispatcher("lecturer/students").forward(request, response);

		lecturerDAO.closeEntityManager();
	    }
	    else
	    {
		SubjectDAO subjectDAO = new SubjectDAO();

		SubjectDTO subject = subjectDAO
				.getEntity(Integer.parseInt(request.getParameter("subjectId").toString()));

		students = subject.getStudents_group().stream().map(StudentsGroupDTO::getStudent)
				.flatMap(s -> s.stream()).collect(Collectors.toList());

		request.setAttribute("subject", subject);
		request.setAttribute("students", removeDuplicates(students));
		request.getRequestDispatcher("lecturer/students").forward(request, response);

		subjectDAO.closeEntityManager();
	    }
	}
    }

    /**
     * Removes duplicated students, then sorts them by surname.
     *
     * @param students
     * @return
     */
    private List<StudentDTO> removeDuplicates(List<StudentDTO> students)
    {
	Collections.sort(students, (x, y) -> x.getUser().getLogin().compareTo(y.getUser().getLogin()));
	for (int i = 1; i < students.size(); i++)
	{
	    StudentDTO previous = students.get(i - 1);
	    StudentDTO next = students.get(i);
	    if (previous.getUser().getLogin().equals(next.getUser().getLogin()))
	    {
		students.remove(previous);
		i--;
	    }
	}
	Collections.sort(students, (x, y) -> x.getSurname().compareTo(y.getSurname()));
	return students;
    }

}
