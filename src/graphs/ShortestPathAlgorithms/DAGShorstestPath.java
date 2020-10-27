package DataStructuresAndAlgorithms.src.graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DAGShorstestPath {
	public static class Edge {
		private double weight;
		private Vertex startVertex;
		private Vertex targetVertex;
		
		public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
			this.weight = weight;
			this.startVertex = startVertex;
			this.targetVertex = targetVertex;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public Vertex getStartVertex() {
			return startVertex;
		}

		public void setStartVertex(Vertex startVertex) {
			this.startVertex = startVertex;
		}

		public Vertex getTargetVertex() {
			return targetVertex;
		}

		public void setTargetVertex(Vertex targetVertex) {
			this.targetVertex = targetVertex;
		}
	}
	
	public static class Vertex {
		private String name;
		private List<Edge> adjacenciesList;
		private boolean visited;
		private Vertex predecessor;
		private double distance = Double.MAX_VALUE;
		
		public Vertex(String name) {
			this.name = name;
			this.adjacenciesList = new ArrayList<>();
		}
		
		public void addNeighbour(Edge edge) {
			this.adjacenciesList.add(edge);
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Edge> getAdjacenciesList() {
			return adjacenciesList;
		}

		public void setAdjacenciesList(List<Edge> adjacenciesList) {
			this.adjacenciesList = adjacenciesList;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public Vertex getPredecessor() {
			return predecessor;
		}

		public void setPredecessor(Vertex predecessor) {
			this.predecessor = predecessor;
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static class TopologicalSort {
		private Stack<Vertex> stack;
		
		public TopologicalSort() {
			this.stack = new Stack<>();
		}
		
		public void makeTopologicalOrder(List<Vertex> vertexList) {
			for(Vertex vertex: vertexList) {
				if(!vertex.isVisited()) {
					dfs(vertex);
				}
			}
		}

		private void dfs(Vertex vertex) {
			for(Edge edge: vertex.getAdjacenciesList()) {
				if(!edge.getTargetVertex().isVisited()) {
					edge.getTargetVertex().setVisited(true);
					dfs(edge.getTargetVertex());
				}
			}
			
			this.stack.push(vertex);
		}
		
		public Stack<Vertex> getTopologicalOrder(){
			Collections.reverse(stack);
			return this.stack;
		}
	}
	
	public static class AcyclicShortestPath {
		public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex) {
			sourceVertex.setDistance(0);
			TopologicalSort topologicalSort = new TopologicalSort();
			topologicalSort.makeTopologicalOrder(vertexList);
			
			Stack<Vertex> stack = topologicalSort.getTopologicalOrder();
			
			for(Vertex vertex: stack) {
				for(Edge edge: vertex.getAdjacenciesList()) {
					Vertex u = edge.getStartVertex();
					Vertex v = edge.getTargetVertex();
					
					double newDistance = u.getDistance() + edge.getWeight();
					
					if(newDistance < v.getDistance()) {
						v.setDistance(newDistance);
						v.setPredecessor(u);
					}
				}
			}
			
			if(targetVertex.getDistance() == Double.MAX_VALUE) {
				System.out.println("No Shortest Path Found");
			} else {
				System.out.println("Target Vertex Shortest Path: " + targetVertex.getDistance());
			}
		}
		
		public List<Vertex> shortestPathTo(Vertex targetVertex){		
			List<Vertex> shortestPathToTarget = new ArrayList<>();
			
			if(targetVertex.getDistance() == Double.MAX_VALUE) {
				System.out.println("No Path Detected.");
			}
			
			for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
				shortestPathToTarget.add(vertex);
			}
			
			Collections.reverse(shortestPathToTarget);
			
			return shortestPathToTarget;
		}
	}
	
	public static void main(String[] args) {
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");

		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);

		v1.addNeighbour(new Edge(1, v1, v2));
		v1.addNeighbour(new Edge(6, v1, v3));
		v2.addNeighbour(new Edge(4, v2, v3));
		v2.addNeighbour(new Edge(3, v2, v4));
		v3.addNeighbour(new Edge(8, v3, v5));
		v4.addNeighbour(new Edge(6, v4, v5));

		AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
		acyclicShortestPath.shortestPath(vertexList, v1, v5);
		System.out.println(acyclicShortestPath.shortestPathTo(v5));
	}

}
