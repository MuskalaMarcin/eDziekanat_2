package edziekanat.controller.student;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.controller.common.ParentEnrollmentsController;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

@WebServlet("/studentacademicrecordcard")
public class AcademicRecordCard extends ParentEnrollmentsController
{
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	StudentDAO studentDAO = new StudentDAO();
	SubjectDAO subjectDAO = new SubjectDAO();
	Integer studentId = ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId();

	getStudentsEnrollments(studentDAO, studentId, subjectDAO, request);

	request.getRequestDispatcher("student/academicrecordcard.jsp").forward(request, response);
	subjectDAO.closeEntityManager();
	studentDAO.closeEntityManager();
    }
}
