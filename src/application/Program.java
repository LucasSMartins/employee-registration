package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		// PART 1 - READING DATA:

		System.out.print("How many employees will be registered? ");
		Integer n = sc.nextInt();

		for (int i = 1; i < n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");

			System.out.print("Id: ");
			Integer id = sc.nextInt();

			sc.hasNextLine();

			System.out.print("Name: ");
			String name = sc.next();

			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			System.out.println();

			list.add(new Employee(id, name, salary));

			// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.print("This id does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		// PART 3 - LISTING EMPLOYEES

		System.out.println();
		System.out.print("List of employees: ");
		for (Employee obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}
}
