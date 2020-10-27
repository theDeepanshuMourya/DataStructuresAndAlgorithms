package DataStructuresAndAlgorithms.src.lists.ArrayLists;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Jane", "Jones", 123));
		employeeList.add(new Employee("John", "Doe", 456));
		employeeList.add(new Employee("Mary", "Smith", 56));
		employeeList.add(new Employee("Mike", "Ross", 789));

		
		//	to print element at particular index
		System.out.println(employeeList.get(2));
		
		// to check if the arraylist is empty or not
		System.out.println(employeeList.isEmpty());
		
		// to replace a particular element in the arraylist
		employeeList.set(1, new Employee("John", "Adams", 258));
		
		// to check the size of arraylist
		System.out.println(employeeList.size());
		
		employeeList.forEach(employee -> System.out.println(employee));
		
	}

}
