/*
 * Bubble sort is based on the idea of repeatedly comparing pairs of 
 * adjacent elements and then swapping their positions if they exist
 * in the wrong order.
 * 
 * The complexity of bubble sort is O(n) for best case O(n^2) in both
 * worst and average cases, because the entire array needs to be
 * iterated for every element.
 */

package DataStructuresAndAlgorithms.src.sorts;

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
		
		for(int i = 0; i < n-1; i++){
			for(int j = 0; j < n-i-1; j++){
				if(intArray[j] > intArray[j+1]){
					int temp = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = temp;
				}
			}
		}
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
}
