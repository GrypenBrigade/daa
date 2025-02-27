package Graph;

import java.util.*;

public class Undirected {
    private Map<Integer, List<Integer>> adjList;

    public Undirected() {
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex) { // Method that adds vertices
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int from, int to) { // Method that adds edges to vertices
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from); // Since it's undirected
    }

    public void bfs(int start) { // Method that traverses the graph Breadth First
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Undirected graph = new Undirected();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.bfs(1); 
    }
}
