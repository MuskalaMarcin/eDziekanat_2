package edziekanat.controller.common;

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

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

/**
 * Servlet implementation class TimetableController
 */
@WebServlet("/timetable")
public class TimetableController extends ParentTimetableController
{
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("deprecation")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ScheduledClassesDAO scheduledClassesDAO = new ScheduledClassesDAO();

	List<ScheduledClassesDTO> scheduledClassesList = null;
	if (request.isUserInRole("student"))
	{
	    scheduledClassesList = scheduledClassesDAO
		    .getStudentsClasses(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	}
	else if (request.isUserInRole("lecturer"))
	{
	    scheduledClassesList = scheduledClassesDAO
		    .getLecturersClasses(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	}

	getClassesAndDates(request, scheduledClassesList);

	if (request.isUserInRole("student"))
	    request.getRequestDispatcher("student/timetable.jsp").forward(request, response);
	else if (request.isUserInRole("lecturer"))
	    request.getRequestDispatcher("lecturer/timetable.jsp").forward(request, response);

	scheduledClassesDAO.closeEntityManager();
    }

}
