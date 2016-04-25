package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.NewsDTO;

/**
 * Data access class used to perform operations on news entities.
 */
public class NewsDAO extends DAOParentClass<NewsDTO>
{
    public NewsDAO()
    {
	super(NewsDTO.class, TableNames.NEWS);
    }

    /**
     * Method getting one object of News entity.
     *
     * @param id Integer id value
     * @return NewsDTO object
     */
    public NewsDTO getEntity(Integer id)
    {
	return entityManager.find(NewsDTO.class, id);
    }
}
