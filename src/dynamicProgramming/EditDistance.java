/*
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

public class EditDistance {
	public static void main(String[] args) {
		String str1 = "sunday"; 
        String str2 = "saturday"; 
        System.out.println(minDistance(str1, str2));

	}
	
	public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0){
                    dp[i][j] = j;
                } else if(j == 0){
                    dp[i][j] = i;
                } else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);      
                }
            }
        }
        
        return dp[m][n];
    }
	
	public static int min(int a, int b, int c) {
		if(a < b && a < c){
            return a;
        } else if(b < a && b < c){
            return b;
        } else{
            return c;
        }
	}
}
