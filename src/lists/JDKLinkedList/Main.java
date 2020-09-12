package lists.JDKLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 456);
		Employee marySmith = new Employee("Mary", "Smith", 56);
		Employee mikeRoss = new Employee("Mike", "Ross", 789);
		Employee billEnd = new Employee("Bill", "End", 89);
		
		LinkedList<Employee> list = new LinkedList<>();
		list.addFirst(janeJones);
		list.addFirst(johnDoe);
		list.addFirst(marySmith);
		list.addFirst(mikeRoss);
		
		Iterator<Employee> iter = list.iterator();
		System.out.print("HEAD -> ");
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <=> ");
		}
		
		System.out.println("null");
		list.add(billEnd);
		
		iter = list.iterator();
		System.out.print("HEAD -> ");
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <=> ");
		}
		
		System.out.println("null");
		
		list.removeFirst();
		
		iter = list.iterator();
		System.out.print("HEAD -> ");
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <=> ");
		}
		
		System.out.println("null");
		
		list.removeLast();
		
		iter = list.iterator();
		System.out.print("HEAD -> ");
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <=> ");
		}
		
		System.out.println("null");

	}

}
