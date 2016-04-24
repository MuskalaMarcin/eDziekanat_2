package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentDTO;

/**
 * Servlet used in searching students.
 */
@WebServlet("/lecturersearchstudents")
public class SearchStudent extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent()
    {
	super();
    }

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
	StudentDAO studentDAO = new StudentDAO();

	String name = request.getParameter("searchedName");
	String surname = request.getParameter("searchedSurname");
	String subjectIdString = request.getParameter("subjectId");
	Integer subjectId = Integer.parseInt(subjectIdString.isEmpty() ? "-1" : subjectIdString);

	List<StudentDTO> studentsList;
	if (subjectId == -1)
	{
	    if (name.isEmpty())
	    {
		studentsList = removeDuplicates(studentDAO.getStudentsBySurname(surname));
	    }
	    else
	    {
		studentsList = removeDuplicates(studentDAO.getStudentsByNameAndSurname(name, surname));
	    }

	    request.setAttribute("subject", studentsList);
	    request.getRequestDispatcher("lecturer/students").forward(request, response);
	}
	else
	{
	    if (name.isEmpty())
	    {
		studentsList = removeDuplicates(studentDAO.searchStudentsInSubject(surname, subjectId));
	    }
	    else
	    {
		studentsList = removeDuplicates(studentDAO.searchStudentsInSubject(name, surname, subjectId));
	    }

	    SubjectDAO subjectDAO = new SubjectDAO();
	    request.setAttribute("subject", subjectDAO.getEntity(subjectId));

	    request.setAttribute("subject", studentsList);
	    request.getRequestDispatcher("lecturer/students").forward(request, response);

	    subjectDAO.closeEntityManager();
	}

	studentDAO.closeEntityManager();
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
