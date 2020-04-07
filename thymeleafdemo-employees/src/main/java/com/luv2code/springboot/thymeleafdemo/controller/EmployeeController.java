package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.dto.EmployeeDTO;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private static final ModelMapper modelMapper =new ModelMapper();
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	


	@GetMapping("/list")
	public String listEmployees(Model model) {
		

		List<Employee> employees = employeeService.findAll();
		
		// add to the spring model

		List<EmployeeDTO> employeeDtoList = Arrays.asList(modelMapper.map(employees, EmployeeDTO[].class));
		//EmployeeDTO employeeDto = modelMapper.map(, EmployeeDTO.class);
		model.addAttribute("employees", employeeDtoList);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		

		Employee  employee = new Employee();
		EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
		// create model attribute to bind form data
		model.addAttribute("employee", employeeDto);
		
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id,
									Model model) {
		

		Employee employee = employeeService.findById(id);
		EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
		// set employee as a model attribute to pre-populate the form

		model.addAttribute("employee", employeeDto);
		

		return "employees/employee-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "employees/employee-form";
		}
		Employee employee= modelMapper.map(employeeDto, Employee.class);
		employeeService.save(employee);
		

		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		

		employeeService.deleteById(id);
		

		return "redirect:/employees/list";
		
	}
}


















