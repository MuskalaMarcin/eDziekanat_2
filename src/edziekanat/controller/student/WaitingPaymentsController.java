package edziekanat.controller.student;

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
 * Servlet implementation class WaitingPaymentsController
 */
@WebServlet("/studentwaitingpayments")
public class WaitingPaymentsController extends HttpServlet
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
	List<PaymentDTO> waitingPayments = new PaymentDAO()
		.getWaitingPayments(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	if (!waitingPayments.isEmpty())
	{
	    List<String> adminLogins = new LinkedList<String>();
	    waitingPayments.forEach(pmnt -> {
		adminLogins.add(pmnt.getAdministrator().getUser().getLogin());
	    });
	    request.setAttribute("waitingPayments", waitingPayments);
	    request.setAttribute("adminLogins", adminLogins);
	}
	
	request.getRequestDispatcher("student/waiting_payments").forward(request, response);
    }

}
