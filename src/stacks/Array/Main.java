package DataStructuresAndAlgorithms.src.stacks.Array;

public class Main {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(new Employee("Jane", "Jones", 123));
		stack.push(new Employee("John", "Doe", 456));
		stack.push(new Employee("Sara", "Williams", 789));
		stack.push(new Employee("Mike", "Ross", 52));
		
		stack.printStack();
		System.out.println(stack.peek());

	}

}
