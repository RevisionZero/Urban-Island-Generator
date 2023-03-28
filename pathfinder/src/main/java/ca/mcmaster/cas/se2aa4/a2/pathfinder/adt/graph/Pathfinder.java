package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import java.util.List;
import java.util.Optional;

public interface Pathfinder<T> {

    //Function to return a path from node1 to node2, if any
    Optional<List<T>> findPath(T node1, T node2);

    //Functionn to return the shortest path from node1 to node, if at least 1 path exists
    Optional<List<T>> findShortestPath(T node1, T node2);
}
