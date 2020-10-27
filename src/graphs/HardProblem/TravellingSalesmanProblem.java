/*
 * Travelling Salesman Problem (TSP): 
 * Given a set of cities and distance between every pair of cities, the problem is to 
 * find the shortest possible route that visits every city exactly once and returns to 
 * the starting point with the minimum cost.
 */

package DataStructuresAndAlgorithms.src.graphs.HardProblem;

import java.util.ArrayList;
import java.util.List;

public class TravellingSalesmanProblem {
	public static class Pair {
		int v, weight;
	    
	    public Pair(int v, int weight){
	        this.v = v;
	        this.weight = weight;
	    }
	}
	
	public static class Graph {
		int min;
		public int minCost(int[][] graph, int V) {
			@SuppressWarnings("unchecked")
			List<Pair> edges[] = new ArrayList[V];
	        for(int i = 0; i < V; i++){
	            edges[i] = new ArrayList<Pair>();
	        }
	        
	        for(int u = 0; u < V; u++){
	            for(int v = 0; v < V; v++){
	                int weight = graph[u][v];
	                if(weight != 0){
	                    edges[u].add(new Pair(v, weight));
	                }
	            }
	        }
	        
	        min = Integer.MAX_VALUE;
	        boolean visited[] = new boolean[V];
	        dfs(0, 0, 1, visited, edges, V);
	        return min;
		}
		
		private void dfs(int vertex, int sum, int count, boolean[] visited, List<Pair> edges[], int V){
		    if(count == V){
		        int w = edges[vertex].get(0).weight;
		        min = Math.min(sum+w, min);
		        return;
		    }
		    
		    visited[vertex] = true;
		    for(Pair x: edges[vertex]){
		        int v = x.v;
		        int w = x.weight;
		        
		        if(!visited[v]){
		            dfs(v, sum+w, count+1, visited, edges, V);
		        }
		    }
		    
		    visited[vertex] = false;
		}
	}
	
	public static void main(String[] args) {
		int G[][] = {{0,1000,5000}, {5000,0,1000},{1000,5000,0}};
		Graph graph = new Graph();
		System.out.println(graph.minCost(G, 3));
	}
}
