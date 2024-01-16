package com.example.springAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> sortBySalary(@RequestParam(required = false) String sort){
		if(sort == null) return employeeService.getAll();
		return employeeService.sortBy(sort);
	}
	@GetMapping("/employee/{id}")
	public Employee getById(@PathVariable("id") Long id){
		return employeeService.getById(id);
	}

	@PostMapping("/addEmployee")
	public void postData(@RequestBody Employee emp){
		employeeService.postData(emp);
	}

	@PutMapping("/updateEmployee/{id}")
	public void updateData(@RequestBody Employee emp){
		employeeService.putData(emp);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteById(@PathVariable("id") Long id){
		employeeService.deleteData(id);
	}

}
