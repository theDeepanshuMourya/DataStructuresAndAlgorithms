package DataStructuresAndAlgorithms.src.lists.ArrayLists;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		//	to print element at particular index
		System.out.println(list.get(2));
		
		// to check if the arraylist is empty or not
		System.out.println(list.isEmpty());
		
		// to replace a particular element in the arraylist
		list.set(1, 6);
		
		// to check the size of arraylist
		System.out.println(list.size());
		
		list.forEach(Integer -> System.out.println(Integer));		
	}
}
