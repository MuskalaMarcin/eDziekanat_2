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
 * Servlet implementation class LecturerLearningMaterialsController
 */
@WebServlet("/lecturerlearningmaterials")
public class LecturerLearningMaterialsController extends HttpServlet
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
	if (request.getParameter("subjectId") == null)
	{
	    request.setAttribute("learningMaterials", new LearningMaterialsDAO().getLecturerLearningMaterials(
		    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
	}
	else
	{
	    SubjectDTO subject = new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subjectId")));
	    request.setAttribute("learningMaterials", subject.getLearningMaterials());
	    request.setAttribute("subject", subject);
	}

	request.getRequestDispatcher("lecturer/learningmaterials.jsp").forward(request, response);
    }

}
