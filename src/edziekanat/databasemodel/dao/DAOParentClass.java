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
	return Persistence.createEntityManagerFactory("dbper").createEntityManager();
    }

    protected T executeSingleResultQuery(String query)
    {
	return (T) entityManager.createNativeQuery(query, entityClass).getSingleResult();
    }

    protected List<T> executeMultiResultQuery(String query)
    {
	return entityManager.createNativeQuery(query, entityClass).getResultList();
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
	return (long) entityManager.createQuery("SELECT count(*) FROM " + tableName).getSingleResult();
    }

    public List<T> getMultipleEntities(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT * FROM " + tableName + " WHERE " + whereStmnt);
    }

    public List<T> getAllEntities()
    {
	return executeMultiResultQuery("SELECT * FROM " + tableName);
    }
    
    public void insert(T entity)
    {
	entityManager.getTransaction().begin();
	entityManager.persist(entity);
	entityManager.getTransaction().commit();
    }
    
    public void update(T entity)
    {
	entityManager.getTransaction().begin();
	entityManager.merge(entity);
	entityManager.getTransaction().commit();
    }
    
    public void remove(T entity)
    {
	entityManager.getTransaction().begin();
	entityManager.remove(entity);
	entityManager.getTransaction().commit();
    }
}
