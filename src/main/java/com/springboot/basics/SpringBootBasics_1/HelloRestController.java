package com.springboot.basics.SpringBootBasics_1;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dataObjects.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;
 
@RestController
public class HelloRestController {
	
	 @Autowired
	 EmployeeService empService;
	 
	  private static final Logger log = LoggerFactory.getLogger(HelloRestController.class);

 
  @RequestMapping("/hello")
  public String hello() {
    return "Hello. All your base are belong to us.";
  }
  
  
  @RequestMapping("/getEmployees")
  public List<Employee> getEmployees() {
	  log.info("Get Emp Method:");
	return this.empService.getAllEmployees();
  }
  
  @RequestMapping(value = "/adduser", method = RequestMethod.POST,
          consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Employee addUser(@RequestBody Employee emp) {
	  log.debug("Add USER Method:"+emp.getName()+":"+emp.getSalary());
	  log.info("Add USER Method:"+emp.getName()+":"+emp.getSalary());

      return this.empService.addUser(emp);
  }
}
