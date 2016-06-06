package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deletesubject")
public class DeleteSubject extends HttpServlet
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
	SubjectDAO subDAO = new SubjectDAO();
	StudentsGroupDAO sgDAO = new StudentsGroupDAO();

	try
	{
	    SubjectDTO subDTO = subDAO.getEntity(Integer.parseInt(request.getParameter("subjectId")));
	    List<StudentsGroupDTO> sg = subDTO.getStudents_group();
	    for (StudentsGroupDTO studentsGroup : sg)
	    {
		List<SubjectDTO> subject = studentsGroup.getSubject();
		subject.remove(subDTO);
		studentsGroup.setSubject(subject);
		sgDAO.update(studentsGroup);
	    }
	    subDAO.remove(subDTO);

	    request.setAttribute("msgshort", "Usuniêto przedmiot");
	    request.setAttribute("msglong", "Usuniêto przedmiot: " + subDTO.getName());
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    request.setAttribute("msgshort", "B³±d");
	    request.setAttribute("msglong", "Podczas usuwania grupy studenckiej"
			    + " wyst±pi³ nieznany b³±d. Przepraszamy.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}

	sgDAO.closeEntityManager();
	subDAO.closeEntityManager();
    }

}
