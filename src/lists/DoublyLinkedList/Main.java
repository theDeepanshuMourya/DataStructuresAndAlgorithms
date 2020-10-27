package DataStructuresAndAlgorithms.src.lists.DoublyLinkedList;

public class Main {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 456);
		Employee marySmith = new Employee("Mary", "Smith", 56);
		Employee mikeRoss = new Employee("Mike", "Ross", 789);
		
		EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeRoss);
		
		System.out.println(list.isEmpty());
		System.out.println(list.getSize());
		list.printList();
		
		Employee billEnd = new Employee("Bill", "End", 45);
		
		list.addToEnd(billEnd);
		System.out.println(list.getSize());
		list.printList();
		
		list.removeFromFront();
		System.out.println(list.getSize());
		list.printList();
		
		list.removeFromEnd();
		System.out.println(list.getSize());
		list.printList();

	}

}
