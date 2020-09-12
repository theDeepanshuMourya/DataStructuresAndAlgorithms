/*
 * Prim's minimum spanning tree. Only works on undirected graphs. It finds a
 * subset of the edges that forms a tree that includes every vertex, where the
 * total weight of all the edges in the tree is minimized.
 * 
 * Time Complexity of the below program is O(V^2). If the input graph is 
 * represented using adjacency list, then the time complexity of Prim’s 
 * algorithm can be reduced to O(ElogV) with the help of binary heap.
 */

package graphs.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
	public static class Edge implements Comparable<Edge> {
		private double weight;
		private Vertex sourceVertex;
		private Vertex targetVertex;
		
		public Edge(double weight, Vertex sourceVertex, Vertex targetVertex) {
			this.weight = weight;
			this.sourceVertex = sourceVertex;
			this.targetVertex = targetVertex;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public Vertex getSourceVertex() {
			return sourceVertex;
		}

		public void setSourceVertex(Vertex sourceVertex) {
			this.sourceVertex = sourceVertex;
		}

		public Vertex getTargetVertex() {
			return targetVertex;
		}

		public void setTargetVertex(Vertex targetVertex) {
			this.targetVertex = targetVertex;
		}

		@Override
		public int compareTo(Edge edge) {
			return Double.compare(this.weight, edge.getWeight());
		}	
	}

	
	public static class Vertex {
		private String name;
		private boolean visited;
		private Vertex previousVertex;
		private List<Edge> adjacenciesList;
		
		public Vertex(String name) {
			this.name = name;
			this.adjacenciesList = new ArrayList<>();
		}
		
		public void addEdge(Edge edge) {
			this.adjacenciesList.add(edge);
		}
		
		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public Vertex getPreviousVertex() {
			return previousVertex;
		}

		public void setPreviousVertex(Vertex previousVertex) {
			this.previousVertex = previousVertex;
		}

		public List<Edge> getAdjacenciesList() {
			return adjacenciesList;
		}

		public void setAdjacenciesList(List<Edge> adjacenciesList) {
			this.adjacenciesList = adjacenciesList;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static class Algorithm {
		private List<Vertex> unvisitedVertices;
		private List<Edge> spanningTree;
		private PriorityQueue<Edge> edgeHeap;
		private double fullCost;
		
		public Algorithm(List<Vertex> unvisitedList) {
			this.spanningTree = new ArrayList<>();
			this.unvisitedVertices = unvisitedList;
			this.edgeHeap = new PriorityQueue<>();
		}
		
		public void primsAlgorithm(Vertex vertex) {
			this.unvisitedVertices.remove(vertex);
			
			while(!unvisitedVertices.isEmpty()) {
				for (Edge edge : vertex.getAdjacenciesList()) {
					if(this.unvisitedVertices.contains(edge.getTargetVertex())) {
						this.edgeHeap.add(edge);
					}
				}
				
				Edge minEdge = this.edgeHeap.remove();
				this.spanningTree.add(minEdge);
				this.fullCost += minEdge.getWeight();
				
				vertex = minEdge.getTargetVertex();
				this.unvisitedVertices.remove(vertex);
			}
		}
		
		public void showMST() {
			System.out.println("The Minimum Spanning Tree Cost: " + this.fullCost);
			
			for(int i = 0; i < spanningTree.size(); i++) {			
				if(i == spanningTree.size()-1) {
					System.out.print(spanningTree.get(i).getSourceVertex() + "" + spanningTree.get(i).getTargetVertex());
				} else {
					System.out.print(spanningTree.get(i).getSourceVertex() + "" + spanningTree.get(i).getTargetVertex() + "--");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		
		vertex0.addEdge(new Edge(1, vertex0, vertex1));	
		vertex0.addEdge(new Edge(1, vertex0, vertex2));	
		vertex1.addEdge(new Edge(10, vertex1, vertex2));
		
		vertex1.addEdge(new Edge(1, vertex1, vertex0));	
		vertex2.addEdge(new Edge(1, vertex2, vertex0));	
		vertex2.addEdge(new Edge(10, vertex2, vertex1));		
		
		Algorithm algorithm = new Algorithm(vertexList);		
		algorithm.primsAlgorithm(vertex2);
		algorithm.showMST();
	}
}
