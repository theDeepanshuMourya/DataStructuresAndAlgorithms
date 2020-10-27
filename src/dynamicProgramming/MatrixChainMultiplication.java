/*
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * The problem is not actually to perform the multiplications, but merely to decide in which order 
 * to perform the multiplications. There are many options to multiply a chain of matrices because 
 * matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same.
 */

package DataStructuresAndAlgorithms.src.dynamicProgramming;

public class MatrixChainMultiplication {
	public static class matrixChain {
		public static int count(int[] arr, int n) {
			int[][] M = new int[n][n];
		    
		    for(int i = 1; i < n; i++){
		        M[i][i] = 0;
		    }
		    
		    for(int i = 1; i < n-1; i++){
		        for(int j = i+1; j < n; j++){
		            M[j-i][j] = Integer.MAX_VALUE;
		            
		            for(int k = j-i; k < j; k++){
		                int q = M[j-i][k] + M[k+1][j] + (arr[j-i-1]*arr[k]*arr[j]);
		                
		                if(q < M[j-i][j]){
		                    M[j-i][j] = q;
		                }
		            }
		        }
		    }
		    
		    return M[1][n-1];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {40, 20, 30, 10, 30}; 
        int n = arr.length;
        
        System.out.println(matrixChain.count(arr, n));

	}
}
