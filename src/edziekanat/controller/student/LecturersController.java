package edziekanat.controller.student;

import edziekanat.bean.LoginBean;
import edziekanat.bean.student.LecturerBean;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	Integer personId = ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId();

	List<LecturerDTO> lecturers = studentDAO.getEntity(personId).getStudentsGroup().stream()
			.map(StudentsGroupDTO::getSubject).flatMap(s -> s.stream()).map(SubjectDTO::getLecturer)
			.distinct().sorted(Comparator.comparing(LecturerDTO::getSurname)).collect(Collectors.toList());

	request.setAttribute("lecturers", lecturers);
	request.getRequestDispatcher("student/lecturers").forward(request, response);

	studentDAO.closeEntityManager();
    }
}
