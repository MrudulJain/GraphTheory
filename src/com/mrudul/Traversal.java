package com.mrudul;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Traversal {
    public static void main(String[] args) {
        Graph graph = createGraph();
        System.out.println("Created graph is: ");
        graph.printGraph();

    }

    public static Graph createGraph()
    {
        int numberOfVertices, numberOfEdges;
        boolean directed = false, weighted = false;
        HashMap<String, Vertex> vertexInfo = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of Vertices in the graph: ");
        numberOfVertices = scanner.nextInt();
        System.out.println("Enter number of Edges in the graph: ");
        numberOfEdges = scanner.nextInt();
        while (true) {
            try {
                System.out.println("Is graph directed? Enter true or false");
                directed = scanner.nextBoolean();
                break;
            } catch (InputMismatchException err) {
                System.err.println("Please try again. Error: " +err.getMessage());
                continue;
            }
        }

        while (true) {
            try {
                System.out.println("Is graph weighted? Enter true or false");
                weighted = scanner.nextBoolean();
                break;
            }
            catch (InputMismatchException err) {
                System.err.println("Please try again. Error: " +err.getMessage());
                continue;
            }
        }

        Graph graph = new Graph(numberOfVertices, numberOfEdges, directed);
        System.out.println("Enter the vertices: ");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.println("Name of Vertex " +(i+1)+ ": ");
            Vertex v = new Vertex(scanner.next());
            vertexInfo.put(v.name, v);
            graph.addVertex(v);
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
                graph.addEdge(vertexInfo.get(src), vertexInfo.get(dest), weight);
            }
            else
            {
                graph.addEdge(vertexInfo.get(src), vertexInfo.get(dest), 0);
            }
        }

        return graph;
    }
}
