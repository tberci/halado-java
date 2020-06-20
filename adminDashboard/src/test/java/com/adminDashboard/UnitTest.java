package com.adminDashboard;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.adminDashboard.DAO.MilestoneRepository;
import com.adminDashboard.DAO.TeacherRepository;
import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Teacher;


@RunWith(SpringRunner.class)
class UnitTest {

	
	@Test
	public void unitTest1() {
		Semester semester = mock(Semester.class);
		
		when(semester.getId()).thenReturn(20);
		
		assertEquals(semester.getId(), 20);
	}
	
	
	 @Test
	 public void unitTest2(){
	       Milestone milestone = mock(Milestone.class);   
	       
	      when(milestone.getId()).thenReturn(40);
	      
	      assertEquals(milestone.getId(), 40);
	       
	    }
	 
	 @Test
	 public void teacherSaveTest() {
			
			
			Teacher teacher = mock(Teacher.class);
			TeacherRepository teacherRepository = mock(TeacherRepository.class);
			teacherRepository.save(teacher);
			
			List<Teacher> teachers = teacherRepository.findAll();
			teachers.add(teacher);
			
			Assert.assertEquals(teacher.getName(), teachers.get(0).getName());
			
		}
	 
	 @Test
		public void listMilestonesTest() {
		
		 
			Milestone milestone = mock(Milestone.class);
			Milestone milestone2 = mock(Milestone.class);
			MilestoneRepository milestoneRepository = mock(MilestoneRepository.class);
			
			milestoneRepository.save(milestone);
			milestoneRepository.save(milestone2);
			List<Milestone> milestones = milestoneRepository.findAll();
			
			
			Assert.assertEquals(milestoneRepository.findAll() ,milestones);
			
		}
	 
}
