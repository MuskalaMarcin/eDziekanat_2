package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.LearningMaterialsDTO;

/**
 * Data access class used to perform operations on learning_materials entities.
 */
public class LearningMaterialsDAO extends DAOParentClass<LearningMaterialsDTO>
{
    /**
     * Method getting one object of LearningMaterials entity.
     * 
     * @param id Integer id value
     * @return LearningMaterialsDTO object
     */
    public LearningMaterialsDTO getEntity(Integer id)
    {
	return entityManager.find(LearningMaterialsDTO.class, id);
    }
}
