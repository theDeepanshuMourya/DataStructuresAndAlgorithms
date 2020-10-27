/*
 * In computer science, cycle detection or cycle 
 * finding is the algorithmic problem of finding 
 * a cycle in a sequence of iterated function 
 * values.
 * 
 * Time Complexity of this method is same as time 
 * complexity of DFS traversal which is O(V+E).
 */

package DataStructuresAndAlgorithms.src.graphs.CycleDetection;

import java.util.ArrayList;
import java.util.List;

public class DFSCycleDetection {
	public static class Vertex {
		private String name;
		private boolean visited;
		private boolean beingVisited;
		private List<Vertex> adjacencyList;
		
		public Vertex(String name) {
			this.name = name;
			this.adjacencyList = new ArrayList<>();
		}
		
		public void addNeighbour(Vertex vertex) {
			this.adjacencyList.add(vertex);
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public boolean isBeingVisited() {
			return beingVisited;
		}

		public void setBeingVisited(boolean beingVisited) {
			this.beingVisited = beingVisited;
		}

		public List<Vertex> getAdjacencyList() {
			return adjacencyList;
		}

		public void setAdjacencyList(List<Vertex> adjacencyList) {
			this.adjacencyList = adjacencyList;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static class CycleDetection {
		public static void detectCycle(List<Vertex> vertexList) {
			for (Vertex v : vertexList) {
				if (!v.isVisited()) {
					search(v);
				}
			}
		}

		private static void search(Vertex vertex) {
			System.out.println("DFS on vertex " + vertex);
			vertex.setBeingVisited(true);
			
			for (Vertex v : vertex.getAdjacencyList()) {
				if(v.isBeingVisited()) {
					System.out.println("Backward edge detected so there is a cycle.");
					return;
				}
				
				if (!v.isVisited()) {
					System.out.println("Visiting vertex " + v);
					v.setVisited(true);
					search(v);
				}
			}
			
			vertex.setBeingVisited(false);
			vertex.setVisited(true);
		}
	}
	
	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		
		v1.addNeighbour(v2);
		v2.addNeighbour(v3);
		v3.addNeighbour(v1);
		v4.addNeighbour(v1);
		v4.addNeighbour(v5);
		v5.addNeighbour(v6);
		v6.addNeighbour(v4);
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		
		CycleDetection.detectCycle(vertexList);
	}
}
