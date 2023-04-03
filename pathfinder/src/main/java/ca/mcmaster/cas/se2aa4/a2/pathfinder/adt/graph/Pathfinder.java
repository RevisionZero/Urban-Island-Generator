package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Pathfinder<T> {

    /**
     *
     * @param source The source {@link T} of the desired path.
     * @param target The target {@link T} of the desired path.
     * @return An {@link Optional} describing the path between source {@link T} and target {@link T}, if any.
     */
    Optional< List<T> > findShortestPath(T source, T target);
}
