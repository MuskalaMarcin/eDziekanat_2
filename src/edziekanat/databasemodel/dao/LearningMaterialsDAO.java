package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
     *
     * @param lecturerId
     * @return
     */
    public List<LearningMaterialsDTO> getLecturerLearningMaterials(Integer lecturerId)
    {
	return new LecturerDAO().getEntity(lecturerId).getSubject().stream()
			.map(subjectDTO -> subjectDTO.getLearningMaterials())
			.flatMap(learningMaterialsDTOs -> learningMaterialsDTOs.stream())
			.collect(Collectors.toList());
    }

    /**
     * Method getting all subject's learning materials
     *
     * @param subjectId
     * @return
     */
    public List<LearningMaterialsDTO> getSubjectLearningMaterials(Integer subjectId)
    {
	return new SubjectDAO().getEntity(subjectId).getLearningMaterials();
    }
}
