/*
 * Regular Expression Matching:
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
	* '.' Matches any single character.
	* '*' Matches zero or more of the preceding element.
 * your task is to write the function that returns '1' if the regular expression is matched with text else returns '0'.
 * 
 * WildCard Pattern Matching;
 * Given a text 'str' and a wildcard pattern 'pattern', your task is to write the function 
 * that returns '1' if the wildcard pattern is matched with text else returns '0'.
 * The function takes two strings as arguments 'pattern' and 'str'.

	* The wildcard pattern can include the characters ‘?’ and ‘*’
	* ‘?’ – matches any single character
	* ‘*’ – Matches any sequence of characters (including the empty sequence)
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

public class PatternMatching {
	public static class RegularExpressionMatching {
		public static boolean isMatch(String s, String p) {
			boolean dp[][] = new boolean[s.length()+1][p.length()+1];
			dp[0][0] = true;
			
			for(int j = 1; j <= p.length(); j++) {
				if(p.charAt(j-1) == '*')
					dp[0][j] = dp[0][j-2];
			}
			
			for(int i = 1; i <= s.length(); i++) {
				for(int j = 1; j <= p.length(); j++) {
					if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
						dp[i][j] = dp[i-1][j-1];
					}else if(p.charAt(j-1) == '*') {
						dp[i][j] = dp[i][j-2];
						
						if(!dp[i][j]) {
							if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
								dp[i][j] = dp[i-1][j];
						}
					}
				}
			}
			
			return dp[s.length()][p.length()];
		}
	}
	
	public static class WildcardMatching {
		public static boolean isMatch(String s, String p) {
			boolean dp[][] = new boolean[s.length()+1][p.length()+1];
			dp[0][0] = true;
			
			for(int j = 1; j <= p.length(); j++) {
				if(p.charAt(j-1) == '*')
					dp[0][j] = dp[0][j-1];
			}
			
			for(int i = 1; i <= s.length(); i++) {
				for(int j = 1; j <= p.length(); j++) {
					if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
						dp[i][j] = dp[i-1][j-1];
					}else if(p.charAt(j-1) == '*') {
						dp[i][j] = dp[i-1][j] || dp[i][j-1];
					}
				}
			}
			
			return dp[s.length()][p.length()];
		}
	}
	
	public static void main(String[] args) {
		String s = "acdcb";
		String p = "a*c?b";
		
		System.out.println(WildcardMatching.isMatch(s, p));
		
		String s1 = "mississippi";
		String p1 = "mis*is*p*.";
		
		System.out.print(RegularExpressionMatching.isMatch(s1, p1));
	}
}
