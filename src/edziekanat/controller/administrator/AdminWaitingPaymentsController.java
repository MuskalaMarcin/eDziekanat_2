package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dto.PaymentDTO;

/**
 * Servlet implementation class AdminWaitingPaymentsController
 */
@WebServlet("/adminwaitingpayments")
public class AdminWaitingPaymentsController extends HttpServlet
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

	List<PaymentDTO> paymentsAdmin = paymentDAO.getWaitingAdminPayments(
			((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());

	String studentId = request.getParameter("studentId");

	if (studentId != null)
	{
	    List<PaymentDTO> paymentsStudent = paymentDAO.getAllStudentPayments(Integer.parseInt(studentId));
	    paymentsAdmin.retainAll(paymentsStudent);
	}

	paymentDAO.closeEntityManager();

	request.setAttribute("waitingPayments", paymentsAdmin);

	request.getRequestDispatcher("administrator/waitingpayments.jsp").forward(request, response);
    }

}
