package com.task;

import java.util.*;

public class DirectedGraph {

    private Map<String, List<Edge>> vertexMap = new HashMap<String, List<Edge>>();

    private Set keys = vertexMap.keySet();

    public DirectedGraph() {
        this.vertexMap = new HashMap<String, List<Edge>>();
    }


    public Set getKeys() {
        Set copy1 = keys;
        return copy1;
    }


    public boolean hasVertex(String vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    public boolean hasEdge(String endVertexName, Edge edge) {
        if (!hasVertex(endVertexName)) return false;
        List<Edge> edges = vertexMap.get(endVertexName);
        for (Edge element : edges) {
            if (element.equals(edge)) {
                return true;
            }
        }
        return false;
    }

    public void addVertex(String vertexName) {
        if (!hasVertex(vertexName))
            vertexMap.put(vertexName, new ArrayList<Edge>());
    }


    public void addEdge(String endVertexName, String begVertexName, int distance) {
        if (!hasVertex(endVertexName)) addVertex(endVertexName);
        if (!hasVertex(begVertexName)) addVertex(begVertexName);

        List<Edge> edges1 = vertexMap.get(endVertexName);
        Edge edge = new Edge(begVertexName, distance);
        if (!hasEdge(endVertexName, edge)) {
            edges1.add(edge);
            vertexMap.remove(endVertexName);
        }
    }

    public Map<String, List<Edge>> getVertexMap() {
        return new HashMap<>(vertexMap);
    }

    public List<Edge> adjacentEdges(String vertexName) {
        Map<String, List<Edge>> copy = vertexMap;
        return copy.get(vertexName);
    }

    public List<Edge> outgoingEdges(String vertexName) {
        List<Edge> result = new ArrayList<>();
        for (Map.Entry<String, List<Edge>> entry : vertexMap.entrySet()) {
            for (Edge element : entry.getValue()) {
                if (element.getBeginningVertexName().equals(vertexName)) {
                    result.add(new Edge(entry.getKey(), element.getDistance()));
                }
            }
        }
        return result;
    }

    public void changeVertexName(String oldVertexName, String newVertexName) {
        for (Map.Entry<String, List<Edge>> entry : vertexMap.entrySet()) {
            for (Edge edge : entry.getValue()) {
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
        for (Map.Entry<String, List<Edge>> entry : vertexMap.entrySet()) {
            ArrayList<Edge> removeList = new ArrayList<>();
            for (Edge edge : entry.getValue()) {
                if (edge.getBeginningVertexName().equals(vertexName)) {
                    removeList.add(edge);
                }
            }
            for (Edge edge : removeList) {
                entry.getValue().remove(edge);
            }
        }
    }

    public void deleteEdge(String endVertexName, Edge edge) {
        List<Edge> list = vertexMap.get(endVertexName);
        for (Edge element : list) {
            if (element.equals(edge)) {
                list.remove(element);
                return;
            }
        }
    }
}





