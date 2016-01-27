package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

public class TranscriptDTOTest
{
    TranscriptDTO tran;

    @Before
    public void setUp() throws Exception
    {
	this.tran = new TranscriptDTO();
    }

    @Test
    public void testGetId()
    {
	tran.setId(1);
	final int id = tran.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	tran.setId(1);
	final int id = tran.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetIssueDate()
    {
	Date date = new Date();
	tran.setIssueDate(date);
	final Date datetested = tran.getIssueDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetIssueDate()
    {
	Date date = new Date();
	tran.setIssueDate(date);
	final Date datetested = tran.getIssueDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetStudent()
    {
	StudentDTO uni = new StudentDTO();
	tran.setStudent(uni);
	StudentDTO unitest = tran.getStudent();
	assertEquals(uni, unitest);
    }

    @Test
    public void testSetStudent()
    {
	StudentDTO uni = new StudentDTO();
	tran.setStudent(uni);
	StudentDTO unitest = tran.getStudent();
	assertEquals(uni, unitest);
    }

    @Test
    public void testGetStudentsGroup()
    {
	StudentsGroupDTO sch = new StudentsGroupDTO();
	tran.setStudentsGroup(sch);
	StudentsGroupDTO tested = tran.getStudentsGroup();
	assertEquals(sch, tested);
    }

    @Test
    public void testSetStudentsGroup()
    {
	StudentsGroupDTO sch = new StudentsGroupDTO();
	tran.setStudentsGroup(sch);
	StudentsGroupDTO tested = tran.getStudentsGroup();
	assertEquals(sch, tested);
    }

    @Test
    public void testGetEnrollment()
    {
	List<EnrollmentDTO> enrollment = new LinkedList<EnrollmentDTO>();
	tran.setEnrollment(enrollment);
	List<EnrollmentDTO> tested = tran.getEnrollment();
	assertEquals(enrollment, tested);
    }

    @Test
    public void testSetEnrollment()
    {
	List<EnrollmentDTO> enrollment = new LinkedList<EnrollmentDTO>();
	tran.setEnrollment(enrollment);
	List<EnrollmentDTO> tested = tran.getEnrollment();
	assertEquals(enrollment, tested);
    }

    @Test
    public void testGetPartial_mark()
    {
	List<PartialMarkDTO> enrollment = new LinkedList<PartialMarkDTO>();
	tran.setPartial_mark(enrollment);
	List<PartialMarkDTO> tested = tran.getPartial_mark();
	assertEquals(enrollment, tested);
    }

    @Test
    public void testSetPartial_mark()
    {
	List<PartialMarkDTO> enrollment = new LinkedList<PartialMarkDTO>();
	tran.setPartial_mark(enrollment);
	List<PartialMarkDTO> tested = tran.getPartial_mark();
	assertEquals(enrollment, tested);
    }

}
