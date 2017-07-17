package newIo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		Employee[] employees = new Employee[3];
//		for (Entity entity : employees) {
//			//foreach has granted the value to the item in an array, which won't impact the real item in array
//			entity = employee.clone();
//		}
		
		employees[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		employees[1] = new Employee("Harry Hacker", 55000, 1997, 2, 12);
		employees[2] = new Employee("Tony Tester", 45000, 1993, 8, 25);
		
//		Entity s = new Entity("Student", false);
//		System.out.println(s);
		try (PrintWriter out = new PrintWriter("employee.dat", "UTF-8")){
			writeData(employees, out);
		}
		try(Scanner in = new Scanner(
				new FileInputStream("employee.dat"), "UTF-8")){
			Employee[] newEmp = readData(in);
 			for (Employee e : newEmp) {
				System.out.println(e);
			}
		}
	}

	private static Employee[] readData(Scanner in) {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		in.nextLine();
		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i] = readEmployee(in);
		}
		return employees;
	}

	private static Employee readEmployee(Scanner in) {
		// TODO Auto-generated method stub
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		
		Employee e = new Employee(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
		return e;
	}

	private static void writeData(Employee[] employees, PrintWriter out) throws IOException {
		// TODO Auto-generated method stub
		out.println(employees.length);
		for (Employee entity : employees) {
			writeEmployee(out, entity);
		}
	}

	private static void writeEmployee(PrintWriter out, Employee e) throws IOException {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(e.getHireDay());
		out.println(e.getName() + "|" + e.getSalary() + "|" + gc.get(Calendar.YEAR)
		+ "|" + (gc.get(Calendar.MONTH) + 1) 
		+ "|" + gc.get(Calendar.DAY_OF_MONTH));
	}

}
