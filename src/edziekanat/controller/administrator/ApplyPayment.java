package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dto.PaymentDTO;

/**
 * Servlet implementation class ApplyPayments
 */
@WebServlet("/applypayment")
public class ApplyPayment extends HttpServlet
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
	PaymentDTO payment = paymentDAO.getEntity(Integer.parseInt(request.getParameter("paymentId")));
	try
	{
	    payment.setPaymentDate(Calendar.getInstance().getTime());
	    paymentDAO.update(payment);

	    request.setAttribute("msgshort", "Zmieniono status p�atno�ci");
	    request.setAttribute("msglong", "Potwierdzono dokonanie p�atno�ci " + payment.getTitle());
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    request.setAttribute("msgshort", "B��d");
	    request.setAttribute("msglong", "Podczas zmiany statusu p�atno�ci " + payment.getTitle()
		    + " wyst�pi� nieznany b��d. Przepraszamy.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}

    }

}
