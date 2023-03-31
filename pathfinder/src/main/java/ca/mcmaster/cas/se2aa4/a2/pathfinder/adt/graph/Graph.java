package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface Graph<T> {

    /**
     *
     * @param node The {@link T} to remove from the graph.
     */
    void removeNode(T node);

    /**
     *
     * @param node The {@link T} to add to the graph.
     */
    void addNode(T node);

    /**
     *
     * @param edge The {@link Edge} to add to the graph.
     */
    void addEdge(Edge<T> edge);

    /**
     *
     * @param edge The {@link Edge} to remove from the graph.
     */
    void removeEdge(Edge<T> edge);

    /**
     *
     * @return Returns the {@link Map} describing the graph's adjacency list.
     */
    Set< Edge<T> > getEdges();

    Set<T> getNodes();

}
