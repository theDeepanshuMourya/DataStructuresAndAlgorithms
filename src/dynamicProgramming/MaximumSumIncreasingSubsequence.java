/*
 * Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

public class MaximumSumIncreasingSubsequence {
	public static class maxSumIS {
		public static int maxSum(int[] nums, int n) {
			int sum[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				sum[i] = nums[i];
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(nums[i] > nums[j] && sum[i] < sum[j]+nums[i]) {
						sum[i] = sum[j]+nums[i];
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(max < sum[i]) {
					max = sum[i];
				}
			}
			
			return max;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		int n = nums.length;
		
		System.out.println(maxSumIS.maxSum(nums, n));
	}
}
