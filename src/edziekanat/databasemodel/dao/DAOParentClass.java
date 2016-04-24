package edziekanat.databasemodel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edziekanat.listener.StartupListener;

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
    protected String tableName;
    protected Class<T> entityClass;

    protected DAOParentClass(Class<T> clazz, String tableName)
    {
	this.entityClass = clazz;
	this.tableName = tableName;
	this.entityManager = createEntityManager();
	this.dtoClassName = this.getClass().getName().substring(29).replace("DAO", "DTO");
    }

    protected EntityManager createEntityManager()
    {
	return StartupListener.createEntityManager();
    }

    protected T executeSingleResultQuery(String query)
    {
	return (T) entityManager.createNativeQuery(query, entityClass).getSingleResult();
    }

    protected List<T> executeMultiResultQuery(String query)
    {
	return entityManager.createNativeQuery(query, entityClass).getResultList();
    }

    public void closeEntityManager()
    {
	entityManager.close();
    }

    public long getNumberOfAllEntities()
    {
	return (long) entityManager.createQuery("SELECT count(*) FROM " + tableName).getSingleResult();
    }

    public List<T> getMultipleEntities(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT * FROM " + tableName + " WHERE " + whereStmnt);
    }
    
    public T getSingleEntity(String whereStmnt)
    {
	return executeSingleResultQuery("SELECT * FROM " + tableName + " WHERE " + whereStmnt);
    }

    public List<T> getAllEntities()
    {
	return executeMultiResultQuery("SELECT * FROM " + tableName);
    }
    
    public void insert(T entity)
    {
	EntityTransaction et = entityManager.getTransaction();
	et.begin();
	entityManager.persist(entity);
	et.commit();
    }
    
    public void update(T entity)
    {
	EntityTransaction et = entityManager.getTransaction();
	et.begin();
	entityManager.merge(entity);
	et.commit();
    }
    
    public void remove(T entity)
    {
	EntityTransaction et = entityManager.getTransaction();
	et.begin();
	entityManager.remove(entity);
	et.commit();
    }
}
