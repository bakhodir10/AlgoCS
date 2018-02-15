package ds.graph.adjacency_matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {

    private final int INITIAL_CAPACITY = 50;
    private Map<Integer, Integer> vertices;
    private boolean[][] arr;
    private int count;

    // default constructor
    public DirectedGraph() {
        this.arr = new boolean[INITIAL_CAPACITY][INITIAL_CAPACITY];
        this.vertices = new HashMap<>();
        this.count = 0;
    }

    // add vertex/node without any edge
    public void addEdge(Integer vertex) {
        if (vertex == null) throw new NullPointerException("Vertex cannot be null");
        boolean existVertex = this.vertices.containsKey(vertex);
        if (!existVertex) this.vertices.put(vertex, count);
        count++;
    }

    // add vertex/node with an edge
    public void addEdge(Integer from, Integer to) {
        Integer indexOfFrom = this.vertices.get(from);
        if (indexOfFrom == null) {
            this.vertices.put(from, count);
            indexOfFrom = count;
            count++;
        }

        Integer indexOfTo = this.vertices.get(to);
        if (indexOfTo == null)
            throw new NullPointerException("The vertex " + to + " that is being added is not exist");
        arr[indexOfFrom][indexOfTo] = true;
    }

    // get edges of the vertex/node
    public Set<Integer> getEdges(Integer vertex) {
        Integer v = this.vertices.get(vertex);
        if (v == null) throw new NullPointerException("There is no vertex regarding to given input");
        Set<Integer> edges = new HashSet<>();
        for (int i = 0; i < arr[v].length; i++) {
            if (arr[v][i]) {
                for (Map.Entry<Integer, Integer> map : vertices.entrySet()) {
                    Integer key = map.getKey();
                    Integer value = map.getValue();
                    if (value == i) edges.add(key);
                }
            }
        }
        return edges;
    }

    // remove an edge of given a vertex/node
    public boolean deleteEdgeOfVertex(Integer vertex, Integer edge) {
        Integer posOfVertex = this.vertices.get(vertex);
        Integer posOfEdge = this.vertices.get(edge);
        if (posOfVertex == null || posOfEdge == null)
            throw new NullPointerException("There is no vertex regarding to given input");
        arr[posOfVertex][posOfEdge] = false;
        return true;
    }


    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(0);
        graph.addEdge(100);
        graph.addEdge(200, 100);
        graph.addEdge(300, 200);
        graph.addEdge(100, 300);
        graph.addEdge(300, 0);
        graph.addEdge(300, 100);
        System.out.println(graph.getEdges(300));
        graph.deleteEdgeOfVertex(300, 0);
    }
}