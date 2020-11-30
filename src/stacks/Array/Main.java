/* Stack Implementation using an Array */

package DataStructuresAndAlgorithms.src.stacks.Array;

import java.util.EmptyStackException;

public class Main {
	static class Stack {
		private int stack[];
        private int top;

        // Creating stack with initial capacity of 10
        public Stack(){
            stack = new int[10];
        }

        // Method to push elements in the stack
        public void push(int val){
            if(top == stack.length){
                int newStack[] = new int[2 * stack.length];
                System.arraycopy(stack, 0, newStack, 0, stack.length);
                stack = newStack;
            }

            stack[top++] = val;
        }

        // Method to get the size of stack
        public int size(){
            return top;
        }

        // Method to check if the stack is empty
        public boolean isEmpty(){
            return top == 0;
        }

        // Method to view the element at top
        public int peek(){
            if(isEmpty()){
                throw new EmptyStackException();
            }

            return stack[top - 1];
        }

        // Method to get the element at top 
        public int pop(){
            if(isEmpty()){
                throw new EmptyStackException();
            }

            int val = stack[--top];
            stack[top] = 0;
            return val;
        }

        // Method to print the elements of stack
        public void printStack(){
            if(isEmpty()){
                throw new EmptyStackException();
            }

            for(int i = top-1; i >= 0; i--){
                System.out.print(stack[i] + " ");
            }

            System.out.println();
        }
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.printStack();

        System.out.println(stack.pop());

        stack.printStack();
        System.out.println(stack.peek());

	}

}
