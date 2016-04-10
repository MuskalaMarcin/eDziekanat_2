package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.Application_typeDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slivka on 10.04.2016.
 */
public class Application_typeDAO extends DAOParentClass<Application_typeDTO> {

    public Application_typeDAO(){super(Application_typeDTO.class, TableNames.APPLICATION_TYPE);}

    /**
     * Method getting one object of Application entity.
     *
     * @param type_id Integer id value
     * @return Application_typeDTO object
     */
    public Application_typeDTO getEntity(Integer type_id){return entityManager.find(Application_typeDTO.class,type_id);}

    /**
     * Method getting application type name by id
     *
     * @param type_id
     * @return
     */
    public Application_typeDTO getApplication_typeName(Integer type_id)
    {
        return getSingleEntity("type_id = '"+type_id+"'");
    }

    /**
     * Method returning all application types
     *
     * @return
     */
    public List<Application_typeDTO> getApplication_types()
    {
        return getAllEntities();
    }
}
