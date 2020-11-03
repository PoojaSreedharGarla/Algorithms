package Graph;

import java.util.ArrayList;

public class DFS {
	
	//Array of lists representing Adjacency List
	private ArrayList<Integer> adj[];
	private int V;
	
	DFS(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void dfs_utils(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		
		for (int i = 0; i < adj[v].size(); i++) {
			int each = adj[v].get(i);
			if (!visited[each])
				dfs_utils(each, visited);
		}
	}
	
	public void dfs() {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				dfs_utils(i, visited);
			}
				
		}
	}
	
	public void printAdjList() {
		for (int i = 0; i < 4; i ++) {
        	for (int j = 0; j < adj[i].size(); j++) {
        		System.out.print(adj[i].get(j) + " ");
        	}
        	System.out.println(" ");
        }
	}
	
	public static void main(String args[]) {
		DFS graph = new DFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
        
        //graph.printAdjList();
        graph.dfs();
	}
	
	
}

/*
 * Time: O(V+E)
 * Spcae: O(V)
 */
