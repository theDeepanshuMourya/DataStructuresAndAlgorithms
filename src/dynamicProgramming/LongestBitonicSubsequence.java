/*
 * Given an array of positive integers. The task is to print the maximum length of Bitonic subsequence.
 * A subsequenceof array is called Bitonic if it is first increasing, then decreasing.
 */

package dynamicProgramming;

public class LongestBitonicSubsequence {
	public static class biotonicSubsequence {
		public static int lbs(int[] arr, int n) {
			int lis[] = new int[n];
			int lds[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				lis[i] = 1;
				lds[i] = 1;
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && lis[i] < lis[j]+1) {
						lis[i] = lis[j]+1;
					}
				}
			}
			
			for(int i = n-2; i >= 0; i--) {
				for(int j = n-1; j > i; j--) {
					if(arr[i] > arr[j] && lds[i] < lds[j]+1) {
						lds[i] = lds[j]+1;
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(lis[i]+lds[i]-1 > max) {
					max = lis[i]+lds[i]-1;
				}
			}
			
			return max;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}; 
	    int n = arr.length; 
	    System.out.println("Length of LBS is "+ biotonicSubsequence.lbs(arr, n));
	}
}
