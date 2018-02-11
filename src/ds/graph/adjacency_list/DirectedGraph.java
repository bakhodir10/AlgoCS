package ds.graph.adjacency_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph<E> {

    // key -> data of vertex/node
    // value -> edges of the vertex/node
    private Map<E, Set<E>> vertices;

    // default constructor
    public DirectedGraph() {
        this.vertices = new HashMap<>();
    }

    // add a new edge to the vertex/node
    public void addEdge(E vertex, Set<E> edges) {
        if (this.vertices.containsKey(vertex)) this.vertices.get(vertex).addAll(edges);
        else this.vertices.put(vertex, edges);
    }

    // get edges of the vertex/node
    public Set<E> getEdges(E elem) {
        return this.vertices.get(elem);
    }

    // remove the given a vertex/node
    public void deleteVertex(E elem) {
        this.vertices.remove(elem);
    }

    // remove all edges of the vertex/node
    public void deleteAllEdges(E elem) {
        if (this.vertices.containsKey(elem)) this.vertices.put(elem, new HashSet<>());
    }

    // print all vertices with its edges
    public void print() {
        this.vertices.forEach((key, value) ->
                System.out.println("vertex -> " + key + ", " + "edges -> " + value));
    }
}