package Graph;

import java.util.*;

public class TopologicalSort {
	
	//number of vertices
	private int V;
	private List<List<Integer>> adjList;
	
	TopologicalSort(int v) {
		V = v;
		adjList = new ArrayList<>(v);
		for (int i = 0; i < v; i ++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
	}
	
	public void topoSort(TopologicalSort graph) {
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < V; i ++) {
			if (visited.contains(i))
				continue;
			topoSortUtil(i, visited, stack);
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	private void topoSortUtil(int v, Set<Integer> visited, Deque<Integer> stack) {
		visited.add(v);
		Iterator<Integer> it = adjList.get(v).iterator();
		while (it.hasNext()) {
			Integer next = it.next();
			if (!visited.contains(next))
				topoSortUtil(next, visited, stack);
		}
		stack.push(v);
	}
	
	public static void main (String args[]) {
		TopologicalSort graph = new TopologicalSort(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		
		graph.topoSort(graph);
	}
}

/*Time: O(V + E)
 * Space: O(V)
 */
