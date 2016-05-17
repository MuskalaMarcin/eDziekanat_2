package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.PaymentDTO;
import edziekanat.databasemodel.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

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
		//if(request.getParameter("send") == null) {
			PaymentDAO paymentDAO = new PaymentDAO();
			PaymentDTO payment = paymentDAO.getEntity(Integer.parseInt(request.getParameter("paymentId")));

			request.setAttribute("payment", payment);

			request.getRequestDispatcher("admin/sendreminder").forward(request, response);
			paymentDAO.closeEntityManager();
		/*
		}
		else
		{
			StudentDAO studentDAO = new StudentDAO();
			StudentDTO student = studentDAO.getEntity(Integer.parseInt(request.getParameter("recieverID")));
			String content = request.getParameter("content");
			String title = request.getParameter("title");

			request.setAttribute("content",content);
			request.setAttribute("msgreceiver",student.getUser().getLogin());
			request.setAttribute("msgtitle",title);
			request.getRequestDispatcher("admin/sendmessage").forward(request, response);
			studentDAO.closeEntityManager();
		}
		*/
    }

}
