package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

/**
 * Servlet implementation class AdminClassroomsController
 */
@WebServlet("/adminclassrooms")
public class ClassroomsController extends HttpServlet
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
    @SuppressWarnings("deprecation")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	Integer selectedClassroomId = Integer.parseInt(
		request.getParameter("classroomId") == null ? "-1" : request.getParameter("classroomId"));
	request.setAttribute("classroomsList", new ClassroomDAO().getAllEntities());
	if (selectedClassroomId == -1)
	{
	    request.setAttribute("noClassroom", true);
	}
	else
	{
	    ClassroomDTO selectedClassroom = new ClassroomDAO().getEntity(selectedClassroomId);
	    List<ScheduledClassesDTO> scheduledClassesList = selectedClassroom.getScheduledClasses();

	    Calendar calendar = Calendar.getInstance();
	    calendar.setFirstDayOfWeek(Calendar.MONDAY);
	    Date currentDate = calendar.getTime();

	    int selectedWeek = (request.getParameter("rqweek") == null ? calendar.get(Calendar.WEEK_OF_YEAR)
		    : (Integer.parseInt(request.getParameter("rqweek")) % 53 + 53) % 53);
	    request.setAttribute("currentWeek", selectedWeek == calendar.get(Calendar.WEEK_OF_YEAR));

	    long maxTimeDiff = 180 * 24 * 60 * 60 * 1000L; // 180 days
	    for (int i = 0; i < scheduledClassesList.size(); i++)
	    {
		Date classDate = scheduledClassesList.get(i).getDate();
		calendar.setTime(classDate);
		if ((Math.abs(currentDate.getTime() - classDate.getTime())) > maxTimeDiff
			|| calendar.get(Calendar.WEEK_OF_YEAR) != selectedWeek)
		{
		    scheduledClassesList.remove(i);
		    i--;
		}
	    }
	    if (scheduledClassesList.isEmpty())
	    {
		request.setAttribute("emptyWeek", true);
	    }
	    else
	    {
		Collections.sort(scheduledClassesList, (y, x) -> x.getDate().compareTo(y.getDate()));
		final List<Integer> hours = Arrays.asList(7, 9, 11, 12, 14, 16, 18, 19);
		final List<Integer> minutes = Arrays.asList(30, 15, 0, 45, 30, 15, 0, 45);
		calendar.setTime(new Date());
		calendar.set(Calendar.WEEK_OF_YEAR, selectedWeek);
		ScheduledClassesDTO[][] rsClasses = new ScheduledClassesDTO[5][8];
		List<Date> dayDates = new LinkedList<Date>();
		for (int i = 2; i < 7; i++)
		{
		    calendar.set(Calendar.DAY_OF_WEEK, i);
		    for (int j = 0; j < hours.size(); j++)
		    {
			calendar.set(Calendar.HOUR_OF_DAY, hours.get(j));
			calendar.set(Calendar.MINUTE, minutes.get(j));
			int z = 0;
			while (z < scheduledClassesList.size())
			{
			    ScheduledClassesDTO schedClass = scheduledClassesList.get(z);
			    if (schedClass.getDate().getDay() == calendar.getTime().getDay()
				    && schedClass.getDate().getHours() == calendar.getTime().getHours()
				    && schedClass.getDate().getMinutes() == calendar.getTime().getMinutes())
			    {
				rsClasses[i - 2][j] = schedClass;
				scheduledClassesList.remove(schedClass);
				break;
			    }
			    z++;
			}
		    }
		    dayDates.add(calendar.getTime());
		}
		request.setAttribute("rsClasses", rsClasses);
		request.setAttribute("emptyWeek", false);
		request.setAttribute("dayDates", dayDates);
	    }
	    request.setAttribute("selectedClassroom", selectedClassroom);
	    request.setAttribute("selectedWeek", selectedWeek);
	    request.setAttribute("noClassroom", false);
	}
	request.getRequestDispatcher("administrator/classrooms.jsp").forward(request, response);
    }

}
