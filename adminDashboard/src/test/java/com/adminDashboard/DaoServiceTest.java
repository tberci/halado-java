package com.adminDashboard;


import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.times;
import static org.assertj.core.api.Assertions.assertThat;
import com.adminDashboard.DAO.MilestoneRepository;
import com.adminDashboard.DAO.SemesterRepository;
import com.adminDashboard.DAO.StudentRepository;
import com.adminDashboard.DAO.TeacherRepository;
import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Semester.Status;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;
import com.adminDashboard.Service.DaoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoServiceTest {
 
	@Autowired
	private DaoService service;
	
    @MockBean
    private SemesterRepository semesterRepository;
    
    @MockBean
    private MilestoneRepository milestoneRepository;
    
    @MockBean
    private TeacherRepository teacherRepository;
    
    @MockBean
    private StudentRepository studentRepository;
    

    @Test
    public void saveSemesterTest() {
        // given
        Semester semester = new Semester();
        semester.setId(1);
        semester.setName("testsemester");
        
        when(semesterRepository.save(semester)).thenReturn(semester);
        
        assertThat(service.saveSemester(semester)).isEqualTo(semester);
    }
    
    @Test
    public void saveMilestoneTest() {
        // given
        Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("kotest");
        
        
        when(milestoneRepository.save(milestone)).thenReturn(milestone);
        
        assertThat(service.saveMilestone(milestone)).isEqualTo(milestone);
    }
    
    @Test
    public void saveTeacherTest() {
        // given
       Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("testteacher");
        
        
        when(teacherRepository.save(teacher)).thenReturn(teacher);
        
        assertThat(service.saveTeacher(teacher)).isEqualTo(teacher);
    }
    
    @Test
    public void saveStudentTest() {
        // given
    	Student student = new Student();
        student.setId(1);
        student.setName("teststudent");
        
        
        when(studentRepository.save(student)).thenReturn(student);
        
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
        
        when(semesterRepository.findAll()).thenReturn(semesterList);
        
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
        
        when(milestoneRepository.findAll()).thenReturn(milestoneList);
        
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
        
        when(teacherRepository.findAll()).thenReturn(teacherList);
        
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
        
        when(studentRepository.findAll()).thenReturn(studentList);
        
        assertThat(service.listStudents()).isEqualTo(studentList);
    }
    
    @Test
    public void findSemesterByIdTest() {
      // given
    	Semester semester = new Semester();
        semester.setId(1);
        semester.setName("testsemester");
        
        Optional<Semester> semesterOptional = service.findById(1);
        when(semesterRepository.findById(1)).thenReturn(semesterOptional);
        
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
        
        
        when(semesterRepository.findByStatus(Status.INACTIVE)).thenReturn(semesterList);
        
        assertThat(service.findAllInactive()).isEqualTo(semesterList);
    }
    
    
    @Test
    public void removeSemesterByIdTest() {
      // given
    	Semester semester = new Semester();
        semester.setId(1);
        semester.setName("testsemester");
        
        Optional<Semester> semesterOptional = service.findById(1);
        when(semesterRepository.findById(1)).thenReturn(semesterOptional);
        
        service.removeSemester(semester.getId());
        
        verify(semesterRepository,times(1)).deleteById(semester.getId());
    }
    
    

   
}