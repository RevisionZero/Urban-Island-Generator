package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge;

public interface Edge<T> {

    Edge getEdge();

    boolean containsNode(T node);
}