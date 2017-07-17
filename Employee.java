package newIo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends SerialCloneable{
	/**
	 * 
	 */
	public static final int RECORD_SIZE = 100;
	public static final int NAME_SIZE = 40;
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(String name, double salary, int year, int month, int day) {
		super();
		this.name = name;
		this.salary = salary;
		this.hireDay = new GregorianCalendar(year, month - 1, day).getTime();
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}
	public void raiseSalary(double percentage) {
		// TODO Auto-generated method stub
		setSalary(getSalary() * (1 + percentage/100));
	}
}
