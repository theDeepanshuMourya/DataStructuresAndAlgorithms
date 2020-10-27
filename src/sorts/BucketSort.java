/*
 * Bucket sort is a comparison sort algorithm that operates 
 * on elements by dividing them into different buckets and 
 * then sorting these buckets individually. Each bucket is 
 * sorted individually using a separate sorting algorithm 
 * or by applying the bucket sort algorithm recursively. 
 * Bucket sort is mainly useful when the input is uniformly 
 * distributed over a range.
 * 
 * The algorithm guarantee a best case time complexity of 
 * O(NlogN)
 */

package DataStructuresAndAlgorithms.src.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BucketSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		
		int[] intArray = new int[n];
		
		System.out.println("Enter the elements:");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		bucketSort(intArray);
		
		System.out.println("The Sorted Array is:");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		sc.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void bucketSort(int[] input) {
		List<Integer>[] buckets = new List[10];
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < input.length; i++) {
			buckets[hash(input[i])].add(input[i]);
		}
		
		for(List bucket: buckets) {
			Collections.sort(bucket);
		}
		
		int j = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int value : buckets[i]) {
				input[j++] = value;
			}
		}
	}
	
	public static int hash(int value) {
		return value / (int) 10 % 10;
	}
}
