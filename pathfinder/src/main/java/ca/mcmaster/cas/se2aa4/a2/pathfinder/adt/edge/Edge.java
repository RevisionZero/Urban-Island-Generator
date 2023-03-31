package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge;

public interface Edge<T> {

    /**
     *
     * @param node The {@link T} to check in the edge.
     * @return True if {@link T} is in the edge, otherwise returns false.
     */
    boolean containsNode(T node);

    /**
     *
     * @return The first node of the edge.
     */
    T getNode1();

    /**
     *
     * @return The second node of the edge.
     */
    T getNode2();

    boolean isWeighted();

    double getWeight() throws IllegalArgumentException;
}