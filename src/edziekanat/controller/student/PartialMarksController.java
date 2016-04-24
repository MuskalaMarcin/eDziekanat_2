package edziekanat.controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.PartialMarkDAO;

/**
 * Servlet used in showing partial marks of the student.
 */
@WebServlet("/studentpartialmarks")
public class PartialMarksController extends HttpServlet
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
	PartialMarkDAO partialMarkDAO = new PartialMarkDAO();
	request.setAttribute("partialMarks", partialMarkDAO.getStudentMarksFromSubject(
		((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId(),
		Integer.parseInt(request.getParameter("subjectId"))));

	request.setAttribute("semesterList",
		request.getParameter("semesterList").replaceAll("\\[", "").replaceAll("\\]", "").split(","));
	request.getRequestDispatcher("/student/partialmarks.jsp").forward(request, response);

	partialMarkDAO.closeEntityManager();
    }

}
