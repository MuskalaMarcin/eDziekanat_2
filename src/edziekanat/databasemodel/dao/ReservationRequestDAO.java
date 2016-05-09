package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ReservationRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcin Muska³a on 09.05.2016.
 */
public class ReservationRequestDAO extends DAOParentClass<ReservationRequestDTO>
{
    public ReservationRequestDAO()
    {
	super(ReservationRequestDTO.class, TableNames.RESERVATION_REQUEST);
    }

    public ReservationRequestDTO getEntity(Integer id)
    {
	return entityManager.find(ReservationRequestDTO.class, id);
    }

    public List<ReservationRequestDTO> getClassesFromSubject(Integer subjectId)
    {
	return getAllEntities().stream().filter(p -> p.getSubject().getId().equals(subjectId))
			.collect(Collectors.toList());
    }

    public List<ReservationRequestDTO> getClassesFromClassroom(Integer classroomId)
    {
	return getAllEntities().stream().filter(p -> p.getClassroom().getId().equals(classroomId))
			.collect(Collectors.toList());
    }
}
