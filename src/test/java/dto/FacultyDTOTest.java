package test.java.dto;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.UniversityDTO;

public class FacultyDTOTest
{

    FacultyDTO faculty;

    @Before
    public void setUp()
    {
	this.faculty = new FacultyDTO();
    }

    @Test
    public void testGetId()
    {
	faculty.setId(1);
	final int id = faculty.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	faculty.setId(1);
	final int id = faculty.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	faculty.setName("foo");
	final String name = faculty.getName();
	assertEquals("b³êdna nazwa", "foo", name);
    }

    @Test
    public void testSetName()
    {
	faculty.setName("foo");
	final String name = faculty.getName();
	assertEquals("b³êdna nazwa","foo", name);
    }

    @Test
    public void testGetAddress()
    {
	faculty.setAddress("address");
	final String address = faculty.getAddress();
	assertEquals("b³êdny adres","address", address);
    }

    @Test
    public void testSetAddress()
    {
	faculty.setAddress("address");
	final String address = faculty.getAddress();
	assertEquals("b³êdny adres","address", address);
    }

    @Test
    public void testGetUniversity()
    {
	UniversityDTO uni = new UniversityDTO();
	faculty.setUniversity(uni);
	UniversityDTO unitest = faculty.getUniversity();
	assertEquals("b³êdny uniwersytet",uni, unitest);
    }

    @Test
    public void testSetUniversity()
    {
	UniversityDTO uni = new UniversityDTO();
	faculty.setUniversity(uni);
	UniversityDTO unitest = faculty.getUniversity();
	assertEquals("b³êdny uniwersytet",uni, unitest);
    }

    @Test
    public void testGetClassroom()
    {
	List<ClassroomDTO> sch = new LinkedList<ClassroomDTO>();
	faculty.setClassroom(sch);
	List<ClassroomDTO> tested = faculty.getClassroom();
	assertEquals("b³êdne klasy",sch, tested);
    }

    @Test
    public void testSetClassroom()
    {
	List<ClassroomDTO> sch = new LinkedList<ClassroomDTO>();
	faculty.setClassroom(sch);
	List<ClassroomDTO> tested = faculty.getClassroom();
	assertEquals("b³êdne klasy",sch, tested);
    }

    @Test
    public void testGetCourse()
    {
	List<CourseDTO> sch = new LinkedList<CourseDTO>();
	faculty.setCourse(sch);
	List<CourseDTO> tested = faculty.getCourse();
	assertEquals("b³êdne kierunki",sch, tested);
    }

    @Test
    public void testSetCourse()
    {
	List<CourseDTO> sch = new LinkedList<CourseDTO>();
	faculty.setCourse(sch);
	List<CourseDTO> tested = faculty.getCourse();
	assertEquals("b³êdne kierunki",sch, tested);
    }

    @Test
    public void testGetLecturer()
    {
	List<LecturerDTO> sch = new LinkedList<LecturerDTO>();
	faculty.setLecturer(sch);
	List<LecturerDTO> tested = faculty.getLecturer();
	assertEquals("b³êdni wyk³adowcy",sch, tested);
    }

    @Test
    public void testSetLecturer()
    {
	List<LecturerDTO> sch = new LinkedList<LecturerDTO>();
	faculty.setLecturer(sch);
	List<LecturerDTO> tested = faculty.getLecturer();
	assertEquals("b³êdni wyk³adowcy",sch, tested);
    }

}
