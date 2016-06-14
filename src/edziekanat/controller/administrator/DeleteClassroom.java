package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteclassroom")
public class DeleteClassroom extends HttpServlet
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
	ClassroomDAO classroomDAO = new ClassroomDAO();
	ClassroomDTO classroomDTO = classroomDAO.getEntity(Integer.parseInt(request.getParameter("classroomId")));
	if (classroomDTO.getScheduledClasses().size() > 0)
	{
	    request.setAttribute("errorshort", "B��d");
	    request.setAttribute("errorlong", "Nie mo�na usun�� sali na kt�rej zaplanowane s� zaj�cia!");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminlockclassroom");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	else
	{
	    classroomDAO.remove(classroomDTO);
	    request.setAttribute("msgshort", "Usuni�to klas�");
	    request.setAttribute("msglong", "Usuni�to klas� o numerze: " + classroomDTO.getNumber()
			    + " z wydzia�u: " + classroomDTO.getFaculty().getName());
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminlockclassroom");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	classroomDAO.closeEntityManager();
    }
}
