/*
 * Dijkstra's algorithm is the fastest known algorithm 
 * for finding all shortest paths from one node to all 
 * other nodes of a graph, which does not contain edges 
 * of a negative length.
 * 
 * Time Complexity of Dijkstra's Algorithm is O(V^2) 
 * but with min-priority queue it drops down to O(V + ElogV).
*/

package graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
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
	
	public static class Vertex implements Comparable<Vertex> {
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

		@Override
		public int compareTo(Vertex otherVertex) {
			return Double.compare(distance, otherVertex.getDistance());
		}
	}
	
	public static class algorithm {
		public void computePaths(Vertex sourceVertex) {
			sourceVertex.setDistance(0);
			PriorityQueue<Vertex> queue = new PriorityQueue<>();
			queue.add(sourceVertex);
			
			while (!queue.isEmpty()) {
				Vertex actualVertex = queue.poll();
				
				for (Edge edge : actualVertex.getAdjacenciesList()) {
					Vertex v = edge.getTargetVertex();
					double newDistance = actualVertex.getDistance() + edge.getWeight();
					
					if(newDistance < v.getDistance()) {
						queue.remove(v);
						v.setDistance(newDistance);
						v.setPredecessor(actualVertex);
						queue.add(v);
					}
				}
			}
		}
		
		public List<Vertex> getShortestPathTo(Vertex targetVertex){
			List<Vertex> shortestPathToTarget = new ArrayList<>();
			
			for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
				shortestPathToTarget.add(vertex);
			}
			System.out.println("Shortest Distance: "+targetVertex.getDistance());
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
		
		v1.addNeighbour(new Edge(1, v1, v2));
		v1.addNeighbour(new Edge(6, v1, v3));
		v2.addNeighbour(new Edge(4, v2, v3));
		v2.addNeighbour(new Edge(3, v2, v4));
		v3.addNeighbour(new Edge(8, v3, v5));
		v4.addNeighbour(new Edge(6, v4, v5));
		
		algorithm algo = new algorithm();
		algo.computePaths(v1);
		
		System.out.println(algo.getShortestPathTo(v5));
	}
}
