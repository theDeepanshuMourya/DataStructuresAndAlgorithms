/* Merge sort is a divide-and-conquer algorithm 
 * based on the idea of breaking down a list into 
 * several sub-lists until each sublist consists 
 * of a single element and merging those sublists 
 * in a manner that results into a sorted list.
 * 
 * The list of size N is divided into a max of logN 
 * parts, and the merging of all sublists into a 
 * single list takes O(N) time, the worst case run 
 * time of this algorithm is O(NlogN).
 */

package DataStructuresAndAlgorithms.src.sorts;

import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
        int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}

        mergeSort(intArray, 0, n-1);

        System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}

    public static void mergeSort(int[] input, int start, int end) {
        if (start < end) {
            int mid = (start + end)/2;
            mergeSort(input, start, mid);
            mergeSort(input, mid+1, end);
            merge(input, start, mid, end);
        }
    }

    public static void merge(int[] input, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int index = 0;

        int temp[] = new int[end - start + 1];

        while(i <= mid && j <= end){
            if(input[i] < input[j]){
                temp[index++] = input[i++];
            }else{
                temp[index++] = input[j++];
            }
        }

        while(i <= mid){
            temp[index++] = input[i++];
        }

        while(j <= end){
            temp[index++] = input[j++];
        }

        for(int k = start; k <= end; k++){
            input[k] = temp[k - start];
        }
    }
}