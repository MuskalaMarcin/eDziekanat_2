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

import edziekanat.controller.common.ParentTimetableController;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

/**
 * Servlet implementation class AdminTimetableController
 */
@WebServlet("/admintimetable")
public class AdminTimetableController extends ParentTimetableController
{
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("deprecation")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();
	ScheduledClassesDAO scheduledClassesDAO = new ScheduledClassesDAO();

	Integer selectedStudentsGroupId = Integer.parseInt(request.getParameter("studentsGroupId") == null ?"-1" :
					request.getParameter("studentsGroupId"));
	request.setAttribute("studentsGroupList", studentsGroupDAO.getAllEntities());
	if (selectedStudentsGroupId == -1)
	{
	    request.setAttribute("noStudentGroup", true);
	}
	else
	{
	    List<ScheduledClassesDTO> scheduledClassesList = scheduledClassesDAO.getStudentsGroupClasses(selectedStudentsGroupId);

	    getClassesAndDates(request, scheduledClassesList);
	    request.setAttribute("selectedStudentGroup", studentsGroupDAO.getEntity(selectedStudentsGroupId));
	    request.setAttribute("noStudentGroup", false);
	}
	request.getRequestDispatcher("administrator/timetable.jsp").forward(request, response);

	studentsGroupDAO.closeEntityManager();
	scheduledClassesDAO.closeEntityManager();
    }

}
