package com.task;

import org.junit.jupiter.api.Test;

class DirectedGraphTest {

    @Test
    void addVertex() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        if (graph.getVertexMap().isEmpty() || !graph.hasVertex("A") ||
                !graph.hasVertex("B")) throw new Exception("Incorrect addVertex() method");

    }

    @Test
    void addEdge() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("B", "A", 5);
        graph.addEdge("C", "B", 10);

        if (graph.getVertexMap().get("B").isEmpty() || graph.getVertexMap().get("C").isEmpty())
            throw new Exception("Incorrect addEdge() method");
        if (!graph.hasEdge("B", new Edge("A", 5)))
            throw new Exception("Incorrect addEdge() method");
        if (!graph.hasEdge("C", new Edge("B", 10)))
            throw new Exception("Incorrect addEdge() method");
    }

    @Test
    void changeVertexName() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("B", "A", 5);
        graph.addEdge("C", "B", 10);

        graph.changeVertexName("A", "E");
        graph.changeVertexName("C", "K");

        if (!graph.hasEdge("B", new Edge("E", 5)) ||
                !graph.hasEdge("K", new Edge("B", 10)))
            throw new Exception("Incorrect changeVertexName() method");

        if (graph.hasVertex("A") || graph.hasVertex("C"))
            throw new Exception("Incorrect changeVertexName() method");

    }

    @Test
    void deleteVertex() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("B", "A", 5);
        graph.addEdge("C", "B", 10);

        graph.deleteVertex("B");

        if (graph.hasVertex("B"))
            throw new Exception("Incorrect deleteVertex() method");
    }

    @Test
    void deleteEdge() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("B", "A", 5);
        graph.addEdge("C", "B", 10);
        graph.addEdge("C", "A", 17);

        graph.deleteEdge("B", new Edge("A", 5));

        if (graph.hasEdge("B", new Edge("A", 5)))
            throw new Exception("Incorrect deleteEdge() method");

    }
}