import java.util.*;

class Vertex {
    String name;
    Vertex (String nameOfVertex) // Constructor
    {
        this.name = nameOfVertex;
    }
}

class Edge {
    Vertex src, dest;
    int weight;

    Edge (Vertex src, Vertex dest, int weight) // Constructor
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class Graph {
    Map<Vertex, List<Edge>> adjMap = new HashMap<>();
    List<Vertex> vertexList = new ArrayList<>();
    List<Edge> edgeList = new ArrayList<>();
    int numberOfVertices, numberOfEdges;
    boolean directed;

    Graph()
    {
        boolean weighted = false;
        HashMap<String, Vertex> vertexInfo = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of Vertices in the graph: ");
        this.numberOfVertices = scanner.nextInt();
        System.out.println("Enter number of Edges in the graph: ");
        this.numberOfEdges = scanner.nextInt();
        while (true) {
            try {
                System.out.println("Is graph directed? Enter true or false");
                this.directed = scanner.nextBoolean();
                break;
            } catch (InputMismatchException err) {
                System.err.println("Please try again. Error: " +err.getMessage());
                continue;
            }
        }

        while (true)
        {
            try {
                System.out.println("Is graph weighted? Enter true or false");
                weighted = scanner.nextBoolean();
                break;
            }
            catch (InputMismatchException e) {
                System.err.println("Please try again. Error: " +e.getMessage());
                continue;
            }
        }

        System.out.println("Enter the vertices: ");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.println("Name of Vertex " +(i+1)+ ": ");
            Vertex v = new Vertex(scanner.next());
            vertexInfo.put(v.name, v);
            addVertex(v);
        }

        System.out.println("Enter edge details: ");
        for (int i = 0; i < numberOfEdges; i++)
        {
            System.out.println("Enter Source Vertex: ");
            String src = scanner.next();
            System.out.println("Enter Destination Vertex: ");
            String dest = scanner.next();
            if(weighted == true)
            {
                System.out.println("Enter weight of the edge: ");
                int weight = scanner.nextInt();
                addEdge(vertexInfo.get(src), vertexInfo.get(dest), weight);
            }
            else
            {
                addEdge(vertexInfo.get(src), vertexInfo.get(dest), 0);
            }
        }
    }

    void addVertex(Vertex v) {
        adjMap.putIfAbsent(v, new ArrayList<>());
        if(!vertexList.contains(v))
            vertexList.add(v);
    }

    void addEdge(Vertex src, Vertex dest, int weight) {
        if(directed == true)
            adjMap.get(src).add(new Edge(src, dest, weight));
        else //undirected (bi-directional)
        {
            adjMap.get(src).add(new Edge(src, dest, weight));
            adjMap.get(dest).add(new Edge(dest, src, weight));
        }
    }

    void printGraph()
    {
        for (Vertex v : adjMap.keySet())
        {
            List<Edge> neighbours = adjMap.get(v);
            for (Edge e : neighbours)
            {
                System.out.println(v.name +" ----> " +e.dest.name);
            }
        }
    }
}
