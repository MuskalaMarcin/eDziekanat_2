package edziekanat.servlet.users;

import java.sql.Connection;
import java.sql.SQLException;

import edziekanat.servlet.database.TableTypes;

/**
 * Class handling user logging up to application panel.
 * 
 * @author Marcin Muskala
 */
public class UserLogin
{
    private String login;
    private String password;
    private boolean loggedIn;
    private UserType userType;
    private Connection connection;
    private AbstractUser user;

    public UserLogin(Connection connection)
    {
	this.connection = connection;
	this.loggedIn = false;
    }

    public void setLogin(String login)
    {
	this.login = login;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public boolean getLoginStatus()
    {
	return loggedIn;
    }

    public UserType getUserType()
    {
	return userType;
    }

    public AbstractUser getUser()
    {
	return user;
    }

    public void createNewUser()
    {
	switch (getUserType())
	{
	case ADMINISTRATOR:
	    user = new Administrator(login, password, userType);
	    break;
	case STUDENT:
	    user = new Student(login, password, userType);
	    break;
	case LECTURER:
	    user = new Lecturer(login, password, userType);
	    break;
	}
    }

    private boolean getUserTypeFromQuery() throws SQLException
    {
	if (!connection.prepareStatement("SELECT * FROM " + TableTypes.ADMINISTRATOR + " WHERE login = '" + login + "'")
		.executeQuery().wasNull())
	{
	    userType = UserType.ADMINISTRATOR;
	}
	else if (!connection.prepareStatement("SELECT * FROM " + TableTypes.LECTURER + " WHERE login = '" + login + "'")
		.executeQuery().wasNull())
	{
	    userType = UserType.LECTURER;
	}
	else if (!connection.prepareStatement("SELECT * FROM " + TableTypes.STUDENT + " WHERE login = '" + login + "'")
		.executeQuery().wasNull())
	{
	    userType = UserType.STUDENT;
	}
	return userType != null;
    }

    public boolean login() throws SQLException
    {
	if (getUserTypeFromQuery())
	{
	    String getPassword;
	    TableTypes userTable = null;
	    switch (userType)
	    {
	    case ADMINISTRATOR:
		userTable = TableTypes.ADMINISTRATOR;
		break;
	    case LECTURER:
		userTable = TableTypes.LECTURER;
		break;
	    case STUDENT:
		userTable = TableTypes.STUDENT;
		break;
	    }
	    getPassword = "SELECT 'Haslo' FROM '" + userTable + "' WHERE 'Login' = '" + login + "'";
	    loggedIn = connection.prepareStatement(getPassword).executeQuery().getString(0).equals(password);
	}
	return getLoginStatus();
    }
}
