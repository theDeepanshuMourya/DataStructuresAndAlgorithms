package DataStructuresAndAlgorithms.src.hashtable.LinearProbing;

public class Main {
	public static void main(String[] args) {
		HashMap map = new HashMap();
        map.put("Rahul", 11);
        map.put("Shubham", 12);
        map.put("Deepanshu", 13);
        map.put("Jones", 14);
        map.put("Jane", 15);
        map.put("Smith", 17);

        System.out.println("Retrieving key Jones: " + map.get("Jones"));
        map.print();

        map.remove("Rahul");

        map.print();
		System.out.println("Retrieving key Smith: " + map.get("Smith"));
	}

}
