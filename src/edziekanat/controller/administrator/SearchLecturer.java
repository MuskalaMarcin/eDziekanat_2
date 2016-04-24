package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dto.LecturerDTO;

/**
 * Servlet implementation class SearchLecturer
 */
@WebServlet("/adminsearchlecturers")
public class SearchLecturer extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLecturer()
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
	LecturerDAO lecturerDAO = new LecturerDAO();
	String name = request.getParameter("searchedName").toString();
	String surname = request.getParameter("searchedSurname").toString();

	List<LecturerDTO> lecturers;
	if (!name.isEmpty())
	{
	    lecturers = lecturerDAO.getLecturersByNameAndSurname(name, surname);
	}
	else
	{
	    lecturers = lecturerDAO.getLecturersBySurname(surname);
	}
	request.setAttribute("lecturers", removeDuplicates(lecturers));
	request.getRequestDispatcher("administrator/lecturers.jsp").forward(request, response);

	lecturerDAO.closeEntityManager();
    }

    /**
     * Removes duplicated lecturers, then sorts them by surname.
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
