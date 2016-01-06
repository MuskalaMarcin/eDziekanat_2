package edziekanat.databasemodel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.dto.UserDTO;

/**
 * Data access object used to perform operations on users.
 */
public class UserDAO extends DAOParentClass
{
    public UserDAO()
    {
	super();
    }

    public UserDTO getUser(String login)
    {
	UserDTO user = entityManager.find(UserDTO.class, login);
	entityManager.close();
	return user;

	/*
	 * try { Connection connection = dataSource.getConnection(); ResultSet
	 * selectedUser = connection.createStatement() .executeQuery(
	 * "select * from users where login='" + login + "'");
	 * connection.close(); selectedUser.next(); return
	 * getOneUserDTO(selectedUser); } catch (SQLException e) {
	 * e.printStackTrace(); } return null;
	 */
    }

    public List<UserDTO> getMultipleUsers(String whereStmnt)
    {
	LinkedList<UserDTO> result = new LinkedList<UserDTO>();
	ResultSet selectedUser;
	try
	{
	    Connection connection = dataSource.getConnection();
	    selectedUser = connection.createStatement().executeQuery("select * from users where " + whereStmnt);
	    connection.close();
	    while (selectedUser.next())
	    {
		result.add(getOneUserDTO(selectedUser));
	    }
	}
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	return result;
    }

    private UserDTO getOneUserDTO(ResultSet queryResult) throws SQLException
    {
	String userRole = queryResult.getString("user_role");
	Integer personId = new Integer(-1);
	switch (userRole)
	{
	case "admin":
	    personId = Integer.parseInt(queryResult.getString("administrator_id"));
	    break;
	case "lecturer":
	    personId = Integer.parseInt(queryResult.getString("lecturer_id"));
	    break;
	case "student":
	    personId = Integer.parseInt(queryResult.getString("student_id"));
	    break;
	}
	return new UserDTO(queryResult.getString("login"), queryResult.getString("password"),
		queryResult.getString("e_mail"), Integer.parseInt(queryResult.getString("is_active")),
		queryResult.getString("user_role"), personId);
    }
}
