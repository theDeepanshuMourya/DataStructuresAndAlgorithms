/*
 * The DFS algorithm is a recursive algorithm that 
 * uses the idea of backtracking. It involves exhaustive 
 * searches of all the nodes by going ahead, if possible, 
 * else by backtracking.
 * 
 * Here, the word backtrack means that when you are moving 
 * forward and there are no more nodes along the current 
 * path, you move backwards on the same path to find nodes 
 * to traverse. All the nodes will be visited on the 
 * current path till all the unvisited nodes have been 
 * traversed after which the next path will be selected.
 * 
 * The algorithm has a running time complexity of O(V+E).
 */

package graphs.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	public static class Vertex {
		private String name;
		private boolean visited;
		private List<Vertex> neighbourList;

		public Vertex(String name) {
			this.name = name;
			this.neighbourList = new ArrayList<>();
		}

		public void addNeightbour(Vertex vertex) {
			this.neighbourList.add(vertex);
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

		public List<Vertex> getNeighbourList() {
			return neighbourList;
		}

		public void setNeighbourList(List<Vertex> neighbourList) {
			this.neighbourList = neighbourList;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static class dfs {
		private static Stack<Vertex> stack;

		public dfs() {
			stack = new Stack<Vertex>();
		}
		
		public static void searchRecursively(List<Vertex> vertexList) {
			for (Vertex vertex : vertexList) {
				if (!vertex.isVisited()) {
					vertex.setVisited(true);
					searchWithRecursion(vertex);
				}
			}
		}

		private static void searchWithRecursion(Vertex vertex) {
			System.out.print(vertex + " ");
			
			for(Vertex v: vertex.getNeighbourList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					searchWithRecursion(v);
				}
			}
		}

		public static void search_stack(List<Vertex> vertexList) {
			for (Vertex vertex : vertexList) {
				if (!vertex.isVisited()) {
					vertex.setVisited(true);
					searchWithStack(vertex);
				}
			}
		}

		private static void searchWithStack(Vertex rootVertex) {
			stack.push(rootVertex);
			rootVertex.setVisited(true);

			while (!stack.isEmpty()) {
				Vertex actualVertex = stack.pop();
				System.out.print(actualVertex + " ");

				for (Vertex v : actualVertex.getNeighbourList()) {
					if (!v.isVisited()) {
						v.setVisited(true);
						stack.push(v);
					}
				}
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		Vertex v8 = new Vertex("8");
		
		List<Vertex> list = new ArrayList<>();
		
		v1.addNeightbour(v2);
		v1.addNeightbour(v3);
		v2.addNeightbour(v4);
		v2.addNeightbour(v5);
		v3.addNeightbour(v6);
		v6.addNeightbour(v8);
		v5.addNeightbour(v7);
		
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		list.add(v7);
		list.add(v8);
		
		System.out.println("Searching using Stack -> ");
		dfs.search_stack(list);
		
		System.out.println();

		System.out.println("Searching using Recursion -> ");
		dfs.searchRecursively(list);
	}
}
