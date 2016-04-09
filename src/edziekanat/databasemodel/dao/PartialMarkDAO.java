package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

/**
 * Data access class used to perform operations on partial_mark entities.
 */
public class PartialMarkDAO extends DAOParentClass<PartialMarkDTO>
{
    public PartialMarkDAO()
    {
	super(PartialMarkDTO.class, TableNames.PARTIAL_MARK);
    }

    /**
     * Method getting one object of PartialMark entity.
     *
     * @param id Integer id value
     * @return PartialMarkDTO object
     */
    public PartialMarkDTO getEntity(Integer id)
    {
	return entityManager.find(PartialMarkDTO.class, id);
    }

    /**
     * Method getting all student's partial marks in specific subject
     *
     * @param studentId
     * @param subjectId
     * @return
     */
    public List<PartialMarkDTO> getStudentMarksFromSubject(Integer studentId, Integer subjectId)
    {
	return new StudentDAO().getEntity(studentId).getTranscript().stream().map(transcriptDTO -> getMultipleEntities(
			"subject_id = '" + subjectId + "' and transcript_id = '" + transcriptDTO.getId() + "'"))
			.flatMap(partialMarkDTOs -> partialMarkDTOs.stream()).collect(
					Collectors.toList());
    }
}
