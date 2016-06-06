package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.FacultyDTO;

@WebServlet("/adminaddclassroom")
public class AddNewClassroom extends HttpServlet
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
	FacultyDAO facultyDAO = new FacultyDAO();
	ClassroomDAO classroomDAO = new ClassroomDAO();
	if (request.getParameter("addToDatabase") == null)
	{
	    List<FacultyDTO> faculties = facultyDAO.getAllEntities();
	    List<String> types = Arrays.asList("Aula", "Sala dydaktyczna", "Laboratorium", "Laboratorium komputerowe");
	    request.setAttribute("faculties", faculties);
	    request.setAttribute("types", types);
	    request.getRequestDispatcher("administrator/newclassroom.jsp").forward(request, response);
	}
	else
	{
	    ClassroomDTO classroomDTO = new ClassroomDTO();
	    Integer classNumber = Integer.parseInt(request.getParameter("number"));
	    Integer capacity = Integer.parseInt(request.getParameter("capacity"));
	    FacultyDTO facultyDTO = facultyDAO.getEntity(Integer.parseInt(request.getParameter("facultyId")));

	    if (isNumberAlreadyExistsInFaculty(facultyDTO, classNumber))
	    {
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Sala o numerze " + classNumber
				+ " ju¿ istnieje na wydziale: " + facultyDTO.getName());
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else if (classNumber < 0 || capacity < 0)
	    {
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Numer sali i pojemno¶æ musz± byæ liczbami dodatnimi");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else
	    {
		classroomDTO.setAvailable(true);
		classroomDTO.setCapacity(capacity);
		classroomDTO.setFaculty(facultyDTO);
		classroomDTO.setType(request.getParameter("type"));
		classroomDTO.setNumber(classNumber);
		classroomDAO.insert(classroomDTO);

		request.setAttribute("msgshort", "Dodano salê.");
		request.setAttribute("msglong", "Sala o numerze " + request.getParameter("number")
				+ " zosta³a dodana do wydzia³u " + facultyDTO.getName());
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	}
	facultyDAO.closeEntityManager();
	classroomDAO.closeEntityManager();
    }

    private boolean isNumberAlreadyExistsInFaculty(FacultyDTO facultyDTO, Integer classroomNumber)
    {
	for (ClassroomDTO classroomDTO : facultyDTO.getClassroom())
	{
	    if (classroomDTO.getNumber().equals(classroomNumber))
	    {
		return true;
	    }
	}
	return false;
    }

}
