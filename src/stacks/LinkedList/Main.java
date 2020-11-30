/* Stack implementation using a LinkedList */

package DataStructuresAndAlgorithms.src.stacks.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	static class LinkedStack {
	
		private LinkedList<Integer> stack;
		
		public LinkedStack() {
			stack = new LinkedList<Integer>();
		}
		
		// Method to push elements in the stack
		public void push(int val) {
			stack.push(val);
		}
		
		// Method to get the element at top
		public int pop() {
			return stack.pop();
		}
		
		// Method to view the element at top
		public int peek() {
			return stack.peek();
		}
		
		// Method to check if the stack is empty
		public boolean isEmpty() {
			return stack.isEmpty();
		}
		
		// Method to print the elements of stack
		public void printStack() {
			ListIterator<Integer> iterator = stack.listIterator();
			while(iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {		
		LinkedStack stack = new LinkedStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.printStack();
		
		System.out.println(stack.peek());
	}
}
