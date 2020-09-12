/*
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. 
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
 * Your task is to write a function which returns an integer denoting the longest chain 
 * which can be formed from a given set of pairs.
 */

package dynamicProgramming;

import java.util.Arrays;

public class MaxLengthChain {
	public static class ChainLength {
		public static int maxLength(int[][] arr) {
			int n = arr.length;
			Arrays.sort(arr, (x,y) -> x[0]-y[0]);
			
			for(int i = 0; i < n; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			
			int lis[] = new int[n];
			Arrays.fill(lis, 1);
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(arr[i][0] > arr[j][1] && lis[i] < lis[j]+1)
						lis[i] = lis[j]+1;
				}
			}
			
			return Arrays.stream(lis).max().getAsInt();
		}
	}

	
	public static void main(String[] args) {
		int arr[][] = new int[][]{{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
		
		System.out.print(ChainLength.maxLength(arr));
	}
}
