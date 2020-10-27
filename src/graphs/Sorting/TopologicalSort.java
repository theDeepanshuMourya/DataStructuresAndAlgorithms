/*
 * In computer science, a topological sort (sometimes abbreviated topsort or
 * toposort) or topological ordering of a directed graph is a linear ordering of
 * its vertices such that, for every edge uv, u comes before v in the ordering.
 */

package DataStructuresAndAlgorithms.src.graphs.Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	public static class Vertex {
		private String data;
		private boolean visited;
		private List<Vertex> neighbourList;
		
		public Vertex(String data) {
			this.data = data;
			this.neighbourList = new ArrayList<>();
		}
		
		public void addNeighbour(Vertex vertex) {
			this.neighbourList.add(vertex);
		}
		
		public String getData() {
			return data;
		}

		public void setData(String data) {
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

		@Override
		public String toString() {
			return this.data;
		}
	}
	
	public static class TopologicalOrdering {
		private Stack<Vertex> stack;

		public TopologicalOrdering() {
			this.stack = new Stack<>();
		}

		public void search(Vertex vertex) {
			vertex.setVisited(true);

			for (Vertex v : vertex.getNeighbourList()) {
				if (!v.isVisited()) {
					search(v);
				}
			}

			stack.push(vertex);
		}

		public Stack<Vertex> getStack() {
			return this.stack;
		}
	}
	
	public static void main(String[] args) {
		TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
		
		List<Vertex> graph = new ArrayList<>();
		
		graph.add(new Vertex("1"));
		graph.add(new Vertex("2"));
		graph.add(new Vertex("3"));
		graph.add(new Vertex("4"));
		graph.add(new Vertex("5"));
		graph.add(new Vertex("6"));
		
		graph.get(2).addNeighbour(graph.get(4));
		graph.get(2).addNeighbour(graph.get(3));
		graph.get(4).addNeighbour(graph.get(5));
		graph.get(3).addNeighbour(graph.get(4));
		graph.get(0).addNeighbour(graph.get(1));
		graph.get(1).addNeighbour(graph.get(2));
		graph.get(5).addNeighbour(graph.get(2));
		
		for (int i = 0; i < graph.size(); ++i) {
			if (!graph.get(i).isVisited()) {
				topologicalOrdering.search(graph.get(i));
			}
		}
		
		Stack<Vertex> stack = topologicalOrdering.getStack();
		
		for(int i = 0; i < graph.size(); ++i) {
			Vertex vertex = stack.pop();
			if(i == graph.size()-1) {
				System.out.print(vertex);
			} else {
				System.out.print(vertex + " -> ");
			}
		}
	}
}
