package ds.graph.adjacency_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class DirectedGraph<V> {

    // key -> data of vertex/node
    // value -> edges of the vertex/node
    private Map<V, Set<V>> vertices;

    // default constructor
    public DirectedGraph() {
        this.vertices = new HashMap<>();
    }

    // add vertex/node with an edge
    public void addEdge(V vertex, V edge) {
        Set<V> edges = new HashSet<>();
        edges.add(edge);
        this.addEdges(vertex, edges);
    }

    // add vertex/node with set of edges
    public void addEdges(V vertex, Set<V> edges) {
        if (vertex == null) throw new NullPointerException("Vertex cannot be null");
        if (edges == null) edges = new HashSet<>();

        Set<V> filter = edges.stream().filter(e -> {
            boolean b = vertices.containsKey(e);
            if (b) return true;
            else throw new NullPointerException("The edge " + e + " that is being added is not exist");
        }).collect(Collectors.toSet());

        if (this.vertices.containsKey(vertex)) this.vertices.get(vertex).addAll(filter);
        else this.vertices.put(vertex, filter);
    }

    // get edges of the vertex/node
    public Set<V> getEdges(V vertex) {
        boolean exist = this.vertices.containsKey(vertex);
        if (!exist) throw new NullPointerException("There is no vertex regarding to given input");
        return this.vertices.get(vertex);
    }

    // remove the given a vertex/node
    public boolean deleteVertex(V vertex) {
        boolean exist = this.vertices.containsKey(vertex);
        if (exist) {
            this.vertices.remove(vertex);
            for (Map.Entry<V, Set<V>> map : vertices.entrySet()) {
                map.getValue().remove(vertex);
            }
            return true;
        } else return false;
    }

    // remove an edge of given a vertex/node
    public boolean deleteEdgeOfVertex(V vertex, V edge) {
        boolean exist = this.vertices.containsKey(vertex);
        if (exist) {
            return this.vertices.get(vertex).remove(edge);
        } else return false;
    }

    // remove all edges of the vertex/node
    public boolean deleteAllEdges(V vertex) {
        boolean exist = this.vertices.containsKey(vertex);
        if (exist) {
            this.vertices.put(vertex, new HashSet<>());
            return true;
        } else return false;
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
