/*
 * Kosaraju's algorithm is a linear time algorithm to find 
 * the strongly connected components of a directed graph. 
 * It makes use of the fact that the transpose graph 
 * (the same graph with the direction of every edge reversed) 
 * has exactly the same strongly connected components as 
 * the original graph.
 * 
 * Time Complexity: The algorithm calls DFS, finds reverse 
 * of the graph and again calls DFS. DFS takes O(V+E) for 
 * a graph represented using adjacency list. Reversing a 
 * graph also takes O(V+E) time.
*/

package DataStructuresAndAlgorithms.src.graphs.StronglyConnectedComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {
	public static class Vertex {
		private int id;
		private String name;
		private boolean visited;
		private List<Vertex> adjacenciesList;
		private int componentId;
		
		public Vertex(int id, String name) {
			this.id = id;
			this.name = name;
			this.adjacenciesList = new ArrayList<>();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public List<Vertex> getAdjacenciesList() {
			return adjacenciesList;
		}

		public void setAdjacenciesList(List<Vertex> adjacenciesList) {
			this.adjacenciesList = adjacenciesList;
		}

		public int getComponentId() {
			return componentId;
		}

		public void setComponentId(int componentId) {
			this.componentId = componentId;
		}
		
		public void addNeighbour(Vertex vertex) {
			this.adjacenciesList.add(vertex);
		}
		
		@Override
		public String toString() {
			return this.name;	
		}
	}
	
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
	
	public static class Graph {
		private List<Vertex> vertexList;
		private List<Edge> edgeList;
		
		public Graph() {
		}
		
		public Graph(List<Vertex> vertexList, List<Edge> edgeList) {
			this.edgeList = edgeList;
			this.vertexList = vertexList;
		}

		public List<Vertex> getVertexList() {
			return vertexList;
		}

		public void setVertexList(List<Vertex> vertexList) {
			this.vertexList = vertexList;
		}

		public List<Edge> getEdgeList() {
			return edgeList;
		}

		public void setEdgeList(List<Edge> edgeList) {
			this.edgeList = edgeList;
		}
		
		public Graph getTransposedGraph() {
			Graph transposed = new Graph();
			List<Vertex> transposedVertexList = new ArrayList<>();
			
			for(Vertex vertex: this.vertexList) {
				transposedVertexList.add(vertex);
			}
			
			for(Edge edge: this.edgeList) {
				transposedVertexList.get(transposedVertexList.indexOf(edge.getTargetVertex())).addNeighbour(edge.getStartVertex());
			}
			
			transposed.setVertexList(transposedVertexList);
			return transposed;
		}
	}

	public static class DepthFirstOrder {
		private Stack<Vertex> stack;
		
		public DepthFirstOrder(Graph graph) {
			stack = new Stack<>();
			
			for (Vertex vertex : graph.getVertexList()) {
				if(!vertex.isVisited()) {
					dfs(vertex);
				}
			}
		}

		private void dfs(Vertex vertex) {
			vertex.setVisited(true);
			
			for(Vertex v: vertex.getAdjacenciesList()) {
				if(!v.isVisited()) {
					dfs(v);
				}
			}
			
			stack.push(vertex);
		}
		
		public Stack<Vertex> getReversePost(){
			return this.stack;
		}
	}
	
	public static class algorithm {
		private int[] id;
		private int count;
		private boolean[] marked;
		
		public algorithm(Graph graph) {
			DepthFirstOrder dfs = new DepthFirstOrder(graph.getTransposedGraph());
			marked = new boolean[graph.getVertexList().size()];
			id = new int[graph.getVertexList().size()];
			
			for(Vertex vertex: dfs.getReversePost()) {
				if(!marked[vertex.getId()]) {
					dfs(vertex);
					count++; 
				}
			}
		}

		private void dfs(Vertex vertex) {
			marked[vertex.getId()] = true;
			id[vertex.getId()] = count;
			vertex.setComponentId(count);
			
			for(Vertex v: vertex.getAdjacenciesList()) {
				if(!marked[v.getId()]) {
					dfs(v);
				}
			}
		}
		
		public int getCount() {
			return this.count;
		}
	}
	
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();

		vertexList.add(new Vertex(0, "a"));
		vertexList.add(new Vertex(1, "b"));
		vertexList.add(new Vertex(2, "c"));
		vertexList.add(new Vertex(3, "d"));
		vertexList.add(new Vertex(4, "e"));
		vertexList.add(new Vertex(5, "f"));
		vertexList.add(new Vertex(6, "g"));
		vertexList.add(new Vertex(7, "h"));		
		
		List<Edge> edgeList = new ArrayList<Edge>();
		
		edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));		
		edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));
		edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(4)));
		edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(5)));		
		edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(3)));
		edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(6)));		
		edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(2)));
		edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(7)));		
		edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(0)));
		edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(5)));		
		edgeList.add(new Edge(1, vertexList.get(5), vertexList.get(6)));		
		edgeList.add(new Edge(1, vertexList.get(6), vertexList.get(5)));		
		edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(3)));
		edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(6)));		
		
		Graph graph = new Graph(vertexList,edgeList);		
		algorithm kosarajuAlgorithm = new algorithm(graph);
		
		System.out.println(kosarajuAlgorithm.getCount());
		
		for(Vertex vertex : vertexList){
			System.out.println(vertex+" - "+vertex.getComponentId());
		}
	}
}
