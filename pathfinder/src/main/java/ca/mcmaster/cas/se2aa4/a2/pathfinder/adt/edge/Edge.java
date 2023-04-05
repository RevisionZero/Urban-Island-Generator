package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge;

public interface Edge<T> {

    /**
     *
     * @param node The node of type {@link T} to check in the edge.
     * @return {@code true} if the node of type {@link T} is in the {@link Edge}, otherwise returns {@code false}.
     */
    boolean containsNode(T node);

    /**
     *
     * @return The first node of type {@link T} of the edge.
     */
    T getNode1();

    /**
     *
     * @return The second node of type {@link T} of the edge.
     */
    T getNode2();

    /**
     *
     * @return {@code true} if the {@link Edge} is weighted, otherwise returns {@code false}.
     */
    boolean isWeighted();

    /**
     *
     * @return The weight of the {@link Edge}. If the {@link Edge} is unweighted, returns 1.
     */
    double getWeight();
}