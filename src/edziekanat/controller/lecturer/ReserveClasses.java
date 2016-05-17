package edziekanat.controller.lecturer;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.ReservationRequestDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.ReservationRequestDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Marcin Muska³a on 09.05.2016.
 */
@WebServlet("/reserveclasses")
public class ReserveClasses extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ReservationRequestDAO reservationRequestDAO = new ReservationRequestDAO();
	SubjectDAO subjectDAO = new SubjectDAO();
	ClassroomDAO classroomDAO = new ClassroomDAO();

	try
	{
	    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
	    Integer repeat = Integer.parseInt(request.getParameter("repeat"));
	    Integer startTime = Integer.parseInt(request.getParameter("startTime"));
	    Date startDate = format.parse(request.getParameter("startDate"));
	    Date endDate = null;
	    String endDateString = request.getParameter("endDate");
	    if (!StringUtils.isEmpty(endDateString) && repeat > 0)
	    {
		endDate = format.parse(endDateString);
	    }

	    SubjectDTO subject = subjectDAO.getEntity(Integer.parseInt(request.getParameter("subjectId")));
	    ClassroomDTO classroom = classroomDAO.getEntity(Integer.parseInt(request.getParameter("classroomId")));

	    if (reservationRequestDAO.insertNewReservation(subject, classroom, startDate, endDate, repeat, startTime))
	    {
		request.setAttribute("successMsg", "Nowa rezerwacja zosta³a utworzona.");
	    }
	    else
	    {
		request.setAttribute("errorMsg", "Sala jest ju¿ zajêta w podanych godzinach.");
	    }
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    request.setAttribute("errorMsg", "Podczas tworzenia nowej rezerwacji wyst±pi³ b³±d.");
	}

	request.setAttribute("classroomId", request.getAttribute("classroomId"));
	request.setAttribute("rqweek", request.getAttribute("rqweek"));
	request.getRequestDispatcher("/classrooms").forward(request, response);

	reservationRequestDAO.closeEntityManager();
	subjectDAO.closeEntityManager();
	classroomDAO.closeEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}
