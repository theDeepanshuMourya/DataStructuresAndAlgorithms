/* ShellSort is mainly a variation of Insertion Sort. 
 * In insertion sort, we move elements only one position 
 * ahead. When an element has to be moved far ahead, 
 * many movements are involved. The idea of shellSort is 
 * to allow exchange of far items. In shellSort, we make 
 * the array h-sorted for a large value of h. We keep 
 * reducing the value of h until it becomes 1. An array 
 * is said to be h-sorted if all sublists of every h’th 
 * element is sorted.
 * 
 * Time complexity of above implementation of shellsort is O(n^2). 
 */


package DataStructuresAndAlgorithms.src.sorts;

import java.util.Scanner;

public class ShellSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
		int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		for (int gap = intArray.length /2; gap > 0; gap /= 2) {
			
			for (int i = gap; i < intArray.length; i++) {
				int newElement = intArray[i];
				
				int j = i;
				
				while (j >= gap && intArray[j-gap] > newElement) {
					intArray[j] = intArray[j-gap];
					j -= gap;
				}
				
				intArray[j] = newElement;
			}
			
		}
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
}
