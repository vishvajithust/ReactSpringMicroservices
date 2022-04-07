package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.EmployeeManagement;
import com.employee.repository.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@GetMapping("/employees")
	public List<EmployeeManagement> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	

	@PostMapping("/employees")
	public EmployeeManagement createEmployee(@RequestBody EmployeeManagement employee) {
		return employeeRepository.save(employee);
	}
	

	@GetMapping("/employees/{empId}")
	public ResponseEntity<EmployeeManagement> getEmployeeById(@PathVariable int empId) {
		EmployeeManagement employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
		return ResponseEntity.ok(employee);
	}
		
	@PutMapping("/employees/{empId}")
	public ResponseEntity<EmployeeManagement> updateEmployee(@PathVariable int empId, @RequestBody EmployeeManagement employeeDetails){
		EmployeeManagement employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
		
		employee.setFullName(employeeDetails.getFullName());
		employee.setAddress(employeeDetails.getAddress());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setManager(employeeDetails.getManager());
		employee.setMobile(employeeDetails.getMobile());
		employee.setProject(employeeDetails.getProject());
		
		EmployeeManagement updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	

	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int empId){
		EmployeeManagement employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	

}
