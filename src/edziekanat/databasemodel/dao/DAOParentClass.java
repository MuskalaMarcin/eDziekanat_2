package edziekanat.databasemodel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
public abstract class DAOParentClass
{
    protected EntityManager entityManager;

    public DAOParentClass()
    {
	this.entityManager = createEntityManager();
    }

    protected EntityManager createEntityManager()
    {
	return Persistence.createEntityManagerFactory("dbper").createEntityManager();
    }
    
    protected <T> T executeSingleResultQuery(String query)
    {
	return (T) entityManager.createQuery(query).getSingleResult();
    }

    protected <T> List<T> executeMultiResultQuery(String query)
    {
	return entityManager.createQuery(query).getResultList();
    }
    
    protected void closeEntityManager()
    {
	entityManager.close();
    }

    protected long getNumberOfEntities(String entityName)
    {
	return (long) entityManager.createQuery("select count(*) from " + entityName).getSingleResult();
    }
}
