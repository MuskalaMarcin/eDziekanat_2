package edziekanat.controller.student;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/studentacademicrecordcard")
public class AcademicRecordCard extends HttpServlet
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
	EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
	List<EnrollmentDTO> enrollments = enrollmentDAO.getAllStudentEnrollments(
			((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	List<Double> averages = new LinkedList<>();

	if (!enrollments.isEmpty())
	{
	    List<Integer> semesterList = new LinkedList<>();
	    for (EnrollmentDTO enrollment : enrollments)
	    {
		if (!semesterList.contains(enrollment.getSubject().getSemester()))
		{
		    semesterList.add(enrollment.getSubject().getSemester());
		}
	    }

	    request.setAttribute("enrollments", enrollments);
	    request.setAttribute("semesterList", semesterList);
	}

	request.getRequestDispatcher("student/academicrecordcard.jsp").forward(request, response);
	enrollmentDAO.closeEntityManager();
    }
}
