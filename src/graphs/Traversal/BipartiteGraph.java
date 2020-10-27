/*
 * Given an adjacency matrix representation of a graph g having 0 based index. 
 * Check if the graph is Bipartite or not. 
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets, 
 * U and V such that every edge (u, v) either connects a vertex from U to V or a vertex 
 * from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, 
 * or u belongs to V and v to U. We can also say that there is no edge that connects 
 * vertices of same set.
 */

package DataStructuresAndAlgorithms.src.graphs.Traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
	public static class Graph {	
		boolean isBipartite(int G[][],int V){
	        HashMap<Integer, List<Integer>> map = new HashMap<>();
	        
	        for(int i = 0; i < V; i++){
	            map.put(i, new ArrayList<>());
	            for(int j = 0; j < V; j++){
	                if(G[i][j] == 1){
	                    map.get(i).add(j);
	                }
	            }
	        }
	        
	        int color[] = new int[V];
	        
	        for(int i = 0; i < V; i++){
	            Queue<Integer> queue = new LinkedList<>();
	            int curr = i;
	            
	            if(color[curr] == 0){
	                color[curr] = 1;
	                queue.add(curr);
	                
	                while(!queue.isEmpty()){
	                    curr = queue.remove();
	                    for(int x: map.get(curr)){
	                        if(color[x] == 0){
	                            if(color[curr] == 1) color[x] = 2;
	                            else if(color[curr] == 2) color[x] = 1;
	                            
	                            queue.add(x);
	                        }else if(color[curr] == color[x]){
	                            return false;
	                        }
	                    }
	                }
	            }
	        }
	        
	        return true;
	    }
	}
	
	public static void main(String[] args) {
		int G[][] = {{0, 1, 0, 1}, 
					{1, 0, 1, 0}, 
					{0, 1, 0, 1}, 
					{1, 0, 1, 0}};
		int V = 4;
		Graph g = new Graph();
		System.out.println(g.isBipartite(G, V));
	}
}
