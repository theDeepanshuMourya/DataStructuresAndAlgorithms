/*
 * Bellman Ford's algorithm is used to find the shortest paths 
 * from the source vertex to all other vertices in a weighted 
 * graph. It depends on the following concept: Shortest path 
 * contains at most n-1 edges, because the shortest path 
 * couldn't have a cycle.
 * 
 * Time Complexity of Bellman Ford algorithm is relatively 
 * high O(V.E), in case E = V^2, O(E^3).
 */

package graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFordAlgorithm {
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
		private Vertex previousVertex;
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

		public Vertex getPreviousVertex() {
			return previousVertex;
		}

		public void setPreviousVertex(Vertex previousVertex) {
			this.previousVertex = previousVertex;
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
	
	public static class BellmanFord {
		private List<Edge> edgeList;
		private List<Vertex> vertexList;
		
		public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
			this.edgeList = edgeList;
			this.vertexList = vertexList;
		}
		
		public void bellmanFord(Vertex sourceVertex) {
			sourceVertex.setDistance(0);
			
			for(int i = 0; i < vertexList.size()-1; ++i) {
				for(Edge edge: edgeList) {
					Vertex u = edge.getStartVertex();
					Vertex v = edge.getTargetVertex();
					
					if(u.getDistance() == Double.MAX_VALUE) continue;
					
					double newDistance = u.getDistance() + edge.getWeight();
					
					if(newDistance < v.getDistance()) {
						v.setDistance(newDistance);
						v.setPreviousVertex(u);
					}
				}
			}
			
			for(Edge edge: edgeList) {
				if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
					if(hasCycle(edge)) {
						System.out.println("Negative Cycle Detected.");
						return;
					}
				}
			}
		}

		private boolean hasCycle(Edge edge) {
			return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
		}
		
		public List<Vertex> shortestPathTo(Vertex targetVertex){		
			List<Vertex> shortestPathToTarget = new ArrayList<>();
			
			if(targetVertex.getDistance() == Double.MAX_VALUE) {
				System.out.println("No Path Detected.");
			}
			
			for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviousVertex()) {
				shortestPathToTarget.add(vertex);
			}
			
			Collections.reverse(shortestPathToTarget);
			
			return shortestPathToTarget;
		}
	}
	
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		vertexList.add(new Vertex("D"));
		vertexList.add(new Vertex("E"));
		
		List<Edge> edgeList = new ArrayList<>();
		
		edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(6, vertexList.get(0), vertexList.get(2)));
		edgeList.add(new Edge(-4, vertexList.get(1), vertexList.get(2)));
		edgeList.add(new Edge(3, vertexList.get(1), vertexList.get(3)));
		edgeList.add(new Edge(-8, vertexList.get(2), vertexList.get(4)));
		edgeList.add(new Edge(6, vertexList.get(3), vertexList.get(4)));
		
		BellmanFord bf = new BellmanFord(edgeList, vertexList);
		bf.bellmanFord(vertexList.get(0));
		System.out.println(bf.shortestPathTo(vertexList.get(4)));
		
	}
}
