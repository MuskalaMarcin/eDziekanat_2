package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LearningMaterialsDAO;
import edziekanat.databasemodel.dto.LearningMaterialsDTO;

/**
 * Servlet implementation class LearningMaterialsDAOTest
 */
@WebServlet("/LearningMaterialsDAOTest")
public class LearningMaterialsDAOTest extends HttpServlet
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

	out.println("ONE LearningMaterials");
	LearningMaterialsDTO learningMaterials = new LearningMaterialsDAO().getEntity(1);
	out.println("<br>" + learningMaterials.getDescription());
	out.println("<br>" + learningMaterials.getName());
	out.println("<br>" + learningMaterials.getId());
	out.println("<br>" + learningMaterials.getSubjectId());
	out.println("<br>" + learningMaterials.getFile());

	out.println("<p>ALL LearningMaterialss");
	new LearningMaterialsDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getDescription());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getSubjectId());
	    out.println("<br>" + item.getFile());
	    out.println("<br> nastepny");
	});
    }
}
