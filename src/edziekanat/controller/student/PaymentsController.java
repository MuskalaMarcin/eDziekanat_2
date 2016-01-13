package edziekanat.controller.student;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.PaymentDTO;

/**
 * Servlet implementation class PaymentsController
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
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");

	List<PaymentDTO> payments = new PaymentDAO()
		.getMultipleEntities("student_id = '" + loginBean.getPersonId() + "'");
	Collections.sort(payments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));

	if (!payments.isEmpty())
	{
	    request.setAttribute("ownpayments", payments);
	}
	request.getRequestDispatcher("student/payments").forward(request, response);
    }

}
