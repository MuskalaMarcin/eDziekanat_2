package edziekanat.controller.student;

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
import edziekanat.bean.student.LecturerBean;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet getting all lecturers that teach the student.
 */
@WebServlet("/studentlecturers")
public class LecturersController extends HttpServlet
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
	StudentDAO studentDAO = new StudentDAO();

	List<LecturerBean> lecturers = studentDAO
			.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId())
			.getStudentsGroup().stream().map(g -> g.getSubject()).flatMap(s -> s.stream()).map(s -> {
			    LecturerDTO lecturer = s.getLecturer();
			    return new LecturerBean(lecturer.getUser().getLogin(), s.getName(),
					    lecturer.getName(), lecturer.getSurname(), lecturer.getUser().geteMail(),
					    lecturer.getPosition(), lecturer.getAcademicDegree());
			}).collect(Collectors.toList());

	studentDAO.closeEntityManager();
	request.setAttribute("lecturers", removeDuplicates(lecturers));
	request.getRequestDispatcher("student/lecturers").forward(request, response);
    }

    /**
     * Removes duplicated lecturers and adds subjects to list, then sorts them by surname.
     *
     * @param lecturers
     * @return
     */
    private List<LecturerBean> removeDuplicates(List<LecturerBean> lecturers)
    {
	Collections.sort(lecturers, (x, y) -> x.getLogin().compareTo(y.getLogin()));
	for (int i = 1; i < lecturers.size(); i++)
	{
	    LecturerBean previous = lecturers.get(i - 1);
	    LecturerBean next = lecturers.get(i);
	    if (previous.getLogin().equals(next.getLogin()))
	    {
		String subject = lecturers.get(i).getSubject();
		next.setSubject(subject.concat(", " + previous.getSubject()));
		lecturers.remove(previous);
		i--;
	    }
	}
	Collections.sort(lecturers, (x, y) -> x.getSurname().compareTo(y.getSurname()));
	return lecturers;
    }
}
