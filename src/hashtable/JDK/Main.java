/* JDK Implementation of HashMap */

package DataStructuresAndAlgorithms.src.hashtable.JDK;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {		
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Jones", 101);
		hashMap.put("Doe", 102);
		hashMap.put("Smith", 103);
		hashMap.put("Ross", 104);
		hashMap.put("Wilson", 105);
		
		Iterator<Integer> iterator = hashMap.values().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(hashMap.containsKey("Doe"));
		System.out.println(hashMap.containsValue(106));
		
		hashMap.forEach((k,v)-> System.out.println("Key = " + k + ", Value = " + v));

	}

}
