package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dto.PaymentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ApplyPayments
 */
@WebServlet("/sendreminder")
public class SendReminder extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	PaymentDAO paymentDAO = new PaymentDAO();
	PaymentDTO payment = paymentDAO.getEntity(Integer.parseInt(request.getParameter("paymentId")));

	request.setAttribute("payment", payment);

	request.getRequestDispatcher("admin/sendreminder").forward(request, response);
	paymentDAO.closeEntityManager();
    }

}
