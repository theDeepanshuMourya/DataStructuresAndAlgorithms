/* Insertion sort is based on the idea that one 
 * element from the input elements is consumed 
 * in each iteration to find its correct position 
 * i.e, the position to which it belongs in a 
 * sorted array.
 * 
 * In worst case,each element is compared with all 
 * the other elements in the sorted array. For N elements, 
 * there will be N^2 comparisons. Therefore, the time 
 * complexity is O(N^2).
 */

package sorts;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
		int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			int newElement = intArray[firstUnsortedIndex];
			
			int i;
			
			for (i = firstUnsortedIndex; i > 0 && intArray[i-1] > newElement; i--) {
				intArray[i] = intArray[i-1];
			}
			
			intArray[i] = newElement;
		}
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
}
