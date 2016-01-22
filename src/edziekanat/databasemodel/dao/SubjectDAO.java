package edziekanat.databasemodel.dao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Data access class used to perform operations on subject entities.
 */
public class SubjectDAO extends DAOParentClass<SubjectDTO>
{
    public SubjectDAO()
    {
	super(SubjectDTO.class, TableNames.SUBJECT);
    }

    /**
     * Method getting one object of Subject entity.
     * 
     * @param id Integer id value
     * @return SubjectDTO object
     */
    public SubjectDTO getEntity(Integer id)
    {
	return entityManager.find(SubjectDTO.class, id);
    }

    public List<SubjectDTO> getStudentSubjects(Integer studentId)
    {
	List <SubjectDTO> allSubjects = new LinkedList<SubjectDTO>();
	for(StudentsGroupDTO stgroup: new StudentDAO().getEntity(studentId).getStudentsGroup())
	{
	    for(SubjectDTO subject: stgroup.getSubject())
	    {
		allSubjects.add(subject);
	    }
	}
	Collections.sort(allSubjects, (x, y) -> y.getSemester().compareTo(x.getSemester()));
	return allSubjects;
    }
    
    public List<SubjectDTO> getStudentsSubjectsFromSemester(Integer studentId, Integer semester)
    {
	List <SubjectDTO> semesterSubjects = getStudentSubjects(studentId);
	for(int i=0;i<semesterSubjects.size();i++)
	{
	    if(semesterSubjects.get(i).getSemester().compareTo(semester)!=0)
	    {
		semesterSubjects.remove(i);
		i--;
	    }
	}
	Collections.sort(semesterSubjects, (x, y) -> x.getName().compareTo(y.getName()));
	return semesterSubjects;
    }
}
