package ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Pathfinder<T> {

    /**
     * Runs Dijkstra's algorithm on the source node of type {@link T} then extracts the path to the target node of type {@link T}.
     * @param source The source node of type {@link T} of the desired path.
     * @param target The target node of type {@link T} of the desired path.
     * @return An {@link Optional} describing the path between source {@link T} and target {@link T}, if any.
     * @throws IllegalArgumentException if one or both of the nodes don't exist in the graph.
     */
    Optional< List<T> > findShortestPath(T source, T target);
}
