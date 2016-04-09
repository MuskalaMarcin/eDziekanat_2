package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.PaymentDTO;
/**
 * Servlet implementation class AdminNewPayment
 */
@WebServlet("/adminaddpayment")
public class AdminNewPayment extends HttpServlet
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
	PaymentDTO payment = new PaymentDTO();
	payment.setTitle(request.getParameter("title").toString());
	payment.setDescription(request.getParameter("description").toString());
	payment.setAmount(Float.parseFloat(request.getParameter("amount").toString()));
	payment.setIssueDate(Calendar.getInstance().getTime());
	payment.setStudent(new StudentDAO().getEntity(Integer.parseInt(request.getParameter("studentid"))));
	payment.setAdministrator(new AdministratorDAO().getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
	new PaymentDAO().insert(payment);
	
	request.setAttribute("msgshort", "Należność dodana");
	request.setAttribute("msglong", "Nowa naleeżność została dodana");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
