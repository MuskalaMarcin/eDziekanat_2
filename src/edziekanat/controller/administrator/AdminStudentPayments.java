package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dao.StudentDAO;

/**
 * Servlet implementation class AdminStudentPayments
 */
@WebServlet("/adminstudentpayments")
public class AdminStudentPayments extends HttpServlet
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
	PaymentDAO paymentDAO = new PaymentDAO();
	StudentDAO studentDAO = new StudentDAO();

	Integer studentId = Integer.parseInt(request.getParameter("studentId"));

	request.setAttribute("studentPayments", paymentDAO.getAllStudentPayments(studentId));
	request.setAttribute("student", studentDAO.getEntity(studentId));

	request.getRequestDispatcher("administrator/studentpayments.jsp").forward(request, response);

	studentDAO.closeEntityManager();
	paymentDAO.closeEntityManager();
    }

}
