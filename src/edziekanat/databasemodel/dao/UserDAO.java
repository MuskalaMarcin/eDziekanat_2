package edziekanat.databasemodel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import edziekanat.databasemodel.dto.UserDTO;

/**
 * Data access object used to perform operations on users.
 */
public class UserDAO extends DAOParentClass
{
    public UserDTO getUser(String login)
    {
	try
	{
	    ResultSet selectedUser = databaseConnection.getConnection().createStatement()
		    .executeQuery("select * from users where login='" + login + "';");
	    return new UserDTO(selectedUser.getString("login"), selectedUser.getString("password"),
		    selectedUser.getString("e_mail"), Integer.parseInt(selectedUser.getString("is_active")),
		    selectedUser.getString("user_role"), Integer.parseInt(selectedUser.getString("lecturer_id")),
		    Integer.parseInt(selectedUser.getString("student_id")),
		    Integer.parseInt(selectedUser.getString("administrator_id")));
	}
	catch (NumberFormatException | SQLException e)
	{
	    e.printStackTrace();
	}
	return null;
    }
}
