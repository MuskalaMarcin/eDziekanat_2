package edziekanat.controller.administrator;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class PlanClassesController
 */
@WebServlet("/adminlockclassroom")
public class AdminBlockClassrooms extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	    doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ClassroomDAO classroomDAO = new ClassroomDAO();
        LoginBean loginBean = ((LoginBean) request.getSession().getAttribute("loginBean"));
        request.setAttribute("classrooms", classroomDAO.getLecturerClassrooms(loginBean.getPersonId()));
        classroomDAO.closeEntityManager();
	    request.getRequestDispatcher("administrator/lockclassroom.jsp").forward(request, response);
    }

}
