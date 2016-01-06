package edziekanat.databasemodel.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DAOParentClass
{
    protected DataSource dataSource;

    public DAOParentClass()
    {
	try
	{
	    dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/edziekanat");
	}
	catch (NamingException e)
	{
	    e.printStackTrace();
	}
    }
}
