package com.task;

import java.util.*;

public class DirectedGraph {

    private Map<String, List<Edge>> vertexMap = new HashMap<String, List<Edge>>();

    private Set keys = vertexMap.keySet();

    public boolean hasVertex(String vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    public boolean hasEdge(String vertexName1, Edge edge) {
        if (!hasVertex(vertexName1)) return false;
        List<Edge> edges = vertexMap.get(vertexName1);
        return edges.contains(edge);
    }

    public void addVertex(String vertexName) {
        if (!hasVertex(vertexName))
            vertexMap.put(vertexName, new ArrayList<Edge>());
        keys = vertexMap.keySet();
    }


    public void addEdge(String vertexName1, String vertexName2, int distance) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);
        List<Edge> edges1 = vertexMap.get(vertexName1);
        Edge edge = new Edge(vertexName2, distance);
        if (!hasEdge(vertexName1, edge)) {
            edges1.add(edge);
            vertexMap.remove(vertexName1);
            vertexMap.put(vertexName1, edges1);
        }
        keys = vertexMap.keySet();
    }

    public Map<String, List<Edge>> getVertexMap() {
        return vertexMap;
    }

    public List<Edge> adjacentEdges(String vertexName) {
        return vertexMap.get(vertexName);
    }

    public List<Edge> outgoingEdges(String vertexName) {
        List<Edge> result = new ArrayList<>();
        for (Object key : keys) {
            List<Edge> list = vertexMap.get(key);
            for (Edge element : list) {
                if (element.getBeginningVertexName().equals(vertexName)) {
                    result.add(new Edge(key.toString(), element.getDistance()));
                }
            }
        }
        return result;
    }

    public void changeVertexName(String oldVertexName, String newVertexName) {
        for (Object key : keys) {
            List<Edge> list = vertexMap.get(key);
            for (Edge edge : list) {
                if (edge.getBeginningVertexName().equals(oldVertexName)) {
                    edge.setBeginningVertexName(newVertexName);
                }
            }
        }
        List<Edge> list = vertexMap.get(oldVertexName);
        vertexMap.put(newVertexName, list);
        vertexMap.remove(oldVertexName);
    }

    public void deleteVertex(String vertexName) {
        vertexMap.remove(vertexName);
        for (Object key : keys) {
            List<Edge> list = vertexMap.get(key);
            for (Edge edge : list) {
                if (edge.getBeginningVertexName().equals(vertexName)) {
                    list.remove(vertexName);
                    vertexMap.put(key.toString(), list);
                }
            }
        }
    }

    public void deleteEdge(String vertexName1, Edge edge) {
        for (Object key : keys) {
            if (vertexName1.equals(key)) {
                List<Edge> list = vertexMap.get(key);
                for (Edge element : list) {
                    if (element.equals(edge)) {
                        list.remove(element);
                        return;
                    }
                }
            }
        }
    }

}
