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
import edziekanat.databasemodel.dto.StudentDTO;

/**
 * Servlet implementation class LecturerSearchStudent
 */
@WebServlet("/lecturersearchstudents")
public class LecturerSearchStudent extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerSearchStudent()
    {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	String name = request.getParameter("searchedName").toString();
	String surname = request.getParameter("searchedSurname").toString();
	if (!name.equals(""))
	{
	    List<StudentDTO> students = new StudentDAO().getStudentsByNameAndSurname(name, surname);
	    request.setAttribute("students", removeDuplicates(students));
	    request.getRequestDispatcher("lecturer/students").forward(request, response);
	}
	else
	{
	    List<StudentDTO> students = new StudentDAO().getStudentsBySurname(surname);
	    request.setAttribute("students", removeDuplicates(students));
	    request.getRequestDispatcher("lecturer/students").forward(request, response);
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
