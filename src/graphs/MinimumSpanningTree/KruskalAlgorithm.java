/*
 * Kruskal's minimum spanning tree. Only works on undirected graphs. It finds a
 * subset of the edges that forms a tree that includes every vertex, where the
 * total weight of all the edges in the tree is minimized.
 * 
 * Time Complexity: O(ElogE) or O(ElogV). Sorting of edges takes O(ELogE) time. 
 * After sorting, we iterate through all edges and apply find-union algorithm. 
 * The find and union operations can take atmost O(LogV) time. So overall 
 * complexity is O(ELogE + ELogV) time. The value of E can be atmost O(V^2), 
 * so O(LogV) are O(LogE) same. Therefore, overall time complexity is 
 * O(ElogE) or O(ElogV)
 */

package graphs.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
	public static class Vertex {
		private String name;
		private Node node;
		
		public Vertex(String name) {
			this.name = name;
		}

		public Node getNode() {
			return node;
		}

		public void setNode(Node node) {
			this.node = node;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}

	
	public static class Edge implements Comparable<Edge>{
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

		@Override
		public int compareTo(Edge edge) {
			return Double.compare(this.weight, edge.getWeight());
		}
	}
	
	public static class Node {
		private int id;
		private int rank;
		private Node parent;
		
		public Node(int id,int rank, Node parent) {
			this.rank = rank;
			this.id = id;
			this.parent = parent;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
	}

	
	public static class DisjointSet {
		private int nodeCount = 0;
		private int setCount = 0;
		private List<Node> rootNodes;	// representatives
		
		public DisjointSet(List<Vertex> vertexList) {
			this.rootNodes = new ArrayList<>(vertexList.size());
			makeSets(vertexList);
		}
		
		public int find(Node n) {
			Node currentNode = n;
			
			while(currentNode.getParent() != null) {
				currentNode = currentNode.getParent();
			}
			
			Node rootNode = currentNode;
			currentNode = n;
			
			while(currentNode != rootNode) {
				Node temp = currentNode.getParent();
				currentNode.setParent(rootNode);
				currentNode = temp;
			}
			
			return rootNode.getId();
		}
		
		public void union(Node n1, Node n2) {
			int index1 = find(n1);
			int index2 = find(n2);
			
			if(index1 == index2) {
				return;
			}
			
			Node root1 = this.rootNodes.get(index1);
			Node root2 = this.rootNodes.get(index2);
			
			if(root1.getRank() < root2.getRank()) {
				root1.setParent(root2);
			} else if(root2.getRank() < root1.getRank()) {
				root2.setParent(root1);
			} else {
				root2.setParent(root1);
				root1.setRank(root1.getRank() + 1);
			}
			
			setCount--;
		}

		private void makeSets(List<Vertex> vertexList) {
			for (Vertex vertex : vertexList) {
				makeSet(vertex);
			}		
		}

		private void makeSet(Vertex vertex) {
			Node n = new Node(rootNodes.size(), 0, null);
			vertex.setNode(n);
			rootNodes.add(n);
			setCount++;
			nodeCount++;
		}	
	}
	
	public static class algorithm {
		public void spanningTree(List<Vertex> vertexList, List<Edge> edgeList) {
			DisjointSet ds = new DisjointSet(vertexList);
			List<Edge> mst = new ArrayList<>();
			
			Collections.sort(edgeList);
			
			for(Edge edge: edgeList) {
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();
				
				if(ds.find(u.getNode()) != ds.find(v.getNode())) {
					mst.add(edge);
					ds.union(u.getNode(), v.getNode());
				}
			}
			
			System.out.println("Minimum Spanning Tree Found ->");
			
			for(int i = 0; i < mst.size(); i++) {			
				if(i == mst.size()-1) {
					System.out.print(mst.get(i).getStartVertex() + "" + mst.get(i).getTargetVertex());
				} else {
					System.out.print(mst.get(i).getStartVertex() + "" + mst.get(i).getTargetVertex() + "--");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		vertexList.add(new Vertex("D"));
		vertexList.add(new Vertex("E"));
		vertexList.add(new Vertex("F"));
		vertexList.add(new Vertex("G"));
		vertexList.add(new Vertex("H"));
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(3, vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(2, vertexList.get(0), vertexList.get(2)));
		edgeList.add(new Edge(5, vertexList.get(0), vertexList.get(3)));
		edgeList.add(new Edge(13, vertexList.get(1), vertexList.get(5)));
		edgeList.add(new Edge(2, vertexList.get(1), vertexList.get(3)));
		edgeList.add(new Edge(5, vertexList.get(2), vertexList.get(4)));
		edgeList.add(new Edge(2, vertexList.get(2), vertexList.get(3)));
		edgeList.add(new Edge(4, vertexList.get(3), vertexList.get(4)));
		edgeList.add(new Edge(6, vertexList.get(3), vertexList.get(5)));
		edgeList.add(new Edge(3, vertexList.get(3), vertexList.get(6)));
		edgeList.add(new Edge(6, vertexList.get(4), vertexList.get(6)));
		edgeList.add(new Edge(2, vertexList.get(5), vertexList.get(6)));
		edgeList.add(new Edge(3, vertexList.get(5), vertexList.get(7)));
		edgeList.add(new Edge(6, vertexList.get(6), vertexList.get(7)));
		
		algorithm kruskalAlgorithm = new algorithm();
		kruskalAlgorithm.spanningTree(vertexList, edgeList);
	}
}
