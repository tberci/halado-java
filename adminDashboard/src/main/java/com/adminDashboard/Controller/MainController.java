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

import com.adminDashboard.DTO.MilestoneDto;
import com.adminDashboard.DTO.SemesterDto;
import com.adminDashboard.DTO.StudentDto;
import com.adminDashboard.DTO.TeacherDto;
import com.adminDashboard.Entity.Milestone;
import com.adminDashboard.Entity.Semester;
import com.adminDashboard.Entity.Student;
import com.adminDashboard.Entity.Teacher;
import com.adminDashboard.Entity.Semester.Status;
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
		
		mav.addObject("semesterDto", new SemesterDto());
	
		return mav;
	}
	
	
	@GetMapping(value="/addSemester")
	public ModelAndView getAddSemester()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semester.html");
		mav.addObject("semesterDto", new SemesterDto());
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
		mav.addObject("milestoneDto", new MilestoneDto());
		
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
		mav.addObject("teacherDto", new TeacherDto());
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
	public ModelAndView deleteSemester(@PathVariable int id)  {
		
		ModelAndView mav = new ModelAndView();
		
		Optional<Semester> semesterOptional = service.findById(id);
		
		if(semesterOptional.isEmpty()) {
			
			mav.setViewName("error.html");
			
		}else {
			
			Semester semester = semesterOptional.get();
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
		mav.addObject("studentDto", new StudentDto());
		return mav;
	}
	
	@PostMapping(value="/addStudent")
	public ModelAndView addStudent(@Valid @ModelAttribute("studentDto") Student student,BindingResult bindingresult)  {
		ModelAndView mav = new ModelAndView();
		
		if (bindingresult.hasErrors()) {
			mav.setViewName("student");
			mav.addObject("teachers", service.listTeachers());
			
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
	public ModelAndView activate(@PathVariable("id") int id )  {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/");
		
		Optional<Semester> semesterOptional = service.findById(id);
		
		if(semesterOptional.isEmpty()) {
			
			mav.setViewName("error.html");
			
		}else {
			
			Semester semester = semesterOptional.get();
			if(semester.getStatus() == Status.INACTIVE) {
				mav.setViewName("redirect:/");
				semester.setStatus(Status.ACTIVE);
				service.saveSemester(semester);
			}else {
				mav.setViewName("error.html");
			}
			
		}

		return mav;
	}
	
	@PostMapping(value="/deactivate/{id}")
	public ModelAndView deactivate(@PathVariable("id") int id  )  {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/");
		Optional<Semester> semesterOptional = service.findById(id);
		
		if(semesterOptional.isEmpty()) {
			
			mav.setViewName("error.html");
			
		}else {
			
			Semester semester = semesterOptional.get();
			
			if(semester.getStatus() == Status.ACTIVE) {
				mav.setViewName("redirect:/");
				semester.setStatus(Status.INACTIVE);
				service.saveSemester(semester);
			}else {
				mav.setViewName("error.html");
			}
			
		}

		return mav;
	}
	
	@PostMapping(value="/finish/{id}")
	public ModelAndView finishSemester(@PathVariable("id") int id  )  {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/");
		
		Optional<Semester> semesterOptional = service.findById(id);
		
		if(semesterOptional.isEmpty()) {
			
			mav.setViewName("error.html");
			
		}else {
			
			Semester semester = semesterOptional.get();
			if(semester.getStatus() == Status.INACTIVE) {
				mav.setViewName("redirect:/");
				semester.setStatus(Status.FINISHED);
				service.saveSemester(semester);
				
			}else {
				mav.setViewName("error.html");
			}
			
		}
		
	
		return mav;
	}
	
	
}
