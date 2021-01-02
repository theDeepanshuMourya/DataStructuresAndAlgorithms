/*The Selection sort algorithm is based on the 
 * idea of finding the minimum or maximum element 
 * in an unsorted array and then putting it in 
 * its correct position in a sorted array.
 * 
 * Time complexity of the algorithm is O(N^2)
 */

package DataStructuresAndAlgorithms.src.sorts;

import java.util.Scanner;

public class SelectionSort {
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
			int min = i;

			for(int j = i+1; j < n; j++){
				if(intArray[j] < intArray[min]){
					min = j;
				}
			}

			swap(intArray, i, min);
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
