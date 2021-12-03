import java.util.*;

public class Traversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph graph = new Graph();
        System.out.println("Created graph is: ");
        graph.printGraph();

        // BFS AND DFS
        System.out.println("Enter Starting vertex for BFS and DFS");
        String startVertex = input.next();
        Set<String> visited = new HashSet<>();
        System.out.println("DFS Of Created Graph:");
        /* for (Vertex v: graph.vertexList)
        {
            if(!visited.contains(v.name))
                dfs(graph, v, visited);
        } */
    }


    void dfs (Graph graph, Vertex startVertex, Set<String> visited)
    {

    }

    /* void bfs(Boolean[] visited, int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty())
        {
            System.out.print(queue.peek() + "-->");
            int temp = queue.remove();
            for (Integer child : adjList.get(temp))
                if(!visited[child])
                {
                    queue.add(child);
                    visited[child] = true;
                }
        }
        System.out.print("null");
    } */
}