/*
 * Given two sequences, find the length of longest subsequence present in both of them. 
 * Both the strings are of uppercase.
 */

package dynamicProgramming;

public class LongestCommonSubsequence {
	public static class lcs {
		public void _lcs(String X, String Y) {
			int m = X.length();
			int n = Y.length();
			
			int L[][] = new int[m+1][n+1];
			
			for(int i = 0; i <= m; i++) {
				for(int j = 0; j<= n; j++) {
					if(i == 0 || j == 0) {
						L[i][j] = 0;
					} else if(X.charAt(i-1) == Y.charAt(j-1)) {
						L[i][j] = 1 + L[i-1][j-1];
					} else {
						L[i][j] = max(L[i-1][j], L[i][j-1]);
					}
				}
			}
			
			System.out.println("The Length of Longest Common Subsequence is " + L[m][n]);
			
			int temp = L[m][n];
			int index = temp;
			
			char lcs[] = new char[index];
			int i = m; int j = n;
			
			while(i > 0 && j > 0) {
				if(X.charAt(i-1) == Y.charAt(j-1)) {
					lcs[index-1] = X.charAt(i-1);
					i--;
					j--;
					index--;
				} else if(L[i-1][j] > L[i][j-1]) {
					i--;
				} else {
					j--;
				}
			}
			
			System.out.print("Longest Common Subsequence is ");
			for(int x = 0; x < temp; x++) {
				System.out.print(lcs[x]);
			}
		}
		
		public int max(int a, int b) {
			return (a>b?a:b);
		}
	}
	
	public static void main(String[] args) {
		lcs lcs = new lcs	(); 
	    String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB";
	    
	    lcs._lcs(s1, s2);

	}
}
