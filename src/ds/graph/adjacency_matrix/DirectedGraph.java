package ds.graph.adjacency_matrix;

import java.util.HashMap;
import java.util.Map;

public class DirectedGraph {
    private final int INITIAL_CAPACITY = 50;
    private Map<Integer, Integer> vertices;
    private boolean[][] arr;
    private int count;

    public DirectedGraph() {
        this.arr = new boolean[INITIAL_CAPACITY][INITIAL_CAPACITY];
        this.vertices = new HashMap<>();
        this.count = 0;
    }

    // add vertex/node with an edge
    public void addEdge(Integer vertex, Integer edge) {
        if (vertex == null) throw new NullPointerException("Vertex cannot be null");

        boolean existVertex = this.vertices.containsKey(vertex);
        int indexOfVertex = count;
        if (!existVertex) this.vertices.put(vertex, count);
        else indexOfVertex = this.vertices.get(vertex);

        boolean existEdge = this.vertices.containsKey(edge);
        if (edge != null && !existEdge)
            throw new NullPointerException("The edge " + edge + " that is being added is not exist");

        Integer indexOfEdge = this.vertices.get(edge);
        if (indexOfEdge != null) arr[indexOfVertex][indexOfEdge] = true;
        count++;
    }


    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(0, null);
        graph.addEdge(100, null);
        graph.addEdge(200, 100);
        graph.addEdge(300, 200);
        graph.addEdge(100, 300);
        graph.addEdge(100, 300);
    }
}