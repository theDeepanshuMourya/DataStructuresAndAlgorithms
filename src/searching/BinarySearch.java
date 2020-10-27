/* 
 * Binary search is the most popular Search algorithm. 
 * It is efficient and also one of the most commonly 
 * used techniques that is used to solve problems.
 * 
 * Binary search works only on a sorted set of elements. 
 * To use binary search on a collection, the collection 
 * must first be sorted.
 * 
 * When binary search is used to perform operations on a 
 * sorted set, the number of iterations can always be 
 * reduced on the basis of the value that is being searched.
 * 
 * As we dispose off one part of the search case during every 
 * step of binary search, and perform the search operation on 
 * the other half, this results in a worst case time 
 * complexity of O(logN).
 */

package DataStructuresAndAlgorithms.src.searching;

public class BinarySearch {
	public static void main(String[] args) {
		int[] intArray = {-22, -15, 1, 7, 20, 35, 55};
		
		System.out.println(iterativeBinarySearch(intArray, 35));
		System.out.println(recursiveBinarySearch(intArray, -15));
	}
	
	public static int iterativeBinarySearch(int[] input, int value) {
		int start = 0;
		int end = input.length;
		
		while (start < end) {
			int midpoint = (start + end) / 2;
			if (input[midpoint] == value) {
				return midpoint;
			} else if (input[midpoint] < value) {
				start = midpoint + 1;
			} else {
				end = midpoint;
			}
		}
		
		return -1;
	}
	
	public static int recursiveBinarySearch(int[] input, int value) {
		return recursiveBinarySearch(input, 0, input.length, value);
	}
	
	public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
		if(start >= end) {
			return -1;
		}
		
		int midpoint = (start + end)/2;
		
		if(input[midpoint] == value) {
			return midpoint;
		} else if (input[midpoint] < value) {
			return recursiveBinarySearch(input, midpoint + 1, end, value);
		} else {
			return recursiveBinarySearch(input, start, midpoint, value);
		}
	}
}
