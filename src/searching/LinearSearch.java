/* 
 * Linear search is used on a collections of items. 
 * It relies on the technique of traversing a list 
 * from start to end by exploring properties of all 
 * the elements that are found on the way.
 * 
 * The time complexity of the linear search is O(N) 
 * because each element in an array is compared only 
 * once.
 */

package DataStructuresAndAlgorithms.src.searching;

public class LinearSearch {
	public static void main(String[] args) {
		int[] intArray = {20, 35, -15, 7, 55, 1, -22};
		
		System.out.println(linearSearch(intArray, -15));
		System.out.println(linearSearch(intArray, 20));
		System.out.println(linearSearch(intArray, 22));
	}
	
	public static int linearSearch(int[] input, int value) {
		for (int i = 0; i < input.length; i++) {
			if(input[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
}
