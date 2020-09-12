/*
 * In a flow network, an s-t cut is a cut that requires the source ‘s’ and the sink ‘t’ to be in different subsets, 
 * and it consists of edges going from the source’s side to the sink’s side. The capacity of an s-t cut is defined 
 * by the sum of the capacity of each edge in the cut-set.
 * The problem discussed here is to find minimum capacity s-t cut of the given network. 
 * Expected output is all edges of the minimum cut.
 */

package graphs.MaximumFlow;

import java.util.LinkedList;
import java.util.Queue;

public class MinCut {
	public static class Graph {
		public void minCut(int[][] graph, int s, int t) { 
			int u,v; 
			int[][] rGraph = new int[graph.length][graph.length];  
			for (int i = 0; i < graph.length; i++) { 
				for (int j = 0; j < graph.length; j++) { 
					rGraph[i][j] = graph[i][j]; 
				}
			} 
			 
			int[] parent = new int[graph.length];  
			   
			while (bfs(rGraph, s, t, parent)) { 
				int pathFlow = Integer.MAX_VALUE;          
				for (v = t; v != s; v = parent[v]) { 
					u = parent[v]; 
					pathFlow = Math.min(pathFlow, rGraph[u][v]); 
				} 
				
				for (v = t; v != s; v = parent[v]) { 
					u = parent[v]; 
					rGraph[u][v] = rGraph[u][v] - pathFlow; 
					rGraph[v][u] = rGraph[v][u] + pathFlow; 
				} 
			} 
			
			boolean[] isVisited = new boolean[graph.length];      
			dfs(rGraph, s, isVisited); 
			    
			for (int i = 0; i < graph.length; i++) { 
				for (int j = 0; j < graph.length; j++) { 
					if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) { 
						System.out.println(i + "-" + j); 
					} 
				} 
			}
		}	
		
		private static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {     
			boolean[] visited = new boolean[rGraph.length];      
			Queue<Integer> q = new LinkedList<Integer>(); 
			q.add(s); 
			visited[s] = true; 
			parent[s] = -1; 
			      
			while (!q.isEmpty()) { 
				int v = q.poll(); 
				for (int i = 0; i < rGraph.length; i++) { 
					if (rGraph[v][i] > 0 && !visited[i]) { 
						q.offer(i); 
						visited[i] = true; 
						parent[i] = v; 
					} 
				} 
			} 
			     
			return (visited[t] == true); 
		} 
			
		private static void dfs(int[][] rGraph, int s, boolean[] visited) { 
			visited[s] = true; 
			for (int i = 0; i < rGraph.length; i++) { 
				if (rGraph[s][i] > 0 && !visited[i]) { 
					dfs(rGraph, i, visited); 
				} 
			} 
		} 
	}
	
	public static void main(String[] args) {
		int edges[][] = {{0, 16, 13, 0, 0, 0}, 
						{0, 0, 10, 12, 0, 0}, 
						{0, 4, 0, 0, 14, 0}, 
						{0, 0, 9, 0, 0, 20}, 
						{0, 0, 0, 7, 0, 4}, 
						{0, 0, 0, 0, 0, 0}};
		
		Graph g = new Graph();
		g.minCut(edges, 0, 5);	
	}
}
