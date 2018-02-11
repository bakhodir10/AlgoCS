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

    // add vertex/node with set of edges
    public void addEdge(V vertex, Set<V> edges) {
        if (vertex == null) throw new NullPointerException("Vertex cannot be null");
        if (this.vertices.containsKey(vertex)) this.vertices.get(vertex).addAll(edges);
        else this.vertices.put(vertex, edges);
    }

    // get edges of the vertex/node
    public Set<V> getEdges(V vertex) {
        boolean exist = this.vertices.containsKey(vertex);
        if (!exist) throw new NullPointerException("There is no vertex regarding to given input");
        return this.vertices.get(vertex);
    }

    // remove the given a vertex/node
    public boolean deleteVertex(V vertex) {
        Set<V> set = this.vertices.get(vertex);
        if (set == null) throw new NullPointerException("There is no vertex regarding to given input");
        return this.vertices.remove(vertex) != null;
    }

    // remove all edges of the vertex/node
    public boolean deleteAllEdges(V vertex) {
        if (this.vertices.containsKey(vertex)) {
            this.vertices.put(vertex, new HashSet<>());
            return true;
        } else throw new NullPointerException("There is no vertex regarding to given input");
    }

    // remove all vertices/nodes
    public boolean deleteAllVertices() {
        this.vertices = new HashMap<>();
        return true;
    }

    // print all vertices with its edges
    public void print() {
        this.vertices.forEach((key, value) ->
                System.out.println("vertex -> " + key + ", " + "edges -> " + value));
    }
}
