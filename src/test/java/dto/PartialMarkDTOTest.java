package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

public class PartialMarkDTOTest
{
    PartialMarkDTO pm;

    @Before
    public void setUp()
    {
	this.pm = new PartialMarkDTO();
    }

    @Test
    public void testGetId()
    {
	pm.setId(1);
	final int id = pm.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	pm.setId(1);
	final int id = pm.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetMark()
    {
	float a =  3F;
	pm.setMark(a);
	final int id = Math.round(pm.getMark());
	assertEquals(3, id);
    }

    @Test
    public void testSetMark()
    {
	float a =  3F;
	pm.setMark(a);
	final int id = Math.round(pm.getMark());
	assertEquals(3, id);
    }

    @Test
    public void testGetIssueDate()
    {
	Date date = new Date();
	pm.setIssueDate(date);
	final Date datetested = pm.getIssueDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetIssueDate()
    {
	Date date = new Date();
	pm.setIssueDate(date);
	final Date datetested = pm.getIssueDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetSubject()
    {
	SubjectDTO sub = new SubjectDTO();
	pm.setSubject(sub);
	SubjectDTO tested = pm.getSubject();
	assertEquals(sub, tested);
    }

    @Test
    public void testSetSubject()
    {
	SubjectDTO sub = new SubjectDTO();
	pm.setSubject(sub);
	SubjectDTO tested = pm.getSubject();
	assertEquals(sub, tested);
    }

    @Test
    public void testGetTranscript()
    {
	TranscriptDTO test = new TranscriptDTO();
	pm.setTranscript(test);
	TranscriptDTO unitest = pm.getTranscript();
	assertEquals(test, unitest);
    }

    @Test
    public void testSetTranscript()
    {
	TranscriptDTO test = new TranscriptDTO();
	pm.setTranscript(test);
	TranscriptDTO unitest = pm.getTranscript();
	assertEquals(test, unitest);
    }

}
