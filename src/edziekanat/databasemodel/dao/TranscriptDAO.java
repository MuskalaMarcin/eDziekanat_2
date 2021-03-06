package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.TranscriptDTO;

/**
 * Data access class used to perform operations on transcript entities.
 */
public class TranscriptDAO extends DAOParentClass<TranscriptDTO>
{
    public TranscriptDAO()
    {
	super(TranscriptDTO.class, TableNames.TRANSCRIPT);
    }

    /**
     * Method getting one object of Transcript entity.
     * 
     * @param id Integer id value
     * @return TranscriptDTO object
     */
    public TranscriptDTO getEntity(Integer id)
    {
	return entityManager.find(TranscriptDTO.class, id);
    }

    /**
     * Method getting all student's transcript
     * @param studentId
     * @return
     */
    public List<TranscriptDTO> getStudentTranscript(Integer studentId)
    {
	return getMultipleEntities("student_id = '" + studentId + "'");
    }
}
