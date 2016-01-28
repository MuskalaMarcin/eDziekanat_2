package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.LearningMaterialsDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Data access class used to perform operations on learning_materials entities.
 */
public class LearningMaterialsDAO extends DAOParentClass<LearningMaterialsDTO>
{
    public LearningMaterialsDAO()
    {
	super(LearningMaterialsDTO.class, TableNames.LEARNING_MATERIALS);
    }

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

    /**
     * Method getting list of lecturer's learning materials 
     * @param lecturerId
     * @return
     */
    public List<LearningMaterialsDTO> getLecturerLearningMaterials(Integer lecturerId)
    {
	List<LearningMaterialsDTO> learningMaterials = new LinkedList<LearningMaterialsDTO>();
	for (SubjectDTO subject : new LecturerDAO().getEntity(lecturerId).getSubject())
	{
	    learningMaterials.addAll(subject.getLearningMaterials());
	}
	return learningMaterials;
    }

    /**
     * Method getting all subject's learning materials
     * @param subjectId
     * @return
     */
    public List<LearningMaterialsDTO> getSubjectLearningMaterials(Integer subjectId)
    {
	return new SubjectDAO().getEntity(subjectId).getLearningMaterials();
    }

    /**
     * Method adds learning materials
     */
    public void insert(LearningMaterialsDTO entity)
    {
	super.insert(entity);
	new SubjectDAO().getEntity(entity.getSubject().getId()).addLearningMaterials(entity);
    }

    /**
     * Method removes learning materials
     */
    public void remove(LearningMaterialsDTO entity)
    {
	new SubjectDAO().getEntity(entity.getSubject().getId()).removeLearningMaterials(entity);
	super.remove(entity);
    }
}
