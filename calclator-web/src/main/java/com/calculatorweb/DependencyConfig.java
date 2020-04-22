package com.calculatorweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.calculatorLogic.CalculatorLogic;

@Configuration
public class DependencyConfig {

	@Bean
	public CalculatorLogic calc() {
		return new CalculatorLogic();
	}

	
}
