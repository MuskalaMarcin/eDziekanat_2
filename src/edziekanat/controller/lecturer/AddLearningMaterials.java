package edziekanat.controller.lecturer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edziekanat.databasemodel.dao.LearningMaterialsDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.LearningMaterialsDTO;

/**
 * Servlet used in adding new learning materials to database.
 */
@WebServlet("/addlearningmaterials")
@MultipartConfig
public class AddLearningMaterials extends HttpServlet
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
	String fileName = "no file";
	try
	{
	    Part filePart = request.getPart("newFile");
	    fileName = getSubmittedFileName(filePart);
	    File uploads = new File(getServletContext().getInitParameter("file-upload"));

	    File file = new File(uploads, fileName);

	    try (InputStream input = filePart.getInputStream();)
	    {
		Files.copy(input, file.toPath());
	    }
	    
	    LearningMaterialsDTO learningMaterials = new LearningMaterialsDTO();
	    learningMaterials.setDescription(request.getParameter("description"));
	    learningMaterials.setFile(file.toPath().toString());
	    learningMaterials.setName(request.getParameter("name"));
	    learningMaterials
		    .setSubject(new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subjectId"))));
	    new LearningMaterialsDAO().insert(learningMaterials);

	    request.setAttribute("msgshort", "Dodano plik");
	    request.setAttribute("msglong", "Nowy plik " + fileName + " zosta³ dodany do bazy danych.");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    request.setAttribute("msgshort", "B³±d");
	    request.setAttribute("msglong",
		    "Podczas dodawania twojego pliku " + fileName + " wystapi³ nieznany b³±d. Przepraszamy.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
    }

    private static String getSubmittedFileName(Part part)
    {
	for (String cd : part.getHeader("content-disposition").split(";"))
	{
	    if (cd.trim().startsWith("filename"))
	    {
		String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
		return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE
														    // fix.
	    }
	}
	return null;
    }

}
