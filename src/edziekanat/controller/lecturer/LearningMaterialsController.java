package edziekanat.controller.lecturer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.LearningMaterialsDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet used in showing actual added learning materials
 */
@WebServlet("/lecturerlearningmaterials")
public class LearningMaterialsController extends HttpServlet
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
	String subjectIdString = request.getParameter("subjectId");

	if (subjectIdString == null)
	{
	    LearningMaterialsDAO learningMaterialsDAO = new LearningMaterialsDAO();
	    request.setAttribute("learningMaterials",learningMaterialsDAO.getLecturerLearningMaterials(
			    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));

	    request.getRequestDispatcher("lecturer/learningmaterials.jsp").forward(request, response);

	    learningMaterialsDAO.closeEntityManager();
	}
	else
	{
	    SubjectDAO subjectDAO = new SubjectDAO();
	    SubjectDTO subject = subjectDAO.getEntity(Integer.parseInt(subjectIdString));
	    subjectDAO.closeEntityManager();
	    request.setAttribute("learningMaterials", subject.getLearningMaterials());
	    request.setAttribute("subject", subject);

	    request.getRequestDispatcher("lecturer/learningmaterials.jsp").forward(request, response);

	    subjectDAO.closeEntityManager();
	}

    }

}
