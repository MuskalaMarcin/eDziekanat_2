package edziekanat.controller.lecturer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin Muskala on 22.05.2016.
 */
@WebServlet("/settopic")
public class SetTopic extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ScheduledClassesDAO scheduledClassesDAO = new ScheduledClassesDAO();
	Gson gson = new Gson();

	String responseString;
	try
	{
	    JsonObject data = gson.fromJson(request.getReader(), JsonObject.class);
	    String previousTopic = data.get("previousTopic").getAsString();
	    String newTopic = data.get("newTopic").getAsString();
	    String classesId = data.get("classesId").getAsString();

	    if (!previousTopic.equals(newTopic))
	    {
		ScheduledClassesDTO scheduledClassesDTO = scheduledClassesDAO.getEntity(Integer.parseInt(classesId));
		scheduledClassesDTO.setTopic(newTopic);
		scheduledClassesDAO.update(scheduledClassesDTO);
	    }

	    responseString = newTopic;
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    responseString = "error";
	}

	scheduledClassesDAO.closeEntityManager();
	response.setContentType("application/json");
	response.setCharacterEncoding("ISO-8859-2");
	response.getWriter().write(gson.toJson(responseString));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}
