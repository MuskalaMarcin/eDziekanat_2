package edziekanat.controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LearningMaterialsController
 */
@WebServlet("/studentlearningmaterials")
public class LearningMaterialsController extends HttpServlet
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
	//TODO: dodac wyswietlanie materialow dydaktycznych

	request.setAttribute("semesterList",
		request.getParameter("semesterList").replaceAll("\\[", "").replaceAll("\\]", "").split(","));
	request.getRequestDispatcher("/student/learningmaterials.jsp").forward(request, response);
    }

}
