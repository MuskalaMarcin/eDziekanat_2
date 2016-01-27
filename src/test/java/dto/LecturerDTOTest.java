package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.UserDTO;

public class LecturerDTOTest
{
    LecturerDTO lecturer;

    @Before
    public void setUp()
    {
	this.lecturer = new LecturerDTO();
    }

    @Test
    public void testGetId()
    {
	lecturer.setId(1);
	final int id = lecturer.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	lecturer.setId(1);
	final int id = lecturer.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	lecturer.setName("foo");
	final String name = lecturer.getName();
	assertEquals("b³êdne imiê", "foo", name);
    }

    @Test
    public void testSetName()
    {
	lecturer.setName("foo");
	final String name = lecturer.getName();
	assertEquals("b³êdne imiê","foo", name);
    }

    @Test
    public void testGetSurname()
    {
	lecturer.setSurname("foo");
	final String surname = lecturer.getSurname();
	assertEquals("b³êdne nazwisko","foo", surname);
    }

    @Test
    public void testSetSurname()
    {
	lecturer.setSurname("foo");
	final String surname = lecturer.getSurname();
	assertEquals("b³êdne nazwisko","foo", surname);
    }

    @Test
    public void testGetAddress()
    {
	lecturer.setAddress("address");
	final String address = lecturer.getAddress();
	assertEquals("b³êdny adres","address", address);
    }

    @Test
    public void testSetAddress()
    {
	lecturer.setAddress("address");
	final String address = lecturer.getAddress();
	assertEquals("b³êdny adres","address", address);
    }

    @Test
    public void testGetPosition()
    {
	lecturer.setPosition("pos");
	final String pos = lecturer.getPosition();
	assertEquals("b³êdny stanowisko","pos", pos);
    }

    @Test
    public void testSetPosition()
    {
	lecturer.setPosition("pos");
	final String pos = lecturer.getPosition();
	assertEquals("pos", pos);
    }

    @Test
    public void testGetAcademicDegree()
    {
	lecturer.setAcademicDegree("foo");
	final String surname = lecturer.getAcademicDegree();
	assertEquals("foo", surname);
    }

    @Test
    public void testSetAcademicDegree()
    {
	lecturer.setAcademicDegree("academicDegree");
	final String surname = lecturer.getAcademicDegree();
	assertEquals("academicDegree", surname);
    }

    @Test
    public void testGetSubject()
    {
	List<SubjectDTO> sub = new LinkedList<SubjectDTO>();
	lecturer.setSubject(sub);
	List<SubjectDTO> tested = lecturer.getSubject();
	assertEquals(sub, tested);
    }

    @Test
    public void testSetSubject()
    {
	List<SubjectDTO> sub = new LinkedList<SubjectDTO>();
	lecturer.setSubject(sub);
	List<SubjectDTO> tested = lecturer.getSubject();
	assertEquals(sub, tested);
    }

    @Test
    public void testGetUser()
    {
	UserDTO test = new UserDTO();
	lecturer.setUser(test);
	UserDTO tested = lecturer.getUser();
	assertEquals(test, tested);
    }

    @Test
    public void testSetUser()
    {
	UserDTO test = new UserDTO();
	lecturer.setUser(test);
	UserDTO tested = lecturer.getUser();
	assertEquals(test, tested);
    }

    @Test
    public void testGetFaculty()
    {
	List<FacultyDTO> faculty = new LinkedList<FacultyDTO>();
	lecturer.setFaculty(faculty);
	List<FacultyDTO> tested = lecturer.getFaculty();
	assertEquals(faculty, tested);
    }

    @Test
    public void testSetFaculty()
    {
	List<FacultyDTO> faculty = new LinkedList<FacultyDTO>();
	lecturer.setFaculty(faculty);
	List<FacultyDTO> tested = lecturer.getFaculty();
	assertEquals(faculty, tested);
    }

}
