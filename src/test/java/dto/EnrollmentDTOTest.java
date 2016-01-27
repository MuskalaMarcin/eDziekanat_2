package test.java.dto;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

public class EnrollmentDTOTest
{
    private EnrollmentDTO enrollment;

    @Before
    public void setUp()
    {
	this.enrollment = new EnrollmentDTO();
    }

    @Test
    public void testSetId()
    {
	enrollment.setId(1);
	final int id = enrollment.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetId()
    {
	enrollment.setId(1);
	final int id = enrollment.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetMark()
    {
	float a =  3F;
	enrollment.setMark(a);
	final int id = Math.round(enrollment.getMark());
	assertEquals("b³êdna ocena", 3, id);
    }

    @Test
    public void testGetMark()
    {
	float a =  3F;
	enrollment.setMark(a);
	final int id = Math.round(enrollment.getMark());
	assertEquals("b³êdna ocena", 3, id);
    }

    @Test
    public void testGetIssueDate()
    {
	Date date = new Date();
	enrollment.setIssueDate(date);
	final Date datetested = enrollment.getIssueDate();
	assertEquals("b³êdna data", date, datetested);
    }

    @Test
    public void testSetIssueDate()
    {
	Date date = new Date();
	enrollment.setIssueDate(date);
	final Date datetested = enrollment.getIssueDate();
	assertEquals("b³êdna data", date, datetested);
    }

    @Test
    public void testGetSubject()
    {
	SubjectDTO sub = new SubjectDTO();
	enrollment.setSubjectId(sub);
	SubjectDTO tested = enrollment.getSubject();
	assertEquals("z³y przedmiot", sub, tested);
    }

    @Test
    public void testSetSubjectId()
    {
	SubjectDTO sub = new SubjectDTO();
	enrollment.setSubjectId(sub);
	SubjectDTO tested = enrollment.getSubject();
	assertEquals("z³y przedmiot", sub, tested);
    }

    @Test
    public void testGetTranscript()
    {
	TranscriptDTO sub = new TranscriptDTO();
	enrollment.setTranscriptId(sub);
	TranscriptDTO tested = enrollment.getTranscript();
	assertEquals("b³êdny indeks", sub, tested);
    }

    @Test
    public void testSetTranscriptId()
    {
	TranscriptDTO sub = new TranscriptDTO();
	enrollment.setTranscriptId(sub);
	TranscriptDTO tested = enrollment.getTranscript();
	assertEquals("b³êdny indeks", sub, tested);
    }

}
