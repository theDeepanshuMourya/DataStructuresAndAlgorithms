package DataStructuresAndAlgorithms.src.queue.Circular;

public class Main {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 456);
		Employee saraWilliams = new Employee("Sara", "Williams", 789);
		Employee mikeRoss = new Employee("Mike", "Ross", 52);
		Employee billEnd = new Employee("Bill", "End", 72);
		
		ArrayQueue queue = new ArrayQueue(10);
		queue.add(janeJones);
		queue.add(johnDoe);
		queue.add(saraWilliams);
		queue.add(mikeRoss);
		queue.add(billEnd);
		
		queue.printQueue();
		
		queue.remove();
		queue.remove();
		
		queue.printQueue();
		
		System.out.println(queue.peek());

	}

}
