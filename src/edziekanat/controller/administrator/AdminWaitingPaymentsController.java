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
	List<PaymentDTO> paymentsAdmin = new LinkedList<PaymentDTO>();
	paymentsAdmin = paymentsAdmin = new PaymentDAO()
		.getWaitingAdminPayments(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	if (request.getParameter("studentId") != null)
	{
	    List<PaymentDTO> paymentsStudent = new LinkedList<PaymentDTO>();
	    paymentsStudent = new PaymentDAO().getAllStudentPayments(Integer.parseInt(request.getParameter("studentId")));
	    paymentsAdmin.retainAll(paymentsStudent);
	}
	
	request.setAttribute("waitingPayments", paymentsAdmin);

	request.getRequestDispatcher("administrator/waitingpayments.jsp").forward(request, response);
    }

}
