package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;

import java.util.*;

public class DirectedGraph<T> extends AbstractGraph<T> {

    public DirectedGraph (Set<T> nodes){
        super(nodes);
    }

    /**
     *
     * If the {@link Set} of {@link Edge} contains nodes not in the {@link Set} of {@link T}, they will be added.
     * @param nodes The {@link Set} of {@link T} nodes to use to create the graph.
     * @param edges The {@link Set} of {@link Edge} to add to the graph.
     * @throws IllegalArgumentException if the set of edges contains an undirected edge.
     */
    public DirectedGraph(Set<T> nodes, Set< Edge<T>> edges) throws IllegalArgumentException{

        super(nodes,edges);

        if(edges.contains(UndirectedEdge.class)){
            throw new IllegalArgumentException("The set of edges contains an undirected edge!");
        }
    }

    @Override
    public Optional<List<T>> findPath(T source, T target) {
        return Optional.empty();
    }

    @Override
    public Optional<List<T>> findShortestPath(T source, T target) {
        return Optional.empty();
    }
}
