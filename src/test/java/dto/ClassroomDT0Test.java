package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

public class ClassroomDT0Test
{
    ClassroomDTO classr;

    @Before
    public void setUp()
    {
	this.classr = new ClassroomDTO();
    }

    @Test
    public void testGetId()
    {
	classr.setId(1);
	final int id = classr.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	classr.setId(1);
	final int id = classr.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetCapacity()
    {
	classr.setCapacity(10);
	final int id = classr.getCapacity();
	assertEquals("Z³a pojemnoœæ",10, id);
    }

    @Test
    public void testSetCapacity()
    {
	classr.setCapacity(10);
	final int id = classr.getCapacity();
	assertEquals("Z³a pojemnoœæ", 10, id);
    }

    @Test
    public void testGetType()
    {
	classr.setType("wykladowa");
	final String name = classr.getType();
	assertEquals("z³y typ", "wykladowa", name);
    }

    @Test
    public void testSetType()
    {
	classr.setType("wykladowa");
	final String name = classr.getType();
	assertEquals("z³y typ", "wykladowa", name);
    }

    @Test
    public void testGetFaculty()
    {
	FacultyDTO faculty = new FacultyDTO();
	classr.setFaculty(faculty);
	FacultyDTO tested = classr.getFaculty();
	assertEquals("z³y wydzia³", faculty, tested);
    }

    @Test
    public void testSetFaculty()
    {
	FacultyDTO faculty = new FacultyDTO();
	classr.setFaculty(faculty);
	FacultyDTO tested = classr.getFaculty();
	assertEquals("z³y wydzia³", faculty, tested);
    }

    @Test
    public void testGetScheduledClasses()
    {
	List<ScheduledClassesDTO> sch = new LinkedList<ScheduledClassesDTO>();
	classr.setScheduledClasses(sch);
	List<ScheduledClassesDTO> tested = classr.getScheduledClasses();
	assertEquals("b³êdna zajêcia", sch, tested);
    }

    @Test
    public void testSetScheduledClasses()
    {
	List<ScheduledClassesDTO> sch = new LinkedList<ScheduledClassesDTO>();
	classr.setScheduledClasses(sch);
	List<ScheduledClassesDTO> tested = classr.getScheduledClasses();
	assertEquals("b³êdne zajêcia", sch, tested);
    }

    @Test
    public void testGetNumber()
    {
	classr.setNumber(1);
	final int id = classr.getNumber();
	assertEquals("z³y numer sali", 1, id);
    }

    @Test
    public void testSetNumber()
    {
	classr.setNumber(1);
	final int id = classr.getNumber();
	assertEquals("z³y numer sali", 1, id);
    }

}
