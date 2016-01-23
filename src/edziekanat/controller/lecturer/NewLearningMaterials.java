package edziekanat.controller.lecturer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.LecturerDAO;

/**
 * Servlet implementation class AddLearningMaterials
 */
@WebServlet("/newlearningmaterials")
public class NewLearningMaterials extends HttpServlet
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
	request.setAttribute("subjects", new LecturerDAO()
		.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()).getSubject());
	request.getRequestDispatcher("lecturer/newlearningmaterials.jsp").forward(request, response);
    }

}
