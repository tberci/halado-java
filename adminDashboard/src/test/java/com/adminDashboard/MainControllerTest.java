package com.adminDashboard;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.adminDashboard.Controller.MainController;
import com.adminDashboard.DAO.TeacherRepository;
import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Semester.Status;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;
import com.adminDashboard.Service.DaoService;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
class MainControllerTest {

	@Autowired
    private MockMvc mockMvc;
	

	
	@MockBean
    private TeacherRepository teachrepo;
 
    @MockBean
    private DaoService service;
 
    @Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}


    @Test
	public void saveSemersterGetTest() throws Exception {
    	Semester semester = new Semester();
		when(service.saveSemester(semester)).thenReturn(semester);
		this.mockMvc.perform(get("/addSemester")).andDo(print()).andExpect(status().isOk());
	}
    
    @Test
    public void saveSemesterPostTest() throws Exception {

    	Semester semester = new Semester();
    	when(service.saveSemester(semester)).thenReturn(semester);
    	mockMvc.perform(post("/addSemester")
    		    .contentType("application/json"))
    			.andDo(print())
    		    .andExpect(view().name("semester"));
	}
    
    @Test
   	public void saveMilestoneGetTest() throws Exception {
       	Milestone milestone = new Milestone();
   		when(service.saveMilestone(milestone)).thenReturn(milestone);
   		this.mockMvc.perform(get("/addMilestone")).andDo(print()).andExpect(status().isOk());
   	}
    
    @Test
   	public void saveMilestonePostTest() throws Exception {
       	Milestone milestone = new Milestone();
   		when(service.saveMilestone(milestone)).thenReturn(milestone);
   		this.mockMvc.perform(post("/addMilestone")).andDo(print()).andExpect(status().isOk());
   	}
    
    @Test
   	public void saveTeacherGetTest() throws Exception {
       	Teacher teacher = new Teacher();
   		when(service.saveTeacher(teacher)).thenReturn(teacher);
   		this.mockMvc.perform(get("/addTeacher")).andDo(print()).andExpect(status().isOk());
   	}
    
    @Test
   	public void saveStudentGetTest() throws Exception {
       	Student student = new Student();
   		when(service.saveStudent(student)).thenReturn(student);
   		this.mockMvc.perform(get("/addStudent")).andDo(print()).andExpect(status().isOk());
   	}
    
    @Test
   	public void deleteSemesterTest() throws Exception {
       	Semester semester = new Semester(1,"30.félév");
       	int id = semester.getId();
   		when(service.removeSemester(id)).thenReturn(semester.getName());
   		this.mockMvc.perform(post("/deleteSemester/1")).andDo(print()).andExpect(status().isOk());
   	}
    
    @Test
   	public void activateSemesterTest() throws Exception {
       	Semester semester = new Semester(42,"30.félév");
       	semester.setStatus(Status.INACTIVE);
       	
       	if(semester.getStatus().equals(Status.INACTIVE)) {
       	
       	mockMvc.perform(post("/activate/42")
       		    .contentType("application/json"))
       		    .andExpect(status().isOk());
       	}
   	}
    
    @Test
   	public void deactivateSemesterTest() throws Exception {
       	Semester semester = new Semester(42,"30.félév");
       	semester.setStatus(Status.INACTIVE);
       	
    	if(semester.getStatus().equals(Status.INACTIVE)) {
       	
       	mockMvc.perform(post("/deactivate/42")
       		    .contentType("application/json"))
       		    .andExpect(status().isOk());
   	}
    }
    
    
    @Test
   	public void finishSemesterTest() throws Exception {
       	Semester semester = new Semester(42,"30.félév");
       	semester.setStatus(Status.INACTIVE);
       	
       	
    	
    	semester.setStatus(Status.FINISHED);
       	mockMvc.perform(post("/finish/42")
       		    .contentType("application/json"))
       		    .andExpect(status().isOk());
   	
    }
    
}



