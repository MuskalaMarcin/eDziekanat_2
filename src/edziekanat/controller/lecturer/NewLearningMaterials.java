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
 * Servlet used in adding new learning materials.
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
	LecturerDAO lecturerDAO = new LecturerDAO();
	Integer personId =((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId();

	request.setAttribute("subjects", lecturerDAO.getEntity(personId).getSubject());

	request.getRequestDispatcher("lecturer/newlearningmaterials.jsp").forward(request, response);

	lecturerDAO.closeEntityManager();
    }

}
