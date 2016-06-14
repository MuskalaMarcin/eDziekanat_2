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
	PaymentDAO paymentDAO = new PaymentDAO();
	StudentDAO studentDAO = new StudentDAO();
	AdministratorDAO administratorDAO = new AdministratorDAO();

	PaymentDTO payment = new PaymentDTO();
	payment.setTitle(request.getParameter("title"));
	payment.setDescription(request.getParameter("description"));
	payment.setAmount(Float.parseFloat(request.getParameter("amount")));
	payment.setIssueDate(Calendar.getInstance().getTime());
	payment.setStudent(studentDAO.getEntity(Integer.parseInt(request.getParameter("studentid"))));
	payment.setAdministrator(administratorDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
	paymentDAO.insert(payment);

	request.setAttribute("msgshort", "Nale¿no¶æ dodana");
	request.setAttribute("msglong", "Nowa nale¿no¶æ zosta³a dodana");
	request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminpayments");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	paymentDAO.closeEntityManager();
	studentDAO.closeEntityManager();
	administratorDAO.closeEntityManager();
    }

}
