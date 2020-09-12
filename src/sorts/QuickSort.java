/*Quick sort is based on the divide-and-conquer 
 * approach based on the idea of choosing one 
 * element as a pivot element and partitioning 
 * the array around it such that: Left side of 
 * pivot contains all the elements that are less 
 * than the pivot element Right side contains 
 * all elements greater than the pivot
 * 
 * It reduces the space complexity and removes 
 * the use of the auxiliary array that is used in 
 * merge sort. Selecting a random pivot in an array 
 * results in an improved time complexity in most 
 * of the cases.
 * 
 * Complexity The worst case time complexity of this 
 * algorithm is O(N^2) , but as this is randomized 
 * algorithm, its time complexity fluctuates between 
 * O(N^2) and O(NlogN) and mostly it comes out to be 
 * O(NlogN).
 */

package sorts;

import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
		int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		quickSort(intArray, 0, intArray.length);
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
	
	public static void quickSort(int[] input, int start, int end) {
		if (end - start < 2) {
			return;
		}
		
		int pivotIndex = partition(input, start, end);
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex +1, end);
	}
	
	public static int partition(int[] input, int start, int end) {
		//	This is using the first element as pivot
		
		int pivot = input[start];
		int i = start;
		int j = end;
		
		while (i < j) {
			
			//	Empty body loop
			while(i < j && input[--j] >= pivot);
			
			if(i < j) {
				input[i] = input[j];
			}
			
			//	Empty body loop
			while(i < j && input[++i] <= pivot);
			
			if(i < j) {
				input[j] = input[i];
			}
		}
		
		input[j] = pivot;
		return j;
	}
}
