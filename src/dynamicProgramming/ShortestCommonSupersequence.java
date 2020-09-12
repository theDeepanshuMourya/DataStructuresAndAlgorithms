/*
 * Given two strings str1 and str2, find the length of the smallest string which has both, 
 * str1 and str2 as its sub-sequences.
 * Note: str1 and str2 can have both uppercase and lowercase letters.
 */

package dynamicProgramming;

public class ShortestCommonSupersequence {
	public static class scs {
		public static String supersequence(String X, String Y) {
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
						L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			int i = m; int j = n;
			
			while(i > 0 && j > 0) {
				if(X.charAt(i-1) == Y.charAt(j-1)) {
					sb.append(X.charAt(i-1));
					i--;
					j--;
				} else if(L[i-1][j] > L[i][j-1]) {
					sb.append(X.charAt(i-1));
					i--;
				} else {
					sb.append(Y.charAt(j-1));
					j--;
				}
			}
			
			while(i > 0) {
				sb.append(X.charAt(i-1));
				i--;
			}
		    
		    while(j > 0) {
		    	sb.append(Y.charAt(j-1));
		    	j--;
		    }
		    
		    return sb.reverse().toString();
		}
	}
	
	public static void main(String[] args) {
		String X = "abac";
		String Y = "cab";
		
		System.out.println(scs.supersequence(X, Y));
	}
}
