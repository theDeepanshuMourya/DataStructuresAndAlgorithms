package DataStructuresAndAlgorithms.src.hashtable.JDK;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 456);
		Employee saraSmith = new Employee("Sara", "Smith", 789);
		Employee mikeRoss = new Employee("Mike", "Ross", 52);
		Employee billWilson = new Employee("Bill", "Wilson", 72);
		Employee billEnd = new Employee("Bill", "End", 894);
		
		Map<String, Employee> hashMap = new HashMap<String, Employee>();
		hashMap.put("Jones", janeJones);
		hashMap.put("Doe", johnDoe);
		hashMap.put("Smith", saraSmith);
		hashMap.put("Ross", mikeRoss);
		hashMap.put("Wilson", billWilson);
		
		Iterator<Employee> iterator = hashMap.values().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(hashMap.containsKey("Doe"));
		System.out.println(hashMap.containsValue(billEnd));
		
		hashMap.forEach((k,v)-> System.out.println("Key = " + k + ", Employee = " + v));

	}

}
