package ds.graph;

import java.util.Set;

public class Vertex<E> {
    private E data;
    Set<Edge> edges;

    public Vertex(E data) {
        this.data = data;
    }

    public void addEdges(Vertex to) {
        Edge newEdge = new Edge(this, to);
    }
}