package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

public class StudentsGroupDTOTest
{
    StudentsGroupDTO sg;

    @Before
    public void setUp() throws Exception
    {
	this.sg = new StudentsGroupDTO();
    }

    @Test
    public void testGetId()
    {
	sg.setId(1);
	final int id = sg.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	sg.setId(1);
	final int id = sg.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetSemester()
    {
	sg.setSemester(1);
	final int id = sg.getSemester();
	assertEquals(1, id);
    }

    @Test
    public void testSetSemester()
    {
	sg.setSemester(1);
	final int id = sg.getSemester();
	assertEquals(1, id);
    }

    @Test
    public void testGetCourse()
    {
	CourseDTO course = new CourseDTO();
	sg.setCourse(course);
	CourseDTO tested = sg.getCourse();
	assertEquals(course, tested);
    }

    @Test
    public void testSetCourse()
    {
	CourseDTO course = new CourseDTO();
	sg.setCourse(course);
	CourseDTO tested = sg.getCourse();
	assertEquals(course, tested);
    }

    @Test
    public void testGetSubject()
    {
	List<SubjectDTO> course = new LinkedList<SubjectDTO>();
	sg.setSubject(course);
	List<SubjectDTO> tested = sg.getSubject();
	assertEquals(course, tested);
    }

    @Test
    public void testSetSubject()
    {
	List<SubjectDTO> course = new LinkedList<SubjectDTO>();
	sg.setSubject(course);
	List<SubjectDTO> tested = sg.getSubject();
	assertEquals(course, tested);
    }

    @Test
    public void testGetTranscript()
    {
	List<TranscriptDTO> test = new LinkedList<TranscriptDTO>();
	sg.setTranscript(test);
	List<TranscriptDTO> unitest = sg.getTranscript();
	assertEquals(test, unitest);
    }

    @Test
    public void testSetTranscript()
    {
	List<TranscriptDTO> test = new LinkedList<TranscriptDTO>();
	sg.setTranscript(test);
	List<TranscriptDTO> unitest = sg.getTranscript();
	assertEquals(test, unitest);
    }

    @Test
    public void testGetStudent()
    {
	List<StudentDTO> test = new LinkedList<StudentDTO>();
	sg.setStudent(test);
	List<StudentDTO> tested = sg.getStudent();
	assertEquals(test, tested);
    }

    @Test
    public void testSetStudent()
    {
	List<StudentDTO> test = new LinkedList<StudentDTO>();
	sg.setStudent(test);
	List<StudentDTO> tested = sg.getStudent();
	assertEquals(test, tested);
    }

}
