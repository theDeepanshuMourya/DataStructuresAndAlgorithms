package stacks.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 456);
		Employee saraWilliams = new Employee("Sara", "Williams", 789);
		Employee mikeRoss = new Employee("Mike", "Ross", 52);
		
		LinkedStack stack = new LinkedStack();
		stack.push(janeJones);
		stack.push(johnDoe);
		stack.push(saraWilliams);
		stack.push(mikeRoss);
		
		stack.printStack();
		
		System.out.println(stack.peek());

	}

}
