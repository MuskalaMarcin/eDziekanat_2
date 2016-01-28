package edziekanat.controller.lecturer;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LearningMaterialsDAO;
import edziekanat.databasemodel.dto.LearningMaterialsDTO;

/**
 * Servlet used in deleting learning materials
 */
@WebServlet("/deletematerial")
public class DeleteMaterials extends HttpServlet
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
	String fileName = "brak pliku";
	try
	{
	    LearningMaterialsDAO lmDAO = new LearningMaterialsDAO();
	    LearningMaterialsDTO learningMaterial = lmDAO
		    .getEntity(Integer.parseInt(request.getParameter("materialId")));
	    fileName = learningMaterial.getName();
	    new File(learningMaterial.getFile()).delete();
	    lmDAO.remove(learningMaterial);

	    request.setAttribute("msgshort", "Usuniêto plik");
	    request.setAttribute("msglong", "Plik " + fileName + " zosta³ usuniêty z bazy danych.");
	    request.getRequestDispatcher("/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    request.setAttribute("msgshort", "B³¹d");
	    request.setAttribute("msglong",
		    "Podczas usuwania twojego pliku " + fileName + " wyst¹pi³ nieznany b³¹d. Przepraszamy.");
	    request.getRequestDispatcher("/error.jsp").forward(request, response);
	}

    }

}
