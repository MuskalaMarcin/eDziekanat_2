package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.StudentDTO;

/**
 * Servlet implementation class DeleteStudentsGroupController
 */
@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet
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
        StudentDAO studentDAO = new StudentDAO();
        try
        {
            StudentDTO student = studentDAO.getEntity(Integer.parseInt(request.getParameter("studentId")));
            studentDAO.remove(student);
            request.setAttribute("msgshort", "Usuniêto studenta");
            request.setAttribute("msglong", "Usuniêto studenta: " + student.getName()+" "+ student.getSurname());
            request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminstudents");
            request.getRequestDispatcher("common/info.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("msgshort", "B³±d");
            request.setAttribute("msglong", "Podczas usuwania studenta"
                    + " wyst±pi³ nieznany b³±d. Przepraszamy.");
            request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminstudents");
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }
        studentDAO.closeEntityManager();
    }

}
