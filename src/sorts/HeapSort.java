/*Heap sort is a comparison based sorting technique 
 * based on Binary Heap data structure. It is similar 
 * to selection sort where we first find the maximum 
 * element and place the maximum element at the end. 
 * We repeat the same process for remaining element.
 * 
 * Time complexity of heapify is O(Logn). 
 * Time complexity of createAndBuildHeap() is O(n) 
 * and overall time complexity of Heap Sort is O(nLogn).
 */

package DataStructuresAndAlgorithms.src.sorts;

import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
		int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		heapSort(intArray);
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
	
	public static void heapSort(int arr[]) { 
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		} 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
	public static void heapify(int arr[], int n, int i) { 
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
    }
}
