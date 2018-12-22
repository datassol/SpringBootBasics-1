package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeJPA {
	
	@Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
  
    @Column(name = "EMPLOYEE_NAME")
    private String name;
  
    @Column(name = "EMPLOYEE_SALARY")
    private Integer salary;
    
    public EmployeeJPA() {
 
    }
    
    public EmployeeJPA(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeJPA [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
  
    

}