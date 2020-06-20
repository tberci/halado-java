package com.adminDashboard.Controller;



import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Semester.Status;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;

import com.adminDashboard.Service.DaoService;





@Controller
public class MainController {
	
	
	
	@Autowired
	private DaoService service;
	
	
	
	@GetMapping(value="/")
	public ModelAndView getDashboard()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.html");
		mav.addObject("teachers", service.listTeachers());
		mav.addObject("semesters", service.listSemesters());
		mav.addObject("milestones", service.listMilestones());
		mav.addObject("students", service.listStudents());
		
		mav.addObject("dto", new Semester());
	
		return mav;
	}
	
	
	@GetMapping(value="/addSemester")
	public ModelAndView getAddSemester()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semester.html");
		
		return mav;
	}
	
	@PostMapping(value="/addSemester")
	public ModelAndView addSemester(@Valid Semester semester ,BindingResult bindingresult)  {
		ModelAndView mav = new ModelAndView();
		
		if (bindingresult.hasErrors()) {
			mav.setViewName("semester");

			return mav;
		   }
		
		mav.setViewName("redirect:/");
		mav.addObject("semesters", service.saveSemester(semester));
		return mav;
	}
	
	@GetMapping(value="/addMilestone")
	public ModelAndView getAddMilestone()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("milestone.html");
		mav.addObject("semesters", service.listSemesters());
		Iterable<Semester> semesters = service.findAllInactive();
		mav.addObject("inactives",semesters);
		mav.addObject("milestoneDto", new Milestone());
		return mav;
	}
	
	@PostMapping(value="/addMilestone")
	public ModelAndView addMilestone(@Valid @ModelAttribute("milestoneDto") Milestone milestone,BindingResult bindingresult)  {
		ModelAndView mav = new ModelAndView();
		
		if (bindingresult.hasErrors()) {
			mav.setViewName("milestone");
			mav.addObject("semesters", service.listSemesters());
			mav.addObject("inactives", service.findAllInactive());
			mav.addObject("milestoneDto", milestone);
			
			return mav;
		   }
		
		mav.setViewName("redirect:/");
		mav.addObject("milestones",service.saveMilestone(milestone));
		
		
		
		return mav;
	}
	
	
	@GetMapping(value="/addTeacher")
	public ModelAndView getAddTeacher()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("teacher.html");
		mav.addObject("semesters", service.listSemesters());
		 
		mav.addObject("inactives", service.findAllInactive());
		mav.addObject("teacherDto", new Teacher());
		return mav;
	}
	
	
	@PostMapping(value="/addTeacher")
	public ModelAndView addTeacher(@Valid @ModelAttribute("teacherDto") Teacher teacher,BindingResult bindingresult)  {
		ModelAndView mav = new ModelAndView();

		if (bindingresult.hasErrors()) {
			mav.setViewName("teacher");
			mav.addObject("semesters", service.listSemesters());
			 
			mav.addObject("inactives", service.findAllInactive());
			
			return mav;
		   }
		
		mav.setViewName("redirect:/");
		mav.addObject("teachers", service.saveTeacher(teacher));
		mav.addObject("teacherDto",teacher);
		
	
		return mav;
	}
	
	
	@PostMapping(value="/deleteSemester/{id}")
	public ModelAndView deleteSemester(@PathVariable int id,@Valid Semester semester, BindingResult bindingresult)  {
		
		ModelAndView mav = new ModelAndView();
		if (bindingresult.hasErrors()) {
			mav.setViewName("error");
			mav.addObject("error","error");
			return mav;
		   }
		Optional<Semester> semesterOptional = service.findById(id);
		
		if(semesterOptional.isEmpty()) {
			
			mav.setViewName("error.html");
			
		}else {
			
			 semester = semesterOptional.get();
			if(semester.getTeachers().isEmpty()) {
				mav.setViewName("redirect:/");
				service.removeSemester(id);
			}else {
				mav.setViewName("removeError.html");
			}
			
		}
		
		return mav;
		
	}

	@GetMapping(value="/addStudent")
	public ModelAndView getAddStudent()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student.html");
		mav.addObject("teachers", service.listTeachers());
		mav.addObject("studentDto", new Student());
		return mav;
	}
	
	@PostMapping(value="/addStudent")
	public ModelAndView addStudent(@Valid @ModelAttribute("studentDto") Student student,BindingResult bindingresult)  {
		ModelAndView mav = new ModelAndView();
		
		if (bindingresult.hasErrors()) {
			mav.setViewName("student");
			mav.addObject("teachers", service.listTeachers());
			mav.addObject("studentDto", student);
			return mav;
		   }
		
		mav.setViewName("redirect:/");
		mav.addObject("student", service.saveStudent(student));
		return mav;
	}
	
	
	@PostMapping(value="/findById")
	public ModelAndView findSemester(@PathVariable int id)  {
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("index");
		
		mav.addObject("semesterid", service.findById(id));
		return mav;
	}
	

	@PostMapping(value="/activate/{id}")
	public ModelAndView activate(@PathVariable("id") int id ,@Valid Semester semester)  {
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("redirect:/");
		semester.setStatus(Status.ACTIVE);
		
		
		
		service.saveSemester(semester);

		return mav;
	}
	
	@PostMapping(value="/deactivate/{id}")
	public ModelAndView deactivate(@PathVariable("id") int id ,@Valid Semester semester )  {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/");
		semester.setStatus(Status.INACTIVE);
		
		
		service.saveSemester(semester);

		return mav;
	}
	
	@PostMapping(value="/finish/{id}")
	public ModelAndView finishSemester(@PathVariable("id") int id, @Valid Semester semester  )  {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/");
		semester.setStatus(Status.FINISHED);
		service.saveSemester(semester);
		return mav;
	}
	
	
}
