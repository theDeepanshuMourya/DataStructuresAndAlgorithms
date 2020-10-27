/*
 * Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

public class CountBinaryStringWithoutAdjacentOnes {
	public static class CountStrings {
		public int count(int K) {
			int a[] = new int[K+1];
			a[0] = 1;
			a[1] = 2;
			
			for(int i = 2; i <= K; i++) {
				a[i] = a[i-1]+a[i-2];
			}
			
			return a[K];
		}
	}
	
	public static void main(String[] args) {
		int K = 3;
		CountStrings cs = new CountStrings();
		System.out.println(cs.count(K));
	}
}
