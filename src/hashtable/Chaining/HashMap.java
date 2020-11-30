/* Class for HashMap functions */

package DataStructuresAndAlgorithms.src.hashtable.Chaining;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashMap {
    private LinkedList<Pair>[] hashtable;

    @SuppressWarnings("unchecked")
    public HashMap() {
        hashtable = new LinkedList[10];

        for(int i = 0; i < hashtable.length; i++){
            hashtable[i] = new LinkedList<Pair>();
        }
    }

    // Method to add key-value in the HashTable
    public void put(String key, int val){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new Pair(key, val));
    }

    // Method to get value for the particular key in the HashTable
    public int get(String key){
        int hashedKey = hashKey(key);
        ListIterator<Pair> iterator = hashtable[hashedKey].listIterator();

        Pair res = null;
        while(iterator.hasNext()){
            res = iterator.next();

            if(res.key.equals(key)){
                return res.value;
            }
        }

        return -1;
    }

    // Method to remove the key-value pair from the HashTable
    public void remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<Pair> iterator = hashtable[hashedKey].listIterator();

        Pair res = null;
        while(iterator.hasNext()){
            res = iterator.next();

            if(res.key.equals(key)){
                break;
            }
        }

        if(res != null && res.key.equals(key)){
            hashtable[hashedKey].remove(res);
            System.out.println("Removed pair is: " + res.key + " = " + res.value);
        }
    }

    // Method to print the HashTable
    public void print() {
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] != null){
                System.out.print("Position " + i + ": ");
                ListIterator<Pair> iterator = hashtable[i].listIterator();
                Pair res = null;

				while(iterator.hasNext()) {
                    res = iterator.next();
					System.out.print("[" + res.key + " = " + res.value + "]");
					System.out.print("->");					
                }
                
				System.out.println("null");
            }
        }

        System.out.println();
    }

    private int hashKey(String key){
        return key.length() % hashtable.length;
    }
}
