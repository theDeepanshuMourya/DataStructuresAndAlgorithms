package heap.JDKPriorityQueue;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(25);
		pq.add(75);
		pq.add(80);
		pq.add(98);
		pq.add(68);
		pq.add(40);
		pq.add(52);
		pq.add(67);
		
		System.out.println(pq.peek());
		System.out.println(pq.remove(40));
		System.out.println(pq.peek());
		System.out.println();
		
		Object[] ints = pq.toArray();
		for(Object num: ints) {
			System.out.println(num);
		}
		
	}

}
