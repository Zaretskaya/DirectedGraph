package com.task;

public class Edge {

    private String beginningVertexName;
    private int distance;

    Edge(String beginningVertexName, int distance) {
        setBeginningVertexName(beginningVertexName);
        setDistance(distance);
    }

    public String getBeginningVertexName() {
        return beginningVertexName;
    }

    public void setBeginningVertexName(String beginningVertexName) {
        this.beginningVertexName = beginningVertexName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    public boolean equals(Edge otherEdge) {
        if (this.beginningVertexName.equals(otherEdge.getBeginningVertexName()) &&
                this.distance == otherEdge.getDistance()) {
            return true;
        } else return false;
    }


}