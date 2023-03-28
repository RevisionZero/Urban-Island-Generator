package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface Graph<T> {

    void removeNode(T node);

    void addNode(T node);

    void addEdge(Edge<T> edge);

    void removeEdge(Edge<T> edge);

    HashMap<T, Set< Edge<T> > > getEdges();

}
