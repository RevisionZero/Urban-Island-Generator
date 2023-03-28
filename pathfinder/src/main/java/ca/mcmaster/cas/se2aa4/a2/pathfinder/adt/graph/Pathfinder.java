package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import java.util.List;
import java.util.Optional;

public interface Pathfinder<T> {

    Optional<List<T>> findPath(T node1, T node2);

    Optional<List<T>> findShortestPath(T node1, T node2);
}
