/*
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

public class LongestPalindromicSubsequence {
	public static class lps {
		public static int sequenceLength(String str) {
			int n = str.length();
			int T[][] = new int[n][n];
			int j;
			
			for(int i = 0; i < n; i++) {
				T[i][i] = 1;
			}
			
			for(int l = 2; l <= n; l++) {
				for(int i = 0; i < n-l+1; i++) {
					j = i+l-1;
					if(str.charAt(i)==str.charAt(j) && l==2) {
						T[i][j] = 2;
					} else if(str.charAt(i)==str.charAt(j)) {
						T[i][j] = T[i+1][j-1]+2;
					} else {
						T[i][j] = Math.max(T[i][j-1], T[i+1][j]);
					}
				}
			}
			
			return T[0][n-1];
		}
	}
	
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
        System.out.println("The lnegth of the lps is "+ lps.sequenceLength(str));
	}
}
