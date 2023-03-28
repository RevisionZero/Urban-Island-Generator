package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph<T> {

    //Function to remove a node from the graph
    void removeNode(T node);

    //Function to add a node from the graph
    void addNode(T node);

    //Function to add an edge to the graph
    void addEdge(Edge<T> edge);

    //Function to remove an edge from the graph
    void removeEdge(Edge<T> edge);

    //Getter to get the graph's edges
    Map<T, Set< Edge<T> > > getEdges();

}
