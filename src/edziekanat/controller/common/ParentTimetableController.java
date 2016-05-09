package edziekanat.controller.common;

import com.sun.deploy.net.HttpRequest;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import sun.util.resources.ar.CalendarData_ar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Marcin on 24.04.2016.
 */
public class ParentTimetableController extends HttpServlet
{
    protected static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    @SuppressWarnings("deprecated")
    protected void getClassesAndDates(HttpServletRequest request, List<ScheduledClassesDTO> scheduledClassesList)
    {
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
	    List<Date> dayDates = new LinkedList<>();
	    List<Date> classesStart = new LinkedList<>();
	    List<Date> classesEnd = new LinkedList<>();
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
		    if (i == 2)
		    {
			classesStart.add(calendar.getTime());
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			calendar.add(Calendar.MINUTE, 30);
			classesEnd.add(calendar.getTime());
		    }
		}
		dayDates.add(calendar.getTime());
	    }

	    generateCourseAndGroupsMsg(request, rsClasses);

	    request.setAttribute("classesStart", classesStart);
	    request.setAttribute("classesEnd", classesEnd);
	    request.setAttribute("rsClasses", rsClasses);
	    request.setAttribute("emptyWeek", false);
	    request.setAttribute("dayDates", dayDates);
	}

	request.setAttribute("selectedWeek", selectedWeek);
    }

    private void generateCourseAndGroupsMsg(HttpServletRequest request, ScheduledClassesDTO[][] rsClasses)
    {
	String[][] courses = new String[5][8];
	String[][] groups = new String[5][8];
	String[][] lecturers = new String[5][8];
	for (int i = 0; i < rsClasses.length; i++)
	{
	    for (int j = 0; j < rsClasses[i].length; j++)
	    {
		ScheduledClassesDTO classesDTO = rsClasses[i][j];
		if (classesDTO != null)
		{
		    List<StudentsGroupDTO> studentsGroupDTOList = classesDTO.getSubject().getStudents_group();
		    Set<CourseDTO> courseDTOList = studentsGroupDTOList.stream().map(StudentsGroupDTO::getCourse)
				    .collect(Collectors.toSet());
		    StringBuffer groupMsg = new StringBuffer();
		    if (studentsGroupDTOList.size() > 1)
		    {
			groupMsg.append("grupy: ");
			studentsGroupDTOList.forEach(sg -> groupMsg.append(sg.getId() + ", "));
			groupMsg.delete(groupMsg.length() - 2, groupMsg.length());
		    }
		    else
		    {
			groupMsg.append("grupa: " + studentsGroupDTOList.get(0).getId());
		    }
		    groups[i][j] = groupMsg.toString();
		    StringBuffer courseMsg = new StringBuffer();
		    if (courseDTOList.size() > 1)
		    {
			courseMsg.append("kierunki: ");
			courseDTOList.forEach(c -> courseMsg.append(c.getName() + ", "));
			courseMsg.delete(groupMsg.length() - 2, groupMsg.length());
		    }
		    else
		    {
			courseMsg.append("kierunek: " + courseDTOList.iterator().next().getName());
		    }
		    courses[i][j] = courseMsg.toString();

		    LecturerDTO lecturerDTO = classesDTO.getSubject().getLecturer();
		    lecturers[i][j] = "wyk³adowca: " + lecturerDTO.getName() + " " + lecturerDTO.getSurname();
		}
	    }
	}
	request.setAttribute("lecturers", lecturers);
	request.setAttribute("courses", courses);
	request.setAttribute("groups", groups);
    }
}
