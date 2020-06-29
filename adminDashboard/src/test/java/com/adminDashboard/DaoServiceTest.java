package com.adminDashboard;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.adminDashboard.DAO.MilestoneRepository;
import com.adminDashboard.DAO.SemesterRepository;
import com.adminDashboard.DAO.StudentRepository;
import com.adminDashboard.DAO.TeacherRepository;
import com.adminDashboard.Entity.Milestone;
import com.adminDashboard.Entity.Semester;
import com.adminDashboard.Entity.Student;
import com.adminDashboard.Entity.Teacher;
import com.adminDashboard.Entity.Semester.Status;
import com.adminDashboard.Service.DaoService;


@ExtendWith(MockitoExtension.class)
public class DaoServiceTest {
 
	@InjectMocks
	private DaoService service;
	
    @Mock
    private SemesterRepository semesterRepository;
    
    @Mock
    private MilestoneRepository milestoneRepository;
    
    @Mock
    private TeacherRepository teacherRepository;
    
    @Mock
    private StudentRepository studentRepository;
    

    @Test
    public void saveSemesterTest() {
    	
        // given
        Semester semester = new Semester();
        
        //when
        semesterRepository.save(semester);
        when(semesterRepository.save(Mockito.any(Semester.class))).thenReturn(semester);
        
        //then
        verify(semesterRepository, times(1)).save(semester);
        assertEquals(semester, service.saveSemester(semester) );
    }
    
    @Test
    public void saveMilestoneTest() {
        // given
        Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("kotest");
        
        //when
        milestoneRepository.save(milestone);
        when(milestoneRepository.save(milestone)).thenReturn(milestone);
        
        //then
        verify( milestoneRepository, times(1)).save(milestone);
        assertThat(service.saveMilestone(milestone)).isEqualTo(milestone);
    }
    
    @Test
    public void saveTeacherTest() {
        // given
    	Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("testteacher");
        
        //when
        teacherRepository.save(teacher);
        when(teacherRepository.save(teacher)).thenReturn(teacher);
        
        //then
        verify(teacherRepository, times(1)).save(teacher);
        assertThat(service.saveTeacher(teacher)).isEqualTo(teacher);
    }
    
    @Test
    public void saveStudentTest() {
        // given
    	Student student = new Student();
        student.setId(1);
        student.setName("teststudent");
        
        //when
        studentRepository.save(student);
        when(studentRepository.save(student)).thenReturn(student);
        
        //then
        verify(studentRepository, times(1)).save(student);
        assertThat(service.saveStudent(student)).isEqualTo(student);
    }
    
    @Test
    public void listSemesterTest() {
        // given
    	Semester semester = new Semester();
        semester.setId(1);
        semester.setName("testsemester");
        
        Semester semester2 = new Semester();
        semester2.setId(2);
        semester2.setName("testsemester2");
        
        List<Semester> semesterList = new ArrayList<Semester>();
        semesterList.add(semester);
        semesterList.add(semester2);
        
        //when
        semesterRepository.findAll();
        when(semesterRepository.findAll()).thenReturn(semesterList);
        
        //then
        verify(semesterRepository, times(1)).findAll();
        assertThat(service.listSemesters()).isEqualTo(semesterList);
    }
    
    @Test
    public void listMilestoneTest() {
      // given
    	Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("kotest");
        
        Milestone milestone2 = new Milestone();
        milestone2.setId(2);
        milestone2.setName("kotest2");
        
        List<Milestone> milestoneList = new ArrayList<Milestone>();
        milestoneList.add(milestone);
        milestoneList.add(milestone2);
        
        //when
        milestoneRepository.findAll();
        when(milestoneRepository.findAll()).thenReturn(milestoneList);
        
        //then
        verify(milestoneRepository, times(1)).findAll();
        assertThat(service.listMilestones()).isEqualTo(milestoneList);
    }
    
    
    @Test
    public void listTeacherTest() {
      // given
    	Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("testteacher");
        
        Teacher teacher2 = new Teacher();
        teacher2.setId(2);
        teacher2.setName("testteacher2");
        
        
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        teacherList.add(teacher2);
        
        
        teacherRepository.findAll();
        when(teacherRepository.findAll()).thenReturn(teacherList);
        
        verify(teacherRepository, times(1)).findAll();
        assertThat(service.listTeachers()).isEqualTo(teacherList);
    }
    
    @Test
    public void listStudentsTest() {
      // given
    	Student student = new Student();
        student.setId(1);
        student.setName("teststudent");
        
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("teststudent2");
        
        
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        studentList.add(student2);
        
        //when
        studentRepository.findAll();
        when(studentRepository.findAll()).thenReturn(studentList);
        
        //then
        verify(studentRepository, times(1)).findAll();
        assertThat(service.listStudents()).isEqualTo(studentList);
    }
    
    @Test
    public void findSemesterByIdTest() {
      // given
    	Semester semester = new Semester();
        semester.setId(1);
        semester.setName("testsemester");
        
        //when
        Optional<Semester> semesterOptional = service.findById(1);
        when(semesterRepository.findById(1)).thenReturn(semesterOptional);
        
        
        //then
        verify(semesterRepository, times(1)).findById(1);
        assertThat(service.findById(1)).isEqualTo(semesterOptional);
    }
    
    @Test
    public void findSemestersByStatusTest() {
      // given
    	Semester semester = new Semester();
        semester.setId(1);
        semester.setName("testsemester");
        semester.setStatus(Status.INACTIVE);
        
        Semester semester2 = new Semester();
        semester2.setId(2);
        semester2.setName("testsemester2");
        semester2.setStatus(Status.INACTIVE);
        
        List<Semester> semesterList = new ArrayList<Semester>();
        semesterList.add(semester);
        semesterList.add(semester2);
        
        //when
        semesterRepository.findByStatus(Status.INACTIVE);
        when(semesterRepository.findByStatus(Status.INACTIVE)).thenReturn(semesterList);
        
        //then
        verify(semesterRepository, times(1)).findByStatus(Status.INACTIVE);
        assertThat(service.findAllInactive()).isEqualTo(semesterList);
    }
    
    
    @Test
    public void removeSemesterByIdTest() {
    	
      // given
    	int id = 10;
    	
        //when 
    	service.removeSemester(id);
    	
        //then
        verify(semesterRepository,times(1)).deleteById((id));
    }
    
}