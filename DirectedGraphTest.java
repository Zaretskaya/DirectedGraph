package com.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class DirectedGraphTest {

    @Test
    void addVertex() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        assertFalse(graph.getVertexMap().isEmpty() || !graph.hasVertex("A") || !graph.hasVertex("B"));
    }

    @Test
    void addEdge() throws Exception {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("B", "A", 5);
        graph.addEdge("C", "B", 10);


        assertFalse(graph.getVertexMap().get("B").isEmpty() || graph.getVertexMap().get("C").isEmpty());
        assertFalse(!graph.hasEdge("B", new Edge("A", 5)));
        assertFalse(!graph.hasEdge("C", new Edge("B", 10)));
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

        assertFalse(!graph.hasEdge("B", new Edge("E", 5)) ||
                !graph.hasEdge("K", new Edge("B", 10)));

        assertFalse(graph.hasVertex("A") || graph.hasVertex("C"));
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

        assertFalse(graph.hasVertex("B"));
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

        assertFalse(graph.hasEdge("B", new Edge("A", 5)));
    }
}