package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dto.PaymentDTO;

/**
 * Servlet implementation class PaymentDAOTest
 */
@WebServlet("/PaymentDAOTest")
public class PaymentDAOTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	out.println("ONE Payment");
	PaymentDTO payment = new PaymentDAO().getEntity(1);
	out.println("<br>" + payment.getAmount());
	out.println("<br>" + payment.getTitle());
	out.println("<br>" + payment.getAdministrator().getName());
	out.println("<br>" + payment.getId());
	out.println("<br>" + payment.getStudent().getName());
	out.println("<br>" + payment.getDescription());
	out.println("<br>" + payment.getIssueDate());
	out.println("<br>" + payment.getPaymentDate());

	out.println("<p>ALL Payments");
	new PaymentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAmount());
	    out.println("<br>" + item.getTitle());
	    out.println("<br>" + item.getAdministrator().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br>" + item.getDescription());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br>" + item.getPaymentDate());
	    out.println("<br> nastepny");
	});
    }
}
