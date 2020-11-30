/* Class for HashMap functions */

package DataStructuresAndAlgorithms.src.hashtable.LinearProbing;

public class HashMap {    
    private Pair[] hashtable;

    public HashMap(){
        this.hashtable = new Pair[10];
    }

    // Method to add key-value in the HashTable
    public void put(String key, int val){
        int hashedKey = hashKey(key);

        if(occupied(hashedKey)){
            int stopIndex = hashedKey;

            if(hashedKey == hashtable.length - 1){
                hashedKey = 0;
            }else{
                hashedKey++;
            }

            while(occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if(occupied(hashedKey)){
            System.out.println("The HashMap is full.");
        }else{
            hashtable[hashedKey] = new Pair(key, val);
        }
    }

    // Method to get value for the particular key in the HashTable
    public int get(String key){
        int hashedKey = findKey(key);

        if(hashedKey == -1){
            return -1;
        }

        return hashtable[hashedKey].value;
    }

    // Method to find hashedKey for key in the HashTable
    public int findKey(String key){
        int hashedKey = hashKey(key);

        if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        
        int stopIndex = hashedKey;

        if(hashedKey == hashtable.length - 1){
            hashedKey = 0;
        }else{
            hashedKey++;
        }

        while(hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)){
            hashedKey = (hashedKey+1) % hashtable.length;
        }

        if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }else{
            return -1;
        }
    }

    // Method to remove the key-value pair from the HashTable
    public void remove(String key){
        int hashedKey = findKey(key);

        if(hashedKey == -1){
            System.out.println("No Entry with given key exist in table.");
        }else{
            Pair removedKey = hashtable[hashedKey];
            hashtable[hashedKey] = null;
            Pair[] oldtable = hashtable;
            hashtable = new Pair[oldtable.length];

            for(int i = 0; i < hashtable.length; i++){
                if(oldtable[i] != null){
                    put(oldtable[i].key, oldtable[i].value);
                }
            }

            System.out.println(removedKey.key + " = " + removedKey.value);
        }
    }

    // Method to check if particular position is occupied
    public boolean occupied(int pos){
        return hashtable[pos] != null;
    }

    // Method to generate hash for key
    public int hashKey(String key){
        return key.length() % hashtable.length;
    }

    // Method to print the HashTable
    public void print(){
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] != null)
                System.out.print(hashtable[i].key + " = " + hashtable[i].value + ", ");
        }

        System.out.println();
    }

}
