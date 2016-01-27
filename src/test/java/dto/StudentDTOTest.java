package test.java.dto;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

public class StudentDTOTest
{

    StudentDTO student;

    @Before
    public void setUp()
    {
	this.student = new StudentDTO();
    }

    @Test
    public void testGetId()
    {
	student.setId(1);
	final int id = student.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	student.setId(1);
	final int id = student.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	student.setName("foo");
	final String name = student.getName();
	assertEquals("foo", name);
    }

    @Test
    public void testSetName()
    {
	student.setName("foo");
	final String name = student.getName();
	assertEquals("foo", name);
    }

    @Test
    public void testGetSurname()
    {
	student.setSurname("foo");
	final String surname = student.getSurname();
	assertEquals("foo", surname);
    }

    @Test
    public void testSetSurname()
    {
	student.setSurname("foo");
	final String surname = student.getSurname();
	assertEquals("foo", surname);
    }

    @Test
    public void testGetAcademicDegree()
    {
	student.setAcademicDegree("foo");
	final String surname = student.getAcademicDegree();
	assertEquals("foo", surname);
    }

    @Test
    public void testSetAcademicDegree()
    {
	student.setAcademicDegree("academicDegree");
	final String surname = student.getAcademicDegree();
	assertEquals("academicDegree", surname);
    }

    @Test
    public void testGetAddress()
    {
	student.setAddress("address");
	final String address = student.getAddress();
	assertEquals("address", address);
    }

    @Test
    public void testSetAddress()
    {
	student.setAddress("address");
	final String address = student.getAddress();
	assertEquals("address", address);
    }

    @Test
    public void testGetApplication()
    {
	List<ApplicationDTO> test = new LinkedList<ApplicationDTO>();
	student.setApplication(test);
	List<ApplicationDTO> unitest = student.getApplication();
	assertEquals(test, unitest);
    }

    @Test
    public void testSetApplication()
    {
	List<ApplicationDTO> test = new LinkedList<ApplicationDTO>();
	student.setApplication(test);
	List<ApplicationDTO> unitest = student.getApplication();
	assertEquals(test, unitest);
    }

    @Test
    public void testGetScholarship()
    {
	List<ScholarshipDTO> test = new LinkedList<ScholarshipDTO>();
	student.setScholarship(test);
	List<ScholarshipDTO> unitest = student.getScholarship();
	assertEquals(test, unitest);
    }

    @Test
    public void testSetScholarship()
    {
	List<ScholarshipDTO> test = new LinkedList<ScholarshipDTO>();
	student.setScholarship(test);
	List<ScholarshipDTO> unitest = student.getScholarship();
	assertEquals(test, unitest);
    }

    @Test
    public void testGetTranscript()
    {
	List<TranscriptDTO> test = new LinkedList<TranscriptDTO>();
	student.setTranscript(test);
	List<TranscriptDTO> unitest = student.getTranscript();
	assertEquals(test, unitest);
    }

    @Test
    public void testSetTranscript()
    {
	List<TranscriptDTO> test = new LinkedList<TranscriptDTO>();
	student.setTranscript(test);
	List<TranscriptDTO> unitest = student.getTranscript();
	assertEquals(test, unitest);
    }

}
