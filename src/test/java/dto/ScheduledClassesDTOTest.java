package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

public class ScheduledClassesDTOTest
{
    ScheduledClassesDTO sch;

    @Before
    public void setUp()
    {
	this.sch = new ScheduledClassesDTO();
    }

    @Test
    public void testGetId()
    {
	sch.setId(1);
	final int id = sch.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	sch.setId(1);
	final int id = sch.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetDate()
    {
	Date date = new Date();
	sch.setDate(date);
	final Date datetested = sch.getDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetDate()
    {
	Date date = new Date();
	sch.setDate(date);
	final Date datetested = sch.getDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetDuration()
    {
	sch.setDuration(1);
	final int id = sch.getDuration();
	assertEquals(1, id);
    }

    @Test
    public void testSetDuration()
    {
	sch.setDuration(1);
	final int id = sch.getDuration();
	assertEquals(1, id);
    }

    @Test
    public void testGetClassroom()
    {
	ClassroomDTO sche = new ClassroomDTO();
	sch.setClassroom(sche);
	ClassroomDTO tested = sch.getClassroom();
	assertEquals(sche, tested);
    }

    @Test
    public void testSetClassroom()
    {
	ClassroomDTO sche = new ClassroomDTO();
	sch.setClassroom(sche);
	ClassroomDTO tested = sch.getClassroom();
	assertEquals(sche, tested);
    }

    @Test
    public void testGetSubject()
    {
	SubjectDTO sub = new SubjectDTO();
	sch.setSubject(sub);
	SubjectDTO tested = sch.getSubject();
	assertEquals(sub, tested);
    }

    @Test
    public void testSetSubject()
    {
	SubjectDTO sub = new SubjectDTO();
	sch.setSubject(sub);
	SubjectDTO tested = sch.getSubject();
	assertEquals(sub, tested);
    }

}
