import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordonates;
	
	public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordonates = new ArrayList<Employee>();
	}
	
	public void add(Employee e) {
		subordonates.add(e);
	}
	
	public void remove(Employee e) {
		subordonates.remove(e);
	}
	
	public List<Employee> getSubordinates() {
		return subordonates;
	}
	
	public String toString() {
		return ("Employee : [ Name: " + name 
				+ ", dept: "+ dept + ", salary: "
				+ salary + " ]"		
				);
	}
}
