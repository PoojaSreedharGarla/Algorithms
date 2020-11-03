package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
	private ArrayList<Integer> adj[];
	private int V;
	
	BFS(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	} 
	
	public void bfs(int v) {
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<>();
		int polledEle = 0;
		
		queue.add(v);
		visited[v] = true;
		
		while(queue.size() != 0) {
			polledEle = queue.poll();
			System.out.print(polledEle + " ");
			
			for(int i = 0; i < adj[polledEle].size(); i++) {
				int each = adj[polledEle].get(i);
				if (!visited[each]) {
					queue.add(each);
					//System.out.println("added to q " + each);
					visited[each] = true;
				}
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
		
	public static void main(String[] args) {
		BFS graph = new BFS(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2); 
	    graph.addEdge(1, 2); 
	    graph.addEdge(2, 0); 
	    graph.addEdge(2, 3); 
	    graph.addEdge(3, 3); 
	    
	    //graph.printAdjList();
	    graph.bfs(2);
	}
		
	
}
