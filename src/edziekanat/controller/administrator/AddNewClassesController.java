package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Servlet implementation class AddNewClassesController
 */
@WebServlet("/addnewclasses")
public class AddNewClassesController extends HttpServlet
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
	SubjectDAO subjectDAO = new SubjectDAO();
	ClassroomDAO classroomDAO = new ClassroomDAO();
	ScheduledClassesDAO scheduledClassesDAO = new ScheduledClassesDAO();

	SubjectDTO subject = subjectDAO.getEntity(Integer.parseInt(request.getParameter("subjectId")));
	ClassroomDTO classroom = classroomDAO.getEntity(Integer.parseInt(request.getParameter("classroomId")));
	Integer repeat = Integer.parseInt(request.getParameter("repeat"));
	DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
	Integer startTime = Integer.parseInt(request.getParameter("startTime"));
	Date startDate = null;
	try
	{
	    startDate = format.parse(request.getParameter("startDate"));
	}
	catch (ParseException e)
	{
	    request.setAttribute("errorshort", "B��d");
	    request.setAttribute("errorlong", "Wyst�pi� nieznany b��d podczas parsowania daty. Przepraszamy.");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	if (repeat == 0)
	{
	    if (!scheduledClassesDAO.insertNewClasses(subject, classroom, startDate, startTime))
	    {
		request.setAttribute("errorshort", "B��d");
		request.setAttribute("errorlong",
				"Sala jest ju� zaj�ta w godzinach kt�re postanowi�e� zarezerwowa� lub grupa ma ju� w tych godzinach zaj�cia. Spr�buj ponownie.");
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else
	    {
		request.setAttribute("msgshort", "Dodano nowe zaj�cia");
		request.setAttribute("msglong", "Dodano nowe zaplanowane zaj�cia z przedmiotu: " + subject.getName());
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	}
	else
	{
	    Date endDate = null;
	    try
	    {
		endDate = format.parse(request.getParameter("endDate"));
	    }
	    catch (ParseException e)
	    {
		request.setAttribute("errorshort", "B��d");
		request.setAttribute("errorlong",
				"W przypadku powtarzajacych si� zaj�� musisz okre�li� ich ko�cow� dat�. Spr�buj ponownie.");
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    if (startDate.after(endDate))
	    {
		request.setAttribute("errorshort", "B��d");
		request.setAttribute("errorlong",
				"W przypadku powtarzajacych si� zaj�� data zako�czenia powtarzania musi by� p�niejsza ni� rozpocz�cia. Spr�buj ponownie.");
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else if (!scheduledClassesDAO.insertNewRepeatedClasses(subject, classroom, repeat, startDate, endDate,
			    startTime))
	    {
		request.setAttribute("errorshort", "B��d");
		request.setAttribute("errorlong",
				"Sala jest ju� zaj�ta w godzinach kt�re postanowi�e� zarezerwowa� lub grupa ma ju� w tych godzinach zaj�cia. Spr�buj ponownie.");
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	    else
	    {
		request.setAttribute("msgshort", "Dodano nowe zaj�cia");
		request.setAttribute("msglong", "Dodano nowe zaplanowane zaj�cia z przedmiotu: " + subject.getName());
		request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/admintimetable");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);

	    }
	}

	scheduledClassesDAO.closeEntityManager();
	subjectDAO.closeEntityManager();
	classroomDAO.closeEntityManager();
    }

}
