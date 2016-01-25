package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentDTO;

/**
 * Servlet implementation class LecturerSearchStudent
 */
@WebServlet("/adminsearchstudents")
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
	String name = request.getParameter("searchedName").toString();
	String surname = request.getParameter("searchedSurname").toString();
	Integer studentsGroupId = Integer
		.parseInt(request.getParameter("studentsGroupId").isEmpty() ? "-1" : request.getParameter("subjectId"));
	if (studentsGroupId == -1)
	{
	    if (name.isEmpty())
	    {
		request.setAttribute("students", removeDuplicates(new StudentDAO().getStudentsBySurname(surname)));
	    }
	    else
	    {
		request.setAttribute("students",
			removeDuplicates(new StudentDAO().getStudentsByNameAndSurname(name, surname)));
	    }
	}
	else
	{
	    if (name.isEmpty())
	    {
		request.setAttribute("students",
			removeDuplicates(new StudentDAO().searchStudentsInStudentsGroup(surname, studentsGroupId)));
	    }
	    else
	    {
		request.setAttribute("students", removeDuplicates(
			new StudentDAO().searchStudentsInStudentsGroup(name, surname, studentsGroupId)));
	    }
	    request.setAttribute("studentsGroup", new StudentsGroupDAO().getEntity(studentsGroupId));
	}
	request.getRequestDispatcher("administrator/students.jsp").forward(request, response);
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
