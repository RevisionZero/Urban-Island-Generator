package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface Graph<T> {

    /**
     *
     * @param node The node of type {@link T} to remove from the graph.
     */
    void removeNode(T node);

    /**
     *
     * @param node The node of type {@link T} to add to the graph.
     */
    void addNode(T node);

    /**
     *
     * @param edge The {@link Edge} of type {@link T} to add to the graph.
     */
    void addEdge(Edge<T> edge);

    /**
     *
     * @param edge The {@link Edge} to remove from the graph.
     */
    void removeEdge(Edge<T> edge);

    /**
     *
     * @return The {@link Set} of {@link Edge} describing the graph's adjacency list.
     */
    Set< Edge<T> > getEdges();

    /**
     *
     * @return The {@link Set} of the graph's nodes of type {@link T}.
     */
    Set<T> getNodes();

    /**
     *
     * @param node The node of type {@link T} to use.
     * @return The {@link Set} of all {@link Edge} where the parameter node is a part of.
     */
    Set< Edge<T> > getAllEdges(T node);

    /**
     *
     * @return The string representation of the {@link Graph}.
     */
    String showGraph();

    /**
     *
     * @return {@code true} if the graph is weighted, else returns {@code false}
     */
    boolean isWeighted();

}
