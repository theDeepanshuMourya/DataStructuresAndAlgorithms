/* Queue implementation using Array */

package DataStructuresAndAlgorithms.src.queue.Array;

import java.util.NoSuchElementException;

public class Main {
	static class Queue{
        private int[] queue;
        private int front;
        private int back;

        public Queue(){
            queue = new int[10];
        }

		// Method to add elements in the Queue
        public void add(int val){
            if(size() == queue.length){
                int newQueue[] = new int[2 * queue.length];
                System.arraycopy(queue, 0, newQueue, 0, queue.length);
                queue = newQueue;
            }

            queue[back++] = val;
        }

		// Method to print size of the Queue
        public int size(){
            return back - front;
        }

		// Method to check if Queue is empty
        public boolean isEmpty(){
            return back == 0;
        }

		// Method to print top element of the Queue
        public int peek(){
            if(size() == 0){
                throw new NoSuchElementException();
            }

            return queue[front];
        }

		// Method to remove top element of the Queue
        public int remove(){
            if(size() == 0){
                throw new NoSuchElementException();
            }

            int val = queue[front];
            queue[front] = 0;
            front++;

            if(size() == 0){
                front = 0;
                back = 0;
            }

            return val;
        }

		// Method to print the elements of the Queue
        public void printQueue(){
            for(int i = front; i < back; i++){
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

	public static void main(String[] args) {
		Queue queue = new Queue();

        System.out.println(queue.isEmpty());

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.printQueue();

        System.out.println(queue.remove());
        System.out.println(queue.peek());

        queue.printQueue();

	}

}
