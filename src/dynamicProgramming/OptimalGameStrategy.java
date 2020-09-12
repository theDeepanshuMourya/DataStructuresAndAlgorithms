/*
 * You are given an array A of size N. The array contains integers and is of even length. 
 * The elements of the array represent N coin of values V1, V2, ....Vn. 
 * You play against an opponent in an alternating way.
 * 
 * In each turn, a player selects either the first or last coin from the row, removes it from 
 * the row permanently, and receives the value of the coin.
 * 
 * You need to determine the maximum possible amouint of money you can win if you go first.
 */

package dynamicProgramming;

import java.util.Arrays;

public class OptimalGameStrategy {
	public static class Pair {
		int first, second;

		@Override
		public String toString() {
			return "[" + first + ", " + second + "]";
		}
		
	}
	
	public static class Gamestrategy {
		public static int maxAmount(int[] arr) {
			int n = arr.length;
			Pair moves[][] = new Pair[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					moves[i][j] = new Pair();
				}
			}
			
			for(int i = 0; i < n; i++) {
				moves[i][i].first = arr[i];
				moves[i][i].second = 0;
			}
			
			for(int l = 2; l <= n; l++) {
				for(int i = 0; i <= n-l; i++) {
					int j = i+l-1;
					
					if(moves[i+1][j].second + arr[i] > moves[i][j-1].second + arr[j]) {
						moves[i][j].first = moves[i+1][j].second + arr[i];
						moves[i][j].second = moves[i+1][j].first;
					}else {
						moves[i][j].first = moves[i][j-1].second + arr[i];
						moves[i][j].second = moves[i][j-1].first;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				System.out.println(Arrays.toString(moves[i]));
			}
			
			return moves[0][n-1].first;
		}
	}
	
	public static void main(String[] args) {
		int pots[] = {3,1,5,6,2,9,3};
		System.out.println(Gamestrategy.maxAmount(pots));
	}
}
