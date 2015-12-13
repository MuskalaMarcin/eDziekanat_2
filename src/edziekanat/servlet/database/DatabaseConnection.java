package edziekanat.servlet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private String user, password;
    private Connection dbConnection;

    public DatabaseConnection(String user, String password)
    {
	this.user = user;
	this.password = password;
    }

    public boolean isConnected()
    {
	try
	{
	    return dbConnection.isValid(1000);
	}
	catch (NullPointerException | SQLException e)
	{
	    return false;
	}
    }

    public Connection getConnection()
    {
	return dbConnection;
    }

    public void establishConnection()
    {
	try
	{
	    String driver = "com.imaginary.sql.msql.MsqlDriver";
	    String url = "jdbc:msql://localhost:3306/edziekanat";
	    Class.forName(driver);
	    dbConnection = DriverManager.getConnection(url, user, password);
	}
	catch (ClassNotFoundException | SQLException e)
	{
	    System.out.println("database dbConnection not established!");
	    e.printStackTrace();
	}
    }
}
