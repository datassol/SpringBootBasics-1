package service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.springboot.basics.SpringBootBasics_1.HelloRestController;

import dao.EmployeeDao;
import dao.EmployeeJPA;
import dataObjects.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	    @Autowired
	    EmployeeDao employeeDao;
	    
		  private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);


	    public List<Employee> getAllEmployees() {
	    	log.info("EMp SErv IMPL :");
	        return convertJPAtoTO(this.employeeDao.findAll());
	    }
	    
	    private List<Employee> convertJPAtoTO(List<EmployeeJPA> employeeJPAList) {
	    	List<Employee> employeeList = new ArrayList<>();
	    	if(!CollectionUtils.isEmpty(employeeJPAList)) {
	    		for(EmployeeJPA jpa: employeeJPAList) {
	    			Employee emp = new Employee();
	    			emp.setId(jpa.getId());
	    			emp.setName(jpa.getName());
	    			emp.setSalary(jpa.getSalary());
	    			employeeList.add(emp);
	    		}
	    	}
	    	return employeeList;
	    }
	    
	    public Employee addUser(Employee employee) {
	    	log.debug("Debug: Add USER EmployeeServiceImpl:"+employee);
	    	log.info("Debug: Add USER EmployeeServiceImpl:"+employee);
	    	EmployeeJPA emp = new EmployeeJPA("test",1000);
	        return convertJPAtoTOObj(this.employeeDao.save(emp));
	    }

		private Employee convertJPAtoTOObj(EmployeeJPA emp) {
			Employee empJ = new Employee();
			empJ.setId(emp.getId());
			empJ.setName(emp.getName());
			empJ.setSalary(emp.getSalary());
			return empJ;
		}


}
