package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.LecturerDTO;

/**
 * Servlet getting all lecturers that teach the student.
 */
@WebServlet("/lecturerseelecturers")
public class SeeLecturersController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeLecturersController()
    {
	super();
    }

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
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	LecturerDAO lecturerDAO = new LecturerDAO();

	List<LecturerDTO> lecturers = new LinkedList<LecturerDTO>();
	if (request.getParameter("lecturers") == null)
	{
	    Integer personId = ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId();

	    for (FacultyDTO faculty : lecturerDAO.getEntity(personId).getFaculty())
	    {
		lecturers.addAll(faculty.getLecturer());
	    }
	}
	else
	{
	    lecturers = (List<LecturerDTO>) request.getAttribute("lecturers");
	}

	request.setAttribute("lecturers", removeDuplicates(lecturers));
	request.getRequestDispatcher("lecturer/lecturers").forward(request, response);

	lecturerDAO.closeEntityManager();
    }

    /**
     * Removes duplicated administrators, then sorts them by surname.
     *
     * @param lecturers
     * @return
     */
    private List<LecturerDTO> removeDuplicates(List<LecturerDTO> lecturers)
    {
	Collections.sort(lecturers, (x, y) -> x.getUser().getLogin().compareTo(y.getUser().getLogin()));
	for (int i = 1; i < lecturers.size(); i++)
	{
	    LecturerDTO previous = lecturers.get(i - 1);
	    LecturerDTO next = lecturers.get(i);
	    if (previous.getUser().getLogin().equals(next.getUser().getLogin()))
	    {
		lecturers.remove(previous);
		i--;
	    }
	}
	Collections.sort(lecturers, (x, y) -> x.getSurname().compareTo(y.getSurname()));
	return lecturers;
    }

}
