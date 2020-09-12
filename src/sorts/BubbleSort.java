/*
 * Bubble sort is based on the idea of repeatedly comparing pairs of 
 * adjacent elements and then swapping their positions if they exist
 * in the wrong order.
 * 
 * The complexity of bubble sort is O(n) for best case O(n^2) in both
 * worst and average cases, because the entire array needs to be
 * iterated for every element.
 */

package sorts;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
		int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		for (int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for(int i = 0; i < lastUnsortedIndex; i++) {
				if(intArray[i] > intArray[i+1]) {
					swap(intArray, i, i+1);
				}
			}
		}
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
	
	public static void swap(int[] array, int i, int j) {
		if(i == j) {
			return;
		}
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
