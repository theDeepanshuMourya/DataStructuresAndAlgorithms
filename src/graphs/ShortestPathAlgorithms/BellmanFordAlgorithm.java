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

package DataStructuresAndAlgorithms.src.graphs.ShortestPathAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
	// Data structure to store graph edges
	static class Edge {
		int source, dest, weight;

		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}

    static void printPath(int parent[], int vertex)
	{
		if (vertex < 0)
			return;

		printPath(parent, parent[vertex]);
		System.out.print(vertex + " ");
	}

	// Function to run Bellman Ford Algorithm from given source
	public static void bellmanFord(List<Edge> edges, int source, int N) {

		// distance[] and parent[] stores shortest-path
		// (least cost/path) information
		int distance[] = new int[N];
		int parent[] = new int[N];

		// initialize distance[] and parent[]. Initially all
		// vertices except source vertex have a weight of
		// infinity and a no parent
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		Arrays.fill(parent, -1);

		// Relaxation step (run V -1 times)
		for (int i = 0; i < N - 1; i++)
		{
			for (Edge edge: edges)
			{
				// edge from u to v having weight w
				int u = edge.source;
				int v = edge.dest;
				int w = edge.weight;

				// if the distance to the destination v can be
				// shortened by taking the edge u-> v
				if (distance[u] + w < distance[v]) {
					// update distance to the new lower value
					distance[v] = distance[u] + w;

					// set v's parent as u
					parent[v] = u;
				}
			}
		}

		// run relaxation step once more for Nth time to
		// check for negative-weight cycles
		for (Edge edge: edges)
		{
			// edge from u to v having weight w
			int u = edge.source;
			int v = edge.dest;
			int w = edge.weight;

			// if the distance to the destination u can be
			// shortened by taking the edge u-> v
			if (distance[u] + w < distance[v]) {
				System.out.println("Negative Weight Cycle Found!!");
				return;
			}
		}

		for (int i = 0; i < N; i++)
		{
			System.out.print("Path (" + source + " -> " + i + ") : Minimum Cost = "+ distance[i] + " and Route is [");
			printPath(parent, i);
			System.out.println("]");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter no. of Vertices: ");
        int verticeNo = Integer.parseInt(br.readLine());

        System.out.println("Enter no. of Edges: ");
        int edgeNo = Integer.parseInt(br.readLine());

        // initialize edges as per (u, v, w) space seperated
		// triplet representing undirected edge from
		// vertex u to vertex v having weight w
        System.out.println("Enter the edges as follows.");
        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < edgeNo; i++){
            System.out.println("Enter edge " + i + " :");
			
			String e[] = br.readLine().split(" ");
			int u = Integer.parseInt(e[0]);
			int v = Integer.parseInt(e[1]);
			int w = Integer.parseInt(e[2]);

            edges.add(new Edge(u, v, w));
        }

		// let source be vertex 0
		int source = 0;

		// run Bellman Ford Algorithm from given source
		bellmanFord(edges, source, verticeNo);
	}
}
