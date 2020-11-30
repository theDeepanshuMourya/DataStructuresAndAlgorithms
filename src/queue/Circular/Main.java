/* Circular Queue implementation using Array */

package DataStructuresAndAlgorithms.src.queue.Circular;

import java.util.NoSuchElementException;

public class Main {
	static class Queue {
        private int[] queue;
        private int front;
        private int back;

        public Queue(){
            queue = new int[10];
        }

		// Method to print top element of the Queue
        public int peek() {
            if(size() == 0) {
                throw new NoSuchElementException();
            }
            
            return queue[front];
        }

		// Method to add elements in the Queue
        public void add(int val) {
            if(size() == queue.length) {
                int len = size();
                int newQueue[] = new int[2 * queue.length];
                System.arraycopy(queue, front, newQueue, 0, queue.length - front);
                System.arraycopy(queue, 0, newQueue, queue.length - front, back);
                queue = newQueue;

                front = 0;
                back = len;
            }

            queue[back] = val;

            if(back < queue.length - 1) {
                back++;
            }else {
                back = 0;
            }
        }

		// Method to remove top element of the Queue
        public int remove() {
            if(size() == queue.length) {
                throw new NoSuchElementException();
            }

            int val = queue[front];
            queue[front] = 0;
            front++;

            if(size() == 0){
                front = 0;
                back = 0;
            }else if(front == queue.length){
                front = 0;
            }

            return val;
        }

		// Method to print size of the Queue
        public int size() {
            if(front <= back) {
                return back-front;
            } else {
                return back-front + queue.length;
            }
        }

		// Method to print the elements of the Queue
        public void printQueue(){
            if(front <= back){
                for(int i = front; i < back; i++){
                    System.out.print(queue[i] + " ");
                }

                System.out.println();
            } else {
                for(int i = front; i < queue.length; i++){
                    System.out.print(queue[i] + " ");
                }

                for(int i = 0; i < back; i++){
                    System.out.print(queue[i] + " ");
                }

                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

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
