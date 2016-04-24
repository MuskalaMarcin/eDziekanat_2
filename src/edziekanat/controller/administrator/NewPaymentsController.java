package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;

/**
 * Servlet implementation class AddPaymentsController
 */
@WebServlet("/adminaddpayments")
public class NewPaymentsController extends HttpServlet
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
	Integer studentId = Integer
		.parseInt(request.getParameter("studentId")==null ? "-1" : request.getParameter("studentId"));
	if (studentId == -1)
	{
	    request.setAttribute("selectedStudent", false);
	    request.setAttribute("studentsList", studentDAO.getAllEntities());
	}
	else
	{
	    request.setAttribute("selectedStudent", true);
	    request.setAttribute("student", studentDAO.getEntity(studentId));
	}
	request.getRequestDispatcher("administrator/newpayment.jsp").forward(request, response);

	studentDAO.closeEntityManager();
    }

}
