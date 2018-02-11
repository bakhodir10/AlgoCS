package ds.graph.adjacency_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph<V> {

    // key -> data of vertex/node
    // value -> edges of the vertex/node
    private Map<V, Set<V>> vertices;

    // default constructor
    public DirectedGraph() {
        this.vertices = new HashMap<>();
    }

    // add a new edge to the vertex/node
    public void addEdge(V vertex, Set<V> edges) {
        if (this.vertices.containsKey(vertex)) this.vertices.get(vertex).addAll(edges);
        else this.vertices.put(vertex, edges);
    }

    // get edges of the vertex/node
    public Set<V> getEdges(V elem) {
        return this.vertices.get(elem);
    }

    // remove the given a vertex/node
    public void deleteVertex(V elem) {
        this.vertices.remove(elem);
    }

    // remove all edges of the vertex/node
    public void deleteAllEdges(V elem) {
        if (this.vertices.containsKey(elem)) this.vertices.put(elem, new HashSet<>());
    }

    // remove all vertices/nodes
    public void deleteAllVertices() {
        this.vertices = new HashMap<>();
    }

    // print all vertices with its edges
    public void print() {
        this.vertices.forEach((key, value) ->
                System.out.println("vertex -> " + key + ", " + "edges -> " + value));
    }
}
