package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge;

public interface Edge<T> {

    boolean containsNode(T node);

    T getNode1();

    T getNode2();
}