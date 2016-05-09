package edziekanat.controller.common;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Marcin Muskala on 21.04.2016.
 */
@WebServlet("/classrooms")
public class ClassroomsController extends ParentTimetableController
{
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("deprecation")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ClassroomDAO classroomDAO = new ClassroomDAO();

	Integer selectedClassroomId = Integer.parseInt(
			request.getParameter("classroomId") == null ? "-1" : request.getParameter("classroomId"));
	LoginBean loginBean = ((LoginBean) request.getSession().getAttribute("loginBean"));

	request.setAttribute("classroomsList", classroomDAO.getLecturerClassrooms(loginBean.getPersonId()));

	if (selectedClassroomId == -1)
	{
	    request.setAttribute("noClassroom", true);
	}
	else
	{
	    ClassroomDTO selectedClassroom = classroomDAO.getEntity(selectedClassroomId);
	    List<ScheduledClassesDTO> scheduledClassesList = selectedClassroom.getScheduledClasses();

	    getClassesAndDates(request, scheduledClassesList);

	    request.setAttribute("selectedClassroom", selectedClassroom);
	    request.setAttribute("noClassroom", false);
	}

	if (request.isUserInRole("lecturer"))
	{
	    LecturerDAO lecturerDAO = new LecturerDAO();
	    LecturerDTO lecturerDTO = lecturerDAO.getEntity(loginBean.getPersonId());
	    request.setAttribute("subjects", lecturerDTO.getSubject());
	    request.getRequestDispatcher("lecturer/classrooms.jsp").forward(request, response);

	    lecturerDAO.closeEntityManager();
	}
	else if (request.isUserInRole("admin"))
	{
	    request.getRequestDispatcher("administrator/classrooms.jsp").forward(request, response);
	}

	classroomDAO.closeEntityManager();
    }
}
