/*
 * BFS is a traversing algorithm where you should 
 * start traversing from a selected node 
 * (source or starting node) and traverse the graph 
 * layerwise thus exploring the neighbour nodes 
 * (nodes which are directly connected to source node). 
 * You must then move towards the next-level neighbour 
 * nodes.
 * 
 * The time complexity of the algorithm is O(V+E).
 */

package graphs.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	public static class Vertex {
		
		private int data;
		private boolean visited;
		private List<Vertex> neighbourList;
		
		public Vertex(int data) {
			this.data = data;
			this.neighbourList = new ArrayList<>();
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public List<Vertex> getNeighbourList() {
			return neighbourList;
		}

		public void setNeighbourList(List<Vertex> neighbourList) {
			this.neighbourList = neighbourList;
		}
		
		public void addNeighbour(Vertex vertex) {
			this.neighbourList.add(vertex);
		}
		
		@Override
		public String toString() {
			return ""+this.data;
		}
	}
	
	public static class bfs {
		public static void search(Vertex root) {
			Queue<Vertex> queue = new LinkedList<>();
			
			root.setVisited(true);
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Vertex actualVertex = queue.remove();
				System.out.println(actualVertex + " ");
				
				for (Vertex v : actualVertex.getNeighbourList()) {
					if (!v.isVisited()) {
						v.setVisited(true);
						queue.add(v);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		
		v1.addNeighbour(v2);
		v1.addNeighbour(v4);
		v2.addNeighbour(v5);
		v4.addNeighbour(v3);
		v3.addNeighbour(v1);
		
		bfs.search(v1);
	}
}
