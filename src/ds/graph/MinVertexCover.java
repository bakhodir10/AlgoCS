package ds.graph;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class MinVertexCover<V> {

    // key -> data of vertex/node
    // value -> edges of the vertex/node
    private Map<V, Set<V>> vertices;
    private Set<V> visited;

    // default constructor
    public MinVertexCover() {
        this.vertices = new HashMap<>();
        this.visited = new HashSet<>();
    }

    public int minVertexCover() {
        Queue<V> queue = new ArrayDeque<>();
        int ans = 0;
        Map.Entry<V, Set<V>> entry = this.vertices.entrySet().iterator().next();
        V first = entry.getKey();
        queue.offer(first);

        while (!queue.isEmpty()) {
            V v = queue.poll();

            Set<V> edges = this.vertices.get(v);
            if (!edges.isEmpty()) ans++;
            for (V edge : edges) {
                if (!visited.contains(edge)) {
                    visited.add(edge);
                    queue.offer(edge);
                }
            }
        }
        return ans;
    }


    // add vertex/node without any edge
    public void addEdge(V vertex) {
        this.vertices.put(vertex, new HashSet<>());
    }

    // add vertex with an edge to given particular vertex
    public void addEdge(V from, V to) {
        Set<V> edges = new HashSet<>();
        edges.add(to);
        this.addEdges(from, edges);
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

    public static void main(String[] args) {
        MinVertexCover<Character> min = new MinVertexCover<>();
        min.addEdge('B');
        min.addEdge('A');
        min.addEdge('C');
        min.addEdge('F');
        min.addEdge('G');
        min.addEdge('H');

        min.addEdge('B', 'A');
        min.addEdge('B', 'F');
        min.addEdge('A', 'C');
        min.addEdge('A', 'F');
        min.addEdge('C', 'F');
        min.addEdge('C', 'G');
        min.addEdge('F', 'H');
        min.addEdge('G', 'H');

        System.out.println(min.minVertexCover());

    }
}