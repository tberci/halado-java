package com.calculatorweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.calculatorLogic.CalculatorLogic;
import com.calculatorweb.dto.Dto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	private CalculatorLogic calc;
	
	@Autowired
	public void setCalculator(CalculatorLogic calc) {
		this.calc = calc;
	}
	
	@GetMapping(value="/")
	public ModelAndView getCalculator()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main.html");
		mav.addObject("calc", calc);
		return mav;
	}
	
	
	@GetMapping(value = "/calculator")
	public ModelAndView getAdd() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calculator");
		mav.addObject("dto", new Dto());
		return mav;
	}
	
	@PostMapping(value = "/calculator", params="sum")
	public ModelAndView postSum(@Valid Dto dto, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mav.setViewName("eror");
			mav.addObject("error", "error");
			return mav;
		}
	
		double result = calc.osszead(dto.getX(), dto.getY());
		mav.addObject("result", result);
		
		return mav;
	}
	
	
	@PostMapping(value = "/calculator", params="substract")
	public ModelAndView postSubstract(@Valid Dto dto, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mav.setViewName("eror");
			mav.addObject("error", "error");
			return mav;
		}
	
		double result = calc.kivon(dto.getX(), dto.getY());
		mav.addObject("result", result);
		
		return mav;
	}
	
	@PostMapping(value = "/calculator", params="multiply")
	public ModelAndView postMultiply(@Valid Dto dto, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mav.setViewName("eror");
			mav.addObject("error", "error");
			return mav;
		}
	
		double result = calc.szoroz(dto.getX(), dto.getY());
		mav.addObject("result", result);
		
		return mav;
	}
	
	@PostMapping(value = "/calculator", params="divide")
	public ModelAndView postDivide(@Valid Dto dto, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mav.setViewName("eror");
			mav.addObject("error", "error");
			return mav;
		}
		
		double result = calc.oszt(dto.getX(), dto.getY());
		if(dto.getX() == 0 || dto.getY() == 0) {
			result = 0.0;
		}
		mav.addObject("result", result);
		
		return mav;
	}
	
}
