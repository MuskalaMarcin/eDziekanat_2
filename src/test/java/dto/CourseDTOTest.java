package test.java.dto;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

public class CourseDTOTest
{

    private CourseDTO course;

    @Before
    public void setUp()
    {
	this.course = new CourseDTO();
    }

    @Test
    public void testGetId()
    {
	course.setId(1);
	final int id = course.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	course.setId(1);
	final int id = course.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	course.setName("foo");
	final String name = course.getName();
	assertEquals("z³a nazwa", "foo", name);
    }

    @Test
    public void testSetName()
    {
	course.setName("foo");
	final String name = course.getName();
	assertEquals("z³a nazwa", "foo", name);
    }

    @Test
    public void testGetStationary()
    {
	course.setStationary(1);
	final int stat = course.getStationary();
	assertEquals(1, stat);
    }

    @Test
    public void testSetStationary()
    {
	course.setStationary(1);
	final int stat = course.getStationary();
	assertEquals(1, stat);
    }

    @Test
    public void testGetFaculty()
    {
	FacultyDTO faculty = new FacultyDTO();
	course.setFaculty(faculty);
	FacultyDTO tested = course.getFaculty();
	assertEquals("z³y wydzia³", faculty, tested);
    }

    @Test
    public void testSetFaculty()
    {
	FacultyDTO faculty = new FacultyDTO();
	course.setFaculty(faculty);
	FacultyDTO tested = course.getFaculty();
	assertEquals("z³y wydzia³", faculty, tested);
    }

    @Test
    public void testGetStudentsGroup()
    {
	List<StudentsGroupDTO> sch = new LinkedList<StudentsGroupDTO>();
	course.setStudentsGroup(sch);
	List<StudentsGroupDTO> tested = course.getStudentsGroup();
	assertEquals("z³a grupa", sch, tested);
    }

    @Test
    public void testSetStudentsGroup()
    {
	List<StudentsGroupDTO> sch = new LinkedList<StudentsGroupDTO>();
	course.setStudentsGroup(sch);
	List<StudentsGroupDTO> tested = course.getStudentsGroup();
	assertEquals("z³a grupa", sch, tested);
    }

}
