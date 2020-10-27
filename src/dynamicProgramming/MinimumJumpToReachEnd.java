/*
 * Given an array of integers where each element represents the max number of steps that can be 
 * made forward from that element. The task is to find the minimum number of jumps to reach the 
 * end of the array (starting from the first element). If an element is 0, then cannot move through that element.
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

import java.util.Arrays;

public class MinimumJumpToReachEnd {
	public static class MinJump {
		public static int minJumps(int[] a, int n){
		    int dp[] = new int[n];
		    Arrays.fill(dp, Integer.MAX_VALUE);
		    dp[0] = 0;
		    
		    for(int i = 1; i < n; i++){
		        for(int j = 0; j < i; j++){
		            if(a[j] + j >= i){
		                dp[i] = Math.min(dp[i], dp[j]+1);
		            }
		        }
		    }
		    
		    if(a[0] == 0 || dp[n-1] == Integer.MAX_VALUE)
		        return -1;
		    else
		        return dp[n-1];
		}
	}
	
	public static void main(String[] args) throws Exception {
	    int n = 11;
	    int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
	    
	    System.out.println(MinJump.minJumps(a, n));
	}
}
