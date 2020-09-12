/*
 * In graph theory, a flow network is defined as a directed graph involving a source(S) and a sink(T) 
 * and several other nodes connected with edges. Each edge has an individual capacity which is the 
 * maximum limit of flow that edge could allow.
 * Maximum Flow: 
 * It is defined as the maximum amount of flow that the network would allow to flow from source to sink. 
 * Multiple algorithms exist in solving the maximum flow problem. Two major algorithms to solve these 
 * kind of problems are Ford-Fulkerson algorithm and Dinic's Algorithm. They are explained below.
 */

package graphs.MaximumFlow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonAlgorithm {
	public static class Graph {
		public int maxFlow(int[][] edges, int V, int source, int sink){
		    int residual[][] = new int[V][V];
		    residual = edges;
		    
		    int parent[] = new int[V];
		    int maxFlow = 0;
		    
		    while(bfs(residual, parent, source, sink, V)){
		        int flow = Integer.MAX_VALUE;
		        int v = sink;
		        
		        while(v != source){
		            int u = parent[v];
		            flow = Math.min(flow, residual[u][v]);
		            v = u;
		        }
		        
		        maxFlow += flow;
		        
		        v = sink;
		        while(v != source){
		            int u = parent[v];
		            residual[u][v] -= flow;
		            residual[v][u] += flow;
		            v = u;
		        }
		    }
		    
		    return maxFlow;
		}
		
		private boolean bfs(int[][] residual, int[] parent, int source, int sink, int V){
	        boolean visited[] = new boolean[V];
	        Queue<Integer> queue = new LinkedList<>();
	        
	        queue.add(source);
	        visited[source] = true;
	        boolean flag = false;
	        
	        while(!queue.isEmpty()){
	            int u = queue.poll();
	            for(int v = 0; v < V; v++){
	                if(!visited[v] && residual[u][v] > 0){
	                    parent[v] = u;
	                    visited[v] = true;
	                    queue.add(v);
	                    
	                    if(v == sink){
	                        flag = true;
	                        break;
	                    }
	                }
	            }
	        }
	        
	        return flag;
		}
	}
	
	public static void main(String[] args) {
		int edges[][] = new int[][] {{0, 16, 13, 0, 0, 0}, 
						            {0, 0, 10, 12, 0, 0}, 
						            {0, 4, 0, 0, 14, 0}, 
						            {0, 0, 9, 0, 0, 20}, 
						            {0, 0, 0, 7, 0, 4}, 
						            {0, 0, 0, 0, 0, 0}};
        
        int V = 6;
        Graph graph = new Graph();
        System.out.println(graph.maxFlow(edges, V, 0, 5));
	}
}
