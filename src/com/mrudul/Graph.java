package com.mrudul;

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
    List<Edge> edgeList = new ArrayList<>();
    int numberOfVertices, numberOfEdges;
    boolean directed;

    Graph(int numberOfVertices, int numberOfEdges, boolean directed)
    {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;
        this.directed = directed;
    }

    List<Edge> getAdjList(Vertex v) { return adjMap.get(v); }
    int getNumberOfVertices() {return numberOfVertices;}
    int getNumberOfEdges() {return numberOfEdges;}

    void addVertex(Vertex v) {
        adjMap.putIfAbsent(v, new ArrayList<>());
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
