package edziekanat.databasemodel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Abstract class containing common methods and fields for DAO classes.
 * 
 * @param <T> referenced DTO class
 */
@SuppressWarnings("unchecked")
public abstract class DAOParentClass<T>
{
    protected EntityManager entityManager;
    protected String dtoClassName;

    protected DAOParentClass()
    {
	this.entityManager = createEntityManager();
	this.dtoClassName = this.getClass().getName().substring(29).replace("DAO", "DTO");
    }

    protected EntityManager createEntityManager()
    {
	return Persistence.createEntityManagerFactory("dbper").createEntityManager();
    }

    protected T executeSingleResultQuery(String query)
    {
	return (T) entityManager.createQuery(query).getSingleResult();
    }

    protected List<T> executeMultiResultQuery(String query)
    {
	return entityManager.createQuery(query).getResultList();
    }

    protected void closeEntityManager()
    {
	entityManager.close();
    }

    public void persistEntity(T newEntity)
    {
	entityManager.persist(newEntity);
    }
    
    public long getNumberOfAllEntities()
    {
	return (long) entityManager.createQuery("SELECT count(*) FROM " + dtoClassName).getSingleResult();
    }

    public List<T> getMultipleEntities(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT e FROM " + dtoClassName + " e WHERE e." + whereStmnt);
    }

    public List<T> getAllEntities()
    {
	return executeMultiResultQuery("SELECT e FROM " + dtoClassName + " e");
    }
}
