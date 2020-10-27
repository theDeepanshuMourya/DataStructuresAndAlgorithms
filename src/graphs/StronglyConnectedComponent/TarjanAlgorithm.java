/*
 * Tarjan's algorithm is based on depth first search (DFS). 
 * The vertices are indexed as they are traversed by DFS procedure. 
 * While returning from the recursion of DFS, every vertex V gets 
 * assigned a vertex L as a representative. L is a vertex with the 
 * least index that can be reach from V. Nodes with the same 
 * representative assigned are located in the same strongly 
 * connected component.
 * 
 * Tarjan's algorithm is only a modified depth first search, 
 * hence it has an asymptotic complexity O(|V| + |E|).
 */

package DataStructuresAndAlgorithms.src.graphs.StronglyConnectedComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {
	public static class Vertex {
		private String name;
		private List<Vertex> neighbourList;
		private Vertex predecessor;
		private boolean visited;
		private int lowLink;
		
		public Vertex(String name) {
			this.name = name;
			this.neighbourList = new ArrayList<>();
		}
		
		public void addNeighbour(Vertex vertex) {
			this.neighbourList.add(vertex);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Vertex> getNeighbourList() {
			return neighbourList;
		}

		public void setNeighbourList(List<Vertex> neighbourList) {
			this.neighbourList = neighbourList;
		}

		public Vertex getPredecessor() {
			return predecessor;
		}

		public void setPredecessor(Vertex predecessor) {
			this.predecessor = predecessor;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public int getLowLink() {
			return lowLink;
		}

		public void setLowLink(int lowLink) {
			this.lowLink = lowLink;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static class algorithm {
		private Stack<Vertex> stack;
		private List<Vertex> vertexList;
		private List<List<Vertex>> connectedComponentList;
		private int time=0;
		private int count;
		
		public algorithm(List<Vertex> vertexList) {
			this.vertexList = vertexList;
			this.stack = new Stack<>();
			this.connectedComponentList = new ArrayList<>();
		}
		
		public void runAlgorithm() {
			for(Vertex vertex: vertexList) {
				if(!vertex.isVisited()) {
					dfs(vertex);
				}
			}
		}

		private void dfs(Vertex vertex) {
			vertex.setLowLink(time++);
			System.out.println("Visiting vertex: " + vertex + " with lowlink " + vertex.getLowLink());
			
			vertex.setVisited(true);
			this.stack.add(vertex);
			boolean isComponentRoot = true;
			
			for(Vertex v: vertex.getNeighbourList()) {
				if(!v.isVisited()) {
					System.out.println("Recursively visit vertex: " + v);
					dfs(v);
				}
				
				if(vertex.getLowLink() > v.getLowLink()) {
					System.out.println("Because vertex "+vertex+" lowLink (value:"+vertex.getLowLink()+") > vertex " +v +" lowLink (value:"+v.getLowLink()+") --> we set vertex "+vertex+" lowLink = vertex "+v+" lowLink value which is "+v.getLowLink());
					vertex.setLowLink(v.getLowLink());
					System.out.println("So vertex " + vertex + " is not the root of SCC");
					isComponentRoot = false;
				}
			}
			
			if(isComponentRoot) {
				count++;
				System.out.println("Vertex " + vertex + " is the root of SCC");
				List<Vertex> component = new ArrayList<>();
				
				while(true) {
					Vertex actualVertex = stack.pop();
					System.out.println("So vertex " + actualVertex + " is in SCC " + count);
					component.add(actualVertex);
					actualVertex.setLowLink(Integer.MAX_VALUE);
					
					if(actualVertex.getName().equals(vertex.getName())) break;
				}
				
				connectedComponentList.add(component);
			}
		}
		
		public void printComponents() {
			System.out.println(connectedComponentList);
		}
	}
	
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		
		v1.addNeighbour(v5);
		v2.addNeighbour(v1);
		v3.addNeighbour(v2);
		v3.addNeighbour(v4);
		v4.addNeighbour(v3);
		v5.addNeighbour(v2);
		v6.addNeighbour(v2);
		v6.addNeighbour(v5);
		v6.addNeighbour(v7);
		v7.addNeighbour(v6);
		v7.addNeighbour(v3);
		
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v6);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v3);
		vertexList.add(v7);
		
		algorithm tarjanAlgorithm = new algorithm(vertexList);
		tarjanAlgorithm.runAlgorithm();
		tarjanAlgorithm.printComponents();
	}
}
