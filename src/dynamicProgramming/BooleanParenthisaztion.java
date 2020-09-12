/*
 * Given a boolean expression with following symbols.

Symbols
    'T' ---> true
    'F' ---> false

And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR

Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

 */

package dynamicProgramming;

import java.util.Scanner;

public class BooleanParenthisaztion {
	public static class Paranthesis {		
		public static int countWays(char[] exp, char[] oper, int n){
	        int T[][] = new int[n][n];
	        int F[][] = new int[n][n];
	        
	        for(int i = 0; i < n; i++){
	            T[i][i] = (exp[i] == 'T') ? 1 : 0;
	            F[i][i] = (exp[i] == 'F') ? 1 : 0;
	        }
	        
	        int mod = 1003;
	        
	        for (int l = 2; l <= n; l++){
	            for (int i = 0; i <= n-l; i++){
	                int j = i+l-1;
	                
	                for (int k = i; k < j; k++)
	                {
	                    int tik = (T[i][k] + F[i][k]);
	                    int tkj = (T[k + 1][j] + F[k + 1][j]);
	                    
	                    if (oper[k] == '&'){
	                        T[i][j] += (T[i][k] * T[k + 1][j]);
	                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
	                    }
	                    
	                    if (oper[k] == '|'){
	                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
	                        F[i][j] += (F[i][k] * F[k + 1][j]);
	                    }
	                    
	                    if (oper[k] == '^'){
	                        T[i][j] += (T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j]);
	                        F[i][j] += (T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j]);
	                    }
	                    
	                    T[i][j] %= mod;
	                    F[i][j] %= mod;
	                }
	            }
	        }
	        
	        return T[0][n-1];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = 49;
	    String str = "T^T&T^T|F^F^T&F&F^T|T&T&F&F^T&T|F|F|F|F&F^T^T|F|T";
	    
	    String symb = "";
	    String op = "";
	    
	    for(int i = 0; i < n; i++){
	        if(str.charAt(i) == 'T' || str.charAt(i) == 'F'){
	            symb += str.charAt(i);
	        }else{
	            op += str.charAt(i);
	        }
	    }
	    
	    char[] exp = symb.toCharArray();
	    char[] oper = op.toCharArray();
	    
	    int ans = Paranthesis.countWays(exp, oper, exp.length);
	    
	    System.out.println(ans);
		
		sc.close();
	}
}
