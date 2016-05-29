package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class DeleteStudentsGroupController
 */
@WebServlet("/movestudent")
public class MoveStudent extends HttpServlet
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
        StudentDTO student = studentDAO.getEntity(Integer.parseInt(request.getParameter("studentId")));
        StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();
        try
        {
            for(StudentsGroupDTO studentsGroup: student.getStudentsGroup())
            {
                studentsGroup.getStudent().remove(student);
                studentsGroupDAO.update(studentsGroup);
            }
            StudentsGroupDTO studentsGroup = studentsGroupDAO
                        .getEntity(Integer.parseInt(request.getParameter("studentsgroupid")));
            List<StudentsGroupDTO> list = new ArrayList<>();
            list.addAll(Arrays.asList(studentsGroup));
            student.setStudentsGroup(list);
            studentsGroup.getStudent().add(student);
            studentDAO.update(student);
            studentsGroupDAO.update(studentsGroup);
            request.setAttribute("msgshort", "Przeniesiono studenta");
            request.setAttribute("msglong", "Przeniesiono studenta: " + student.getName()+" "+ student.getSurname());
            request.getRequestDispatcher("common/info.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("errorshort", "B³±d");
            request.setAttribute("errorlong", "Podczas przenoszenia studenta wyst±pi³ nieznany b³±d. Przepraszamy.");
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }
        studentDAO.closeEntityManager();
        studentsGroupDAO.closeEntityManager();
    }

}
