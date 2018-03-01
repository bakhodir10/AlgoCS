package ds.graph;

import java.util.*;
import java.util.stream.Collectors;

// todo not finished
public class GraphBFS {

    private Map<Vertex, Set<Vertex>> vertices;

    public GraphBFS() {
        this.vertices = new HashMap<>();
    }

    public void addEdge(Integer element) {
        this.addEdges(element, new HashSet<>());
    }

    // add vertex with an edge to given particular vertex
    public void addEdge(Integer from, Integer to) {
        Set<Integer> elements = new HashSet<>();
        elements.add(to);
        this.addEdges(from, elements);
    }

    // add vertex/node with set of edges
    public void addEdges(Integer element, Set<Integer> elements) {
        if (element == null) throw new NullPointerException("Vertex cannot be null");
        if (elements == null) elements = new HashSet<>();

        Set<Vertex> filter = elements.stream().filter(e -> {
            boolean b = vertices.containsKey(new Vertex(e));
            if (b) return true;
            else throw new NullPointerException("The edge " + e + " that is being added is not exist");
        })
                .map(Vertex::new)
                .collect(Collectors.toSet());

        Vertex vertex = new Vertex(element);
        if (this.vertices.containsKey(vertex)) this.vertices.get(vertex).addAll(filter);
        else this.vertices.put(vertex, filter);
    }

    public void bfs(Integer element) {
        boolean exist = this.vertices.containsKey(new Vertex(element));
        if (!exist) throw new NullPointerException("The vertex is not exist");

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(element));

//        while (!queue.isEmpty()) {
//            Vertex v = queue.poll();
//            System.out.println(v.getData());
//            Set<Vertex> edges = this.vertices.get(v);
//            for (Vertex edge : edges) {
//                if (!edge.isVisited()) {
//                    for (Map.Entry<Vertex, Set<Vertex>> map : this.vertices.entrySet()) {
//                        if (map.getKey().equals(edge)) {
//                            map.getKey().setVisited(true);
//                            edge.setVisited(true);
//                            break;
//                        }
//                    }
//                    queue.add(edge);
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();
        graph.addEdge(0);
        graph.addEdge(100);
        graph.addEdge(200);
        graph.addEdge(300);

        graph.addEdge(0, 100);
        graph.addEdge(0, 200);
        graph.addEdge(100, 0);
        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 0);
        graph.addEdge(200, 100);
        graph.addEdge(200, 300);
        graph.addEdge(300, 100);
        graph.addEdge(300, 200);

        graph.bfs(0);
    }
}