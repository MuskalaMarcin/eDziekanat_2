package edziekanat.controller.student;

import java.io.IOException;
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
 * Servlet showing to student history of payments.
 */
@WebServlet("/studentpayments")
public class PaymentsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentsController()
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
	List<PaymentDTO> historyPayments =  new PaymentDAO()
		.getPaymentsHistory(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	if(!historyPayments.isEmpty())
	{
	    request.setAttribute("historyPayments",historyPayments);
	}
	request.getRequestDispatcher("student/payments").forward(request, response);
    }

}
