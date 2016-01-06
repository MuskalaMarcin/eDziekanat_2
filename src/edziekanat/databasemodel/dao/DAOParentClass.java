package edziekanat.databasemodel.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.sql.DataSource;

public abstract class DAOParentClass
{
    protected DataSource dataSource;
    protected EntityManager entityManager;

    public DAOParentClass()
    {
	entityManager = Persistence.createEntityManagerFactory("dbper").createEntityManager();
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
