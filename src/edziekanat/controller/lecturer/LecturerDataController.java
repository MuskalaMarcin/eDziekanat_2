package edziekanat.controller.lecturer;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dto.LecturerDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet providing applications send by student.
 */
@WebServlet("/lecturermydata")
public class LecturerDataController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public LecturerDataController()
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
	Object save = request.getParameter("save");
	Object edit = request.getParameter("edit");
	LecturerDAO lecturerDAO = new LecturerDAO();
	LecturerDTO lecturer = lecturerDAO
			.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	if (lecturer != null)
	{
	    request.setAttribute("lecturerData", lecturer);
	    request.setAttribute("editing", "false");
	}
	if (save != null)
	{
	    lecturer.setName(request.getParameter("name"));
	    lecturer.setSurname(request.getParameter("surname"));
	    lecturer.setAddress(request.getParameter("address"));
	    lecturer.getUser().seteMail(request.getParameter("email"));
	    lecturer.setConsultationInfo(request.getParameter("consultationInfo"));
	    lecturer.setWebsite(request.getParameter("website"));
	    lecturerDAO.update(lecturer);
	    LoginBean newBean = (LoginBean) request.getSession().getAttribute("loginBean");
	    newBean.setName(request.getParameter("name"));
	    newBean.setSurname(request.getParameter("surname"));
	    newBean.setAddress(request.getParameter("address"));
	    newBean.seteMail(request.getParameter("email"));
	    request.getSession().setAttribute("loginBean", newBean);
	    request.setAttribute("editing", "false");
	}
	else if (edit != null)
	{
	    request.setAttribute("editing", "true");
	}
	lecturerDAO.closeEntityManager();
	request.getRequestDispatcher("lecturer/lecturer_my_data").forward(request, response);
    }

}
