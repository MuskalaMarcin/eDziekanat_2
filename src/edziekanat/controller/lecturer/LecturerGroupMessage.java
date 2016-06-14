package edziekanat.controller.lecturer;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.MessageDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Servlet used in getting all subjects taught by lecturer.
 */
@WebServlet("/lecturergroupmessage")
public class LecturerGroupMessage extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public LecturerGroupMessage()
    {
	super();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	if (request.getParameter("subject") != null)
	{
	    SubjectDAO subjectDAO = new SubjectDAO();
	    SubjectDTO subject = subjectDAO.getEntity(Integer.parseInt(request.getParameter("subject")));
	    List<StudentsGroupDTO> groups = subject.getStudents_group();
	    request.setAttribute("groups", groups);
	    request.getRequestDispatcher("lecturer/lecturergroupmessage").forward(request, response);
	    subjectDAO.closeEntityManager();
	}
	else if (request.getParameter("group") != null)
	{
	    UserDAO userDAO = new UserDAO();
	    MessageDAO messageDAO = new MessageDAO();
	    StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();
	    StudentsGroupDTO studentsGroup = studentsGroupDAO
			    .getEntity(Integer.parseInt(request.getParameter("group")));
	    List<StudentDTO> students = studentsGroup.getStudent();
	    for (StudentDTO student : students)
	    {
		MessageDTO newMessage = new MessageDTO();
		newMessage.setDispatchDate(Calendar.getInstance().getTime());
		newMessage.setReceiver(student.getUser());
		newMessage.setSender(userDAO.getEntity(
				((LoginBean) request.getSession().getAttribute("loginBean")).getLogin()));
		newMessage.setTitle(request.getParameter("msgtitle"));
		newMessage.setContent(request.getParameter("content"));
		newMessage.setGroup(studentsGroup);
		messageDAO.insert(newMessage);
	    }
	    userDAO.closeEntityManager();
	    messageDAO.closeEntityManager();
	    studentsGroupDAO.closeEntityManager();

	    request.setAttribute("msgshort", "Wys³ano wiadomo¶æ grupow±");
	    request.setAttribute("msglong",
			    "Twoja wiadomo¶æ grupowa zosta³a wys³ana do wszystkich cz³onków grupy " + request
					    .getParameter("group") + ".");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/sentmessages");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
    }

}
