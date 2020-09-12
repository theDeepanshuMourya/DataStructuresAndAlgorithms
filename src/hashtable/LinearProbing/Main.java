package hashtable.LinearProbing;

public class Main {

	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 456);
		Employee saraSmith = new Employee("Sara", "Smith", 789);
		Employee mikeRoss = new Employee("Mike", "Ross", 52);
		Employee billWilson = new Employee("Bill", "Wilson", 72);
		Employee billEnd = new Employee("Bill", "End", 894);
		
		SimpleHashtable ht = new SimpleHashtable();
		ht.put("Jones", janeJones);
		ht.put("Doe", johnDoe);
		ht.put("Smith", saraSmith);
		ht.put("Ross", mikeRoss);
		ht.put("Wilson", billWilson);
		ht.put("End", billEnd);
		
		ht.printHashtable();
		
		System.out.println("Retrieving key Ross: " + ht.get("Ross"));
		
		ht.remove("Jones");
		ht.remove("Wilson");
		ht.remove("Ross");
		
		System.out.println(" ");
		ht.printHashtable();
		System.out.println("Retrieving key Smith: " + ht.get("Smith"));

	}

}
