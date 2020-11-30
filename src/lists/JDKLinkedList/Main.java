package DataStructuresAndAlgorithms.src.lists.JDKLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {		
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <-> ");
		}
		
		System.out.println("null");
		list.add(5);
		
		iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <-> ");
		}
		
		System.out.println("null");
		
		list.removeFirst();
		
		iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <-> ");
		}
		
		System.out.println("null");
		
		list.removeLast();
		
		iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <-> ");
		}
		
		System.out.println("null");
	}
}
