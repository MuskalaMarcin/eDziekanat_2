package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.LearningMaterialsDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

public class SubjectDTOTest
{
    SubjectDTO sub;

    @Before
    public void setUp() throws Exception
    {
	this.sub = new SubjectDTO();
    }

    @Test
    public void testGetId()
    {
	sub.setId(1);
	final int id = sub.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	sub.setId(1);
	final int id = sub.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	sub.setName("foo");
	final String name = sub.getName();
	assertEquals("foo", name);
    }

    @Test
    public void testSetName()
    {
	sub.setName("foo");
	final String name = sub.getName();
	assertEquals("foo", name);
    }

    @Test
    public void testGetSemester()
    {
	sub.setSemester(1);
	final int id = sub.getSemester();
	assertEquals(1, id);
    }

    @Test
    public void testSetSemester()
    {
	sub.setSemester(1);
	final int id = sub.getSemester();
	assertEquals(1, id);
    }

    @Test
    public void testGetECTS()
    {
	sub.setECTS(1);
	final int id = sub.getECTS();
	assertEquals(1, id);
    }

    @Test
    public void testSetECTS()
    {
	sub.setECTS(1);
	final int id = sub.getECTS();
	assertEquals(1, id);
    }

    @Test
    public void testGetLecturer()
    {
	LecturerDTO sch = new LecturerDTO();
	sub.setLecturer(sch);
	LecturerDTO tested = sub.getLecturer();
	assertEquals(sch, tested);
    }

    @Test
    public void testSetLecturer()
    {
	LecturerDTO sch = new LecturerDTO();
	sub.setLecturer(sch);
	LecturerDTO tested = sub.getLecturer();
	assertEquals(sch, tested);
    }

    @Test
    public void testGetStudents_group()
    {
	List<StudentsGroupDTO> sg = new LinkedList<StudentsGroupDTO>();
	sub.setStudents_group(sg);
	List<StudentsGroupDTO> tested = sub.getStudents_group();
	assertEquals(sg, tested);
    }

    @Test
    public void testSetStudents_group()
    {
	List<StudentsGroupDTO> sg = new LinkedList<StudentsGroupDTO>();
	sub.setStudents_group(sg);
	List<StudentsGroupDTO> tested = sub.getStudents_group();
	assertEquals(sg, tested);
    }

    @Test
    public void testGetEnrollment()
    {
	List<EnrollmentDTO> enrollment = new LinkedList<EnrollmentDTO>();
	sub.setEnrollment(enrollment);
	List<EnrollmentDTO> tested = sub.getEnrollment();
	assertEquals(enrollment, tested);
    }

    @Test
    public void testSetEnrollment()
    {
	List<EnrollmentDTO> enrollment = new LinkedList<EnrollmentDTO>();
	sub.setEnrollment(enrollment);
	List<EnrollmentDTO> tested = sub.getEnrollment();
	assertEquals(enrollment, tested);
    }

    @Test
    public void testGetLearningMaterials()
    {
	List<LearningMaterialsDTO> lm = new LinkedList<LearningMaterialsDTO>();
	sub.setLearningMaterials(lm);
	List<LearningMaterialsDTO> tested = sub.getLearningMaterials();
	assertEquals(lm, tested);
    }

    @Test
    public void testSetLearningMaterials()
    {
	List<LearningMaterialsDTO> lm = new LinkedList<LearningMaterialsDTO>();
	sub.setLearningMaterials(lm);
	List<LearningMaterialsDTO> tested = sub.getLearningMaterials();
	assertEquals(lm, tested);
    }

    @Test
    public void testAddLearningMaterials()
    {
	List<LearningMaterialsDTO> lm = new LinkedList<LearningMaterialsDTO>();
	sub.setLearningMaterials(lm);
	LearningMaterialsDTO lmadd = new LearningMaterialsDTO();
	lm.add(lmadd);
	List<LearningMaterialsDTO> tested = sub.getLearningMaterials();
	assertTrue(tested.contains(lmadd));
    }

    @Test
    public void testRemoveLearningMaterials()
    {
	List<LearningMaterialsDTO> lm = new LinkedList<LearningMaterialsDTO>();
	sub.setLearningMaterials(lm);
	LearningMaterialsDTO lmadd = new LearningMaterialsDTO();
	lm.add(lmadd);
	lm.remove(lmadd);
	List<LearningMaterialsDTO> tested = sub.getLearningMaterials();
	assertTrue(!tested.contains(lmadd));
    }

    @Test
    public void testGetPartialMark()
    {
	List<PartialMarkDTO> pm = new LinkedList<PartialMarkDTO>();
	sub.setPartialMark(pm);
	List<PartialMarkDTO> tested = sub.getPartialMark();
	assertEquals(pm, tested);
    }

    @Test
    public void testSetPartialMark()
    {
	List<PartialMarkDTO> pm = new LinkedList<PartialMarkDTO>();
	sub.setPartialMark(pm);
	List<PartialMarkDTO> tested = sub.getPartialMark();
	assertEquals(pm, tested);
    }

    @Test
    public void testGetScheduledClasses()
    {
	List<ScheduledClassesDTO> pm = new LinkedList<ScheduledClassesDTO>();
	sub.setScheduledClasses(pm);
	List<ScheduledClassesDTO> tested = sub.getScheduledClasses();
	assertEquals(pm, tested);
    }

    @Test
    public void testSetScheduledClasses()
    {
	List<ScheduledClassesDTO> pm = new LinkedList<ScheduledClassesDTO>();
	sub.setScheduledClasses(pm);
	List<ScheduledClassesDTO> tested = sub.getScheduledClasses();
	assertEquals(pm, tested);
    }

}
